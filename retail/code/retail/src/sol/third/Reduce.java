package sol.third;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<IntWritable,Text,Text,Text> 
{

	public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{	
		
		Iterator<Text> iterator = values.iterator();
		
		String cname = null;
		Integer sum = 0;
		Integer freq = 0;
		
		while(iterator.hasNext())
		{
	
			Text value = iterator.next();			
			String[] content = value.toString().split("\t");
			
			if(content[0].equals("address"))
			{
				cname = content[1];
			}
			else
			{
				freq++;
				sum += Integer.parseInt(content[1]);
			}
			
		}
		
		String res = String.format("%s\t%d\t%d", cname,freq,sum);
		context.write(new Text(key.toString()), new Text(res));
		
	}
	
}
