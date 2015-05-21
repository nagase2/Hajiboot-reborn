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
<a href="/jsptest2">move to jsptest2</a>

<br>
<%=3 * 4 * 5%>
<br>

<hr/>
<!-- foodFormは、Controllerクラスで指定。 -->
  <form:form modelAttribute="foodForm" action="${pageContext.request.contextPath}/jsptest1">
    <form:label path="name">Input Your Name:</form:label>
    <form:input path="name" />
     <form:errors path="name" cssStyle="color:red" /><!-- (1) -->
     <br>
        <form:label path="color">Input Your color:</form:label>
    <form:input path="color" />
     <form:errors path="color" cssStyle="color:red" /><!-- (1) -->
     <br>
    <input type="submit" />
  </form:form>
</form>
<hr>
food.name = ${food.name}<br>
<!-- インジェクション対策のため、こちらを使うこと -->
food.color =<c:out value="${food.color}" />
<br>
<!-- if文の書き方 -->
<c:if test="${result == false }">
エラーはありませんでした！
</c:if>

 
</body>
</html>