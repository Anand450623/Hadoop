package sol.third;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SaleMapper extends Mapper<Object,Text,IntWritable,Text>  
{
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException
	{
		String[] content = value.toString().split(",");
		Integer id = Integer.parseInt(content[0]);
		String price = content[6];
		
		context.write(new IntWritable(id), new Text("sale\t"+price));
	}
}
