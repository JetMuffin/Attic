<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%
		JSONArray jsonStrs = new JSONArray();
		JSONObject obj1=new JSONObject();
		obj1.put("option","A");
		obj1.put("answer","compared");
		JSONObject obj2=new JSONObject();
		obj2.put("option","B");
		obj2.put("answer","comparing");
		JSONObject obj3=new JSONObject();
		obj3.put("option","C");
		obj3.put("answer","compares");
		JSONObject obj4=new JSONObject();
		obj4.put("option","D");
		obj4.put("answer","being compared");
       	jsonStrs.add(0, obj1);
        jsonStrs.add(1, obj2);
        jsonStrs.add(2, obj3);
        jsonStrs.add(3, obj4);
	
    out.print(jsonStrs);
    out.flush();
%>