<%@page import="main.Trains"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="assets/favicon.ico">

    <title>Trains</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/jumbotron-narrow.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  
    <div class="container">
      <div class="header">
        <%@ include file="includes/menu.jsp" %>
      </div>

      <div class="jumbotron">
        <h1>Initial</h1>
        <p class="lead">
        	System Trains Router
        </p>
        <p class="lead">
        	Abaixo segue 10 botões para executar o programa. Clique por gentileza.
        </p>
      </div>

      <div class="row marketing">
        <div class="col-lg-3">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="1"  /> 
				<button type="submit" class="btn btn-default">Exercicio 1</button>
			</form>
        </div>
        <div class="col-lg-3">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="2" /> 
				<button type="submit" class="btn btn-default btnSubmit">Exercicio 2</button>
			</form>
        </div>
        <div class="col-lg-3">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="3" />
				<button type="submit" class="btn btn-default btnSubmit">Exercicio 3</button>
			</form>
        </div>
        <div class="col-lg-3">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="4" />
				<button type="submit" class="btn btn-default btnSubmit">Exercicio 4</button>
			</form>
        </div>

      </div>
      
       <div class="row marketing">
        <div class="col-lg-3">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="5" />
				<button type="submit" class="btn btn-default btnSubmit">Exercicio 5</button>
			</form>
        </div>
        <div class="col-lg-3">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="6" />
				<button type="submit" class="btn btn-default btnSubmit">Exercicio 6</button>
			</form>
        </div>
        <div class="col-lg-3">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="7" />
				<button type="submit" class="btn btn-default btnSubmit">Exercicio 7</button>
			</form>
        </div>
        <div class="col-lg-3">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="8" />
				<button type="submit" class="btn btn-default btnSubmit">Exercicio 8</button>
			</form>
        </div>

      </div>
      
       <div class="row marketing">

        <div class="col-lg-6">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="9" />
				<button type="submit" class="btn btn-default btnSubmit">Exercicio 9</button>
			</form>
        </div>
        <div class="col-lg-6">
        	<form action="Calling" method="POST">
        		<input type="hidden" name="number_exercise" value="10" />
				<button type="submit" class="btn btn-default btnSubmit">Exercicio 10</button>
			</form>
        </div>


      </div>

      <footer class="footer">
        <%@ include file="includes/footer.jsp" %>
      </footer>

    </div>
	


  </body>
</html>
