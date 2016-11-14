<%--
  Created by IntelliJ IDEA.
  User: Charles.Chen
  Date: 5/10/16
  Time: 2:54 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:form url="${webRequest.contextPath}/j_spring_security_check">
    <input name="j_username" type="text" value="usera" required/>
    <input name="j_password" type="password" value="usera" required/>
    <input type="submit" value="submit">
</g:form>
</body>
</html>