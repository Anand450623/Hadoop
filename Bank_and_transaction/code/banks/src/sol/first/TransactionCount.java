package sol.first;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TransactionCount 
{
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException 
	{
		
		 Configuration conf = new Configuration();
	     Job job = new Job(conf, "Reduce-side join");
	     job.setJarByClass(TransactionCount.class);
	     job.setReducerClass(Reduce.class);
	     job.setOutputKeyClass(Text.class);
	     job.setOutputValueClass(Text.class);
	     
	     MultipleInputs.addInputPath(job, new Path(args[0]),TextInputFormat.class, CustomerMapper.class);
	     MultipleInputs.addInputPath(job, new Path(args[1]),TextInputFormat.class, TransactionMapper.class);
	     
	     Path outputPath = new Path(args[2]);
	     FileOutputFormat.setOutputPath(job,outputPath);
	     outputPath.getFileSystem(conf).delete(outputPath);
	     
	     System.exit(job.waitForCompletion(true) ? 0 : 1); 
				
	}
	
}
