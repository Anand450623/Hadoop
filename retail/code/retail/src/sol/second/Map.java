package sol.second;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map  extends Mapper<Object,Text,Text,Text> 
{
	public void map(Object key,Text value, Context context) throws IOException, InterruptedException
	{	
		String[] content = value.toString().split(",");
		context.write(new Text(content[6]), value);
	}
}
