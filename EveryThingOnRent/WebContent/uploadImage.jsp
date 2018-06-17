<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
    <h1>Upload Image</h1>
    <center><img src="1st.png" alt="file not found" class="imgclass" /></center>
    <center></center>
    <form method="post" action="uploadser"
        enctype="multipart/form-data">
        <table>
        <tr>
        <%	
        String userid=request.getParameter("id");
        String flag=request.getParameter("flag");
        	%>
        	<td><input type=hidden name=userid value="<%out.print(userid);%>"/></td>
        	<input type=hidden name=flag value="<%out.print(flag); %>"/>
                <tr>
                <td>Choose Image:</td>
                <td><input type="file" name="photo" size="10"
                    required="required" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
    </center>
</body>
</html>
