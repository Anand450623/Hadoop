package sol.third;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class ReduceJoin 
{
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException 
	{
		
		Configuration conf = new Configuration();
		
		String input1 = args[0];
		String input2 = args[1];
		String output = args[2];		
		
		Job job  = new Job(conf, "join");
		job.setJarByClass(ReduceJoin.class);
		job.setReducerClass(Reduce.class);
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Text.class);		
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		MultipleInputs.addInputPath(job, new Path(input1), TextInputFormat.class, AddressMapper.class);
		MultipleInputs.addInputPath(job, new Path(input2), TextInputFormat.class, SaleMapper.class);
		
		Path outPath = new Path(output);
		FileOutputFormat.setOutputPath(job, outPath);
		outPath.getFileSystem(conf).delete(outPath);
		
		System.exit(job.waitForCompletion(true)?0:1);
		
	}
	
}
