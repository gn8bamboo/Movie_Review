<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Movie Review Database System</title>
</head>
<body>

<div align="center">
  <p><strong><font size="+2">Welcome to Online Movie Review Database System</font></strong></p>
  <p>${name} Welcome</p>
  <p>&nbsp;</p>
</div>


<div align="center">
  <table width="200" border="1" align="center">
    <tr>
      <th scope="col">Customer Menu</th>
    </tr>
    <tr>
      <td><div align="center"><a href="http://localhost:8080/myapps/movie">List All Movies</a></div></td>
    </tr>
    <tr>
      <td><div align="center"><a href="http://localhost:8080/myapps/actor">List All Actors</a></div></td>
    </tr>
    <tr>
      <td><div align="center"><a href="http://localhost:8080/myapps/review">Reviews</a></div></td>
    </tr>
    <tr>
      <td><div align="center"><a href="http://localhost:8080/myapps/comment">Comment</a></div></td>
    </tr>
    <tr>
      <td><div align="center"><a href="http://localhost:8080/myapps">Logout</a></div></td>
    </tr>
  </table>
</div>

<div align="center">
<p>&nbsp;</p>

<script type="text/javascript">

	function movie()
	{
		document.searchform.action = "moviesearch";
		document.searchform.submit();
	}
	
	function actor()
	{
		document.searchform.action = "actorsearch";
		document.searchform.submit();
	}

</script>

<form action="" method = "post" name="searchform">
<table width="238">
  <tr>
    <th width="230" scope="col">Search by Keywords</th>
    </tr>
  <tr>
    <td><input type="text" name="search" width="230"></td>
    </tr>
  <tr>
    <td colspan="2">
    <input type="button" name="button" value="search by movie" onClick="movie()">
	<input type="button" name="button" value="search by actor" onClick="actor()">
	</td>
    </tr>
</table>
</form>
</div>



</body>
</html>