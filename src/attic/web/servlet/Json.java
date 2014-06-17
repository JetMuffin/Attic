package attic.web.servlet;

import java.util.HashMap;
import java.util.Map;
 

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Json {
		public void jsonTest() { 
		JSONObject obj=new JSONObject();
		obj.put("name","foo");
		obj.put("num",new Integer(100));
		obj.put("balance",new Double(1000.21));
		obj.put("is_vip",new Boolean(true));
		obj.put("nickname",null);
		System.out.print(obj); 
	}
}
