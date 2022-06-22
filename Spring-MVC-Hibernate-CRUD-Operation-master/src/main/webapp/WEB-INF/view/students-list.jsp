<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Student List</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
	<div class="container">
		<div class="wrapper">
			<header class="header">
				<h2>Details</h2>
			</header>
			<div class="content">
				<a href="show-student-form" class="btn">Add Student</a>
				<table>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<c:forEach var="student" items="${students}">
						<c:url var="updateLink" value="/student/update-form">
							<c:param name="id" value="${student.id}" />
						</c:url>
						<c:url var="deleteLink" value="/student/delete">
							<c:param name="id" value="${student.id}" />
						</c:url>
						<tr>
							<td>${student.name}</td>
							<td>${student.email}</td>
							<td><a href="${updateLink}" class="btn-link">Update</a> | <a
								href="${deleteLink}" class="btn-link"
								onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="content">
				<a href="/student/teacher/show-teacher-form" class="btn">Add Teacher</a>
				<table>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<c:forEach var="teacher" items="${teachers}">
						<c:url var="updateLink" value="/student/teacher/update-form">
							<c:param name="id" value="${teacher.id}" />
						</c:url>
						<c:url var="deleteLink" value="/student/teacher/delete">
							<c:param name="id" value="${teacher.id}" />
						</c:url>
						<tr>
							<td>${teacher.name}</td>
							<td>${teacher.email}</td>
							<td><a href="${updateLink}" class="btn-link">Update</a> | <a
								href="${deleteLink}" class="btn-link"
								onclick="if(!(confirm('Are you sure you want to delete this teacher?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>


		</div>
	</div>
</body>