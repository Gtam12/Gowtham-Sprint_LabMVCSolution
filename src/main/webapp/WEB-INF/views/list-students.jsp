<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>

	<h1>Library Management System</h1>

	<h2>
		List of students <a href="/lmsv3/students/new"
			class="btn btn-primary btn-sm float-end">Add a student</a>
	</h2>

	<table class="table table-bordered table-srtiped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Department</th>
				<th>Country</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${ students }" var="student">
				<tr>
					<td><c:out value="${student.name }"></c:out></td>
					<td><c:out value="${student.department }"></c:out></td>
					<td><c:out value="${student.country }"></c:out></td>

					<td><a href="/lmsv3/students/edit?id=${student.id}"
						class="btn btn-secondary btn-sm">Update</a> <a
						href="/lmsv3/students/delete?id=${student.id}"
						class="btn btn-danger btn-sm">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>