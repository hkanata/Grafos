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
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
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
        <h1>Exercise</h1>
      </div>

      <div class="row marketing">
        <div class="col-lg-12">
          <h4>Problem one: Trains</h4>
          <p style="text-align: justify;">          
			
			The local commuter railroad services a number of towns in Kiwiland.  Because of monetary concerns, all of the tracks are 'one-way.'  That is, a route from Kaitaia to Invercargill does not imply the existence of a route from Invercargill to Kaitaia.  In fact, even if both of these routes do happen to exist, they are distinct and are not necessarily the same distance!<br /><br />
					
			The purpose of this problem is to help the railroad provide its customers with information about the routes.  In particular, you will compute the distance along a certain route, the number of different routes between two towns, and the shortest route between two towns.<br /><br />

			Input:  A directed graph where a node represents a town and an edge represents a route between two towns.  The weighting of the edge represents the distance between the two towns.  A given route will never appear more than once, and for a given route, the starting and ending town will not be the same town.<br /><br />

			Output: For test input 1 through 5, if no such route exists, output 'NO SUCH ROUTE'.  Otherwise, follow the route as given; do not make any extra stops!  For example, the first problem means to start at city A, then travel directly to city B (a distance of 5), then directly to city C (a distance of 4).<br /><br />
			
			The distance of the route A-B-C.<br />
			The distance of the route A-D.<br />
			The distance of the route A-D-C.<br />
			The distance of the route A-E-B-C-D.<br />
			The distance of the route A-E-D.<br />
			The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).<br />
			The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).<br />
			The length of the shortest route (in terms of distance to travel) from A to C.<br />
			The length of the shortest route (in terms of distance to travel) from B to B.<br />
			The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.<br /><br />
			
			Test Input:<br />
			For the test input, the towns are named using the first few letters of the alphabet from A to D.  A route between two towns (A to B) with a distance of 5 is represented as AB5.<br />
			Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7<br />
			Expected Output:<br />
			Output #1: 9<br />
			Output #2: 5<br />
			Output #3: 13<br />
			Output #4: 22<br />
			Output #5: NO SUCH ROUTE<br />
			Output #6: 2<br />
			Output #7: 3<br />
			Output #8: 9<br />
			Output #9: 9<br />
			Output #10: 7<br />
          
          </p>

        </div>


      </div>

      <footer class="footer">
        <%@ include file="includes/footer.jsp" %>
      </footer>

    </div> <!-- /container -->


  </body>
</html>
