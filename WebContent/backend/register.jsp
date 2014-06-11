<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  <body>  
        <center>  
            <h1>  
                注册界面  
            </h1>  
            <hr color="blue">  
            <form action="./login.do">  
                <input type="hidden" name="methodName" value="1" />  
                <table border="1px">  
                    <tr>  
                        <td>  
                            用户名：  
                        </td>  
                        <td>  
                            <input type="text" name="name" />  
                        </td>  
                    </tr>  
                    <tr>  
                        <td>  
                            密码：  
                        </td>  
                        <td>  
                            <input type="password" name="pass" />  
                        </td>  
                    </tr>  
                </table>  
                <input type="submit" value="注册" />  
            </form>  
        </center>  
    </body>  
</html>