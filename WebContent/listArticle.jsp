<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Article</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List Articles</h3>
			<hr>
			<div class="container text-left">

		<a href="<%=request.getContextPath()%>/insert" class="btn btn-success">Ajouter nouveau Article</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Description</th>
						<th>Etat</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="article" items="${listArticle}">
						<tr>
							<td><c:out value="${article.idArticle}" /></td>
							<td><c:out value="${article.nomArticle}" /></td>
							<td><c:out value="${article.DescriptionArticle}"/> </td>
							<td><c:out value="${article.EtatArticle}" /></td>
							<td>
								<a href="edit?idArticle=<c:out value='${article.idArticle}' />">Modifier</a>
							 	<a href="delete?idArticle=<c:out value='${article.idArticle}' />">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>