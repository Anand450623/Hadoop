package sol.first;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map  extends Mapper<Object,Text,Text,FloatWritable> 
{
	public void map(Object key,Text value, Context context) throws IOException, InterruptedException
	{
		String cname = value.toString().split(",")[1];
		Float purchase = new Float(value.toString().split(",")[6]);		
		context.write(new Text(cname), new FloatWritable(purchase));
	}
}
