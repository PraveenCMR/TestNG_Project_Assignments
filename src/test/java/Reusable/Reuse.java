package Reusable;

public class Reuse {
	public String CreatePostJson(String name,String year,String DOB,String Address,String Salary)
	{
		String body ="{\n" +
				"    \"name\":\""+name+"\",\n" +
				"    \"data\":{\n" +
				"        \"year\": "+year+",\n" +
				"        \"DOB\": \""+DOB+"\",\n" +
				"        \"Address\": \""+Address+"\",\n" +
				"        \"Salary\": \""+Salary+"\"\n" +
				"    }\n" +
				"}";
		return body;
	}
}
