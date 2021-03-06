package sol.second;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class PartitionSale
{
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException 
	{	
		
		Configuration conf = new Configuration();
		
        String input = args[0];
        String output = args[1];
        
        Job job = new Job(conf, "Avg");
        
        job.setJarByClass(PartitionSale.class);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        job.setNumReduceTasks(4);
        
        job.setMapperClass(Map.class);     
        job.setPartitionerClass(Partition.class);
        //job.setCombinerClass(Reduce.class);       
        job.setReducerClass(Reduce.class);        

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        FileInputFormat.setInputPaths(job, new Path(input));
        Path outPath = new Path(output);
        FileOutputFormat.setOutputPath(job, outPath);
        outPath.getFileSystem(conf).delete(outPath, true);
        
        job.waitForCompletion(true);
        
        return;
		
	}

}
