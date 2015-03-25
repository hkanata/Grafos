<%@ page import="javax.servlet.http.HttpServletRequest" %>

<%
	String currentUrl = request.getRequestURL().toString();

%>

<nav>
	<ul class="nav nav-pills pull-right">
		<li role="presentation" class="<%=(currentUrl.contains("index")) ? "active" : "" %>"><a href="index.jsp">Home</a></li>
		<li role="presentation" class="<%=(currentUrl.contains("exercise")) ? "active" : "" %>"><a href="exercise.jsp">Exercise</a></li>
	</ul>
</nav>
<h3 class="text-muted">Trains</h3>