
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>


<!-- to be added for bootstrap  -->
<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"
	rel="stylesheet">



<title>ToDos Page</title>
</head>

<body>

	<div class="container">                     <!--bootstrap -->
	
	

		<div>Welcome ${name_e }</div>
		<!-- Session Scope concept used... -->

		<hr>
		<h1>Your ToDos are:</h1>
		</hr>
		<!-- not needed -->

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id }</td>
						<td>${todo.description }</td>
						<td>${todo.targetDate }</td>
						<td>${todo.done}</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		
		<a href="add-todo" class="btn btn-success">Add Todo</a>

	</div>



	<!-- to be added for bootstrap  -->
	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>     

	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>


</body>

</html>