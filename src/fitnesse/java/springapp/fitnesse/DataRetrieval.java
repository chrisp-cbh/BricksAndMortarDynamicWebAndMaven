package springapp.fitnesse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DataRetrieval 
{
	public static List<Object> query(List<Object> objectList)
	{
		List<Object> list = new ArrayList<Object>();
		
		for (Object object : objectList)
		{
			list.add(buildSingleObjectList(object));
		}
		
		return list;
	}
	
	public static List<Object> buildSingleObjectList(Object object)
	{
		List<Object> returnList = new ArrayList<Object>();
		
		Field[] attributes = object.getClass().getDeclaredFields();
		
		for (Field field : attributes)
		{
			String value;
			String name;
			
			try
			{
				name = field.getName();
				value = field.get(object).toString();
				
				returnList.add(buildSingleObject(name, value));
			}
			catch (Exception e)
			{
				// throw new Exception(e.getMessage());
			}
		}
		
		return returnList;
	}
	
	private static List<Object> buildSingleObject(String name, String value)
	{
		List<Object> list = new ArrayList<Object>();
		
		list.add(name);
		list.add(value);
		
		return list;
	}
}
