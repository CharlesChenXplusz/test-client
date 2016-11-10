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
<g:form url="${webRequest.contextPath}/login">
    <input name="username" type="text" value="usera" required/>
    <input name="password" type="password" value="usera" required/>
    <input type="submit" value="submit">
</g:form>
</body>
</html>