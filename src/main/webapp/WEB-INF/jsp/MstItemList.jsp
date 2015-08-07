<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<!DOCTYPE html>
<html>
<head profile="http://www.w3.org/2005/10/profile">
<title>次世代開発基盤</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
	$(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<style type="text/css">
.bs-example {
	margin: 20px;
}
</style>
<link rel="icon" type="image/png" href="icon.png">
</head>
<body>
	sssss
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>#</th>
				<th>#</th>
				<th>#</th>
			</tr>
			</thead>
			<c:forEach var="item" items="${items}">
				<tr>
					<th>${item.itemId}</th>
					<th>${item.itemName}</th>
					<th>${item.mstItemType.itemTypeName}</th>
					<th>${item.itemName}</th>					
					<th>${item.itemName}</th>
									</tr>
			</c:forEach>
	</table>

</body>
</html>