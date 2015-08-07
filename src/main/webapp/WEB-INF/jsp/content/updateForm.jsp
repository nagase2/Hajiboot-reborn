<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<title>JS Bin</title>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="list">JPA Test</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">一覧表示処理 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="list">全件表示</a></li>
							<li><a href="search">一覧表示（検索＆ページ）</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">（できれば…）順番に読み込み</a></li>
							<li><a href="#">一覧表示</a></li>
							<li><a href="#">一覧表示（ページなし）</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">登録処理<span class="caret"></span></a>
						<ul class="dropdown-menu">

							<li><a href="#">登録処理（１件）</a></li>
							<li><a href="#">登録処理（５件：トランザクション）</a></li>

						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">更新処理 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">更新処理（１件）</a></li>
							<li><a href="#">更新処理（５件）</a></li>

						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">

					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<form:form action="update" method="POST">

		<div class="form-group">
			<div class="col-xs-4">
				ID <input type="text" class="form-control" placeholder="Content ID"
					name="contentId" value="${contentForm.contentId}" readonly >
			</div>
			<div class="col-xs-4">
				Content 名 <input type="text" class="form-control"
					placeholder="Content Name" name="contentName"
					value="${contentForm.contentName}">
			</div>
			<div class="col-xs-4">
			　数量 <input type="text" class="form-control"
					placeholder="comment" name="count" value="${contentForm.count}">
			</div>
			<div class="col-xs-4">
				Comment <input type="text" class="form-control"
					placeholder="comment" name="comment" value="${contentForm.comment}">
			</div>
			
		</div>
		<hr/>
		<div class="form-group">
			<div class="col-xs-4">
				価格 <input type="text" class="form-control" placeholder=".col-xs-3"
					value="${contentForm.mstItem.price}">
			</div>
			<div class="col-xs-4">
				アイテム名称 <input type="text" class="form-control"
					placeholder=".col-xs-3" value="${contentForm.mstItem.itemName}">
			</div>
			<div class="col-xs-4">
				カテゴリ <input type="text" class="form-control" placeholder=".col-xs-3"
					name="category"
					value="${contentForm.mstItem.mstItemType.itemTypeName}">
			</div>
			<div class="col-xs-4">
				Item ID <input type="text" class="form-control" placeholder=".col-xs-3"
					name="mstItem.itemId"
					value="${contentForm.mstItem.itemId}">
			</div>
		</div>



		<div class="col-sm-12">version:${contentForm.version}
		<input type="hidden" name ="version" value="${contentForm.version}">
		</div>

		<div class="col-sm-12">
			<button type="submit" class="btn btn-primary">データ更新</button>
			<!-- Indicates a dangerous or potentially negative action -->
			<button type="button" class="btn btn-danger">キャンセル</button>
		</div>
		
	</form:form>