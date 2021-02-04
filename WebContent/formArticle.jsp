<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title> 
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="bootstrap/myStyle/mYstyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Article</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${article != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${article == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${article != null}"> Modifier Article 	</c:if>
						<c:if test="${article == null}"> Ajouter nouveau Article </c:if>
					</h2>
				</caption>

				<%-- <c:if test="${article != null}">
					<input type="hidden" name="idArticle" value="<c:out value='${article.idArticle}' />" />
				</c:if>
 --%>

				<fieldset class="form-group">
				
					<label>ID Article</label> <input type="text" value="<c:out value='${article.idArticle}' />" class="form-control"
						name="idArticle" required="required">
				</fieldset>
				
				<fieldset class="form-group">
				
					<label>Nom Article</label> <input type="text" value="<c:out value='${article.nomArticle}' />" class="form-control"
						name="nomArticle" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Description Article</label> <input type="text"value="<c:out value='${article.DescriptionArticle}' />" class="form-control"
						name="DescriptionArticle">
				</fieldset>

				<fieldset class="form-group">
					<label>Etat Article</label> <input type="text"
						value="<c:out value='${article.EtatArticle}' />" class="form-control"
						name="EtatArticle">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>