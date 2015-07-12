<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <meta charset="utf-8">
  <title>JS Bin</title>
</head>
<body>
  
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="list">JPA Test</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
           <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">一覧表示処理 <span class="caret"></span></a>
          <ul class="dropdown-menu">
			<li><a href="list">全件表示</a></li>
            <li><a href="search">一覧表示（検索＆ページ）</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">（できれば…）順番に読み込み</a></li>
             <li><a href="#">一覧表示</a></li>
            <li><a href="#">一覧表示（ページなし）</a></li>
          </ul>
        </li>
       
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">登録処理<span class="caret"></span></a>
          <ul class="dropdown-menu">
          
            <li><a href="#">登録処理（１件）</a></li>
            <li><a href="#">登録処理（５件：トランザクション）</a></li>
         
          </ul>
        </li>
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">更新処理 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">更新処理（１件）</a></li>
            <li><a href="#">更新処理（５件）</a></li>
      
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
 
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<h2>コンテンツ一覧</h2>
  <hr>
<form action="search" method="GET" class="form-inline">
  <div class="form-group">
    <label for="exampleInputName2">Content Name</label>
    <input type="text" name="contentName" value="${form.contentName}" class="form-control" id="exampleInputName2" placeholder="検索条件入力してね">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">品名</label>
    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
  </div>       　
  <button type="submit" class="btn btn-default">検索</button>
</form>
  <hr>
  
  
  	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Content Name</th>
				<th>コメント</th>
				<th>価格</th>
				<th>アイテム名称</th>
				<th>カテゴリ</th>
			</tr>
			</thead>
			<c:forEach var="item" items="${contents.content}">
				<tr>
					<th>${item.contentId}</th>
					<th>${item.contentName}</th>
					<th>${item.comment}</th>
					<th>${item.mstItem.price}</th>
					<th>${item.mstItem.itemName}</th>					
					<th>${item.mstItem.mstItemType.itemTypeName}</th>
									</tr>
			</c:forEach>
	</table>
  
  
  
  
  
  <nav align="center">
  <ul class="pagination">
    <li>
  <!--    <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span> -->
      </a>
    </li>
    <li><a href="?page=0">1</a></li>
    <li><a href="?page=1">2</a></li>
    <li><a href="?page=2">3</a></li>
    <li><a href="?page=3">4</a></li>
    <li><a href="?page=4">5</a></li>
    <li>
      <!-- <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span> -->
      </a>
    </li>
  </ul>
</nav>
</body>
</html>