<?php
	  include "conn2.php";
	  

$sql="SELECT Id,Name,Email,Query FROM forumtable";
$tab_menu = '';

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    //    echo "id: " . $row["id"]. " - Name: " . $row["firstname"]. " " . $row["lastname"]. "<br>";
		
		$tab_menu .= ' <div class="panel panel-info">
      <div class="panel-heading">Question'.$row["Id"].'</div>
      <div class="panel-body"><li><a href="#'.$row["Id"].'" data-toggle="tab">'.$row["Name"].'</a></li>
	  <div align="right";class="container">
 <a href="#demo'.$row["Id"].'" class="btn btn-info" data-toggle="collapse">Answer</a>
  <div id="demo'.$row["Id"].'" class="collapse">'.$row["Email"].'
   <code align="left">Answer</code>
   </div>
   </div>
	  </div></div>
  ';
    }
} else {
    echo "0 results";
}
$conn->close();
?>



<html lang="en">
<head>
  <title>Bootstrap Example</title>
  
  
 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/main.css" rel="stylesheet">

  <script src="js/bootstrap.min.js"></script> 
<script src="js/main.js"></script>




</head>
<body>
<?php
   echo $tab_menu;
   ?>
	
</body>
</html>