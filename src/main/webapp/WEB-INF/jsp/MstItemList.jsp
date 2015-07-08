<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>xxxxxx</title>
</head>
<body>
sssss
<c:forEach var="item" items="${items}">
<li>
	${item.key}-${item.value}<br>
	</li>
</c:forEach>
 
</body>
</html>