package sol.second;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, Text, Text, Text>  
{
	public void reduce(Text key, Iterable<Text>  values, Context context) throws IOException, InterruptedException
	{
		String content = "";
		for(Text t:values) 
		{
			content += t.toString()+"\n";
		}
		context.write(new Text(content),null);
	}
}
