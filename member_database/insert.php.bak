<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $username = $_POST['username'];
  $password = $_POST['password'];
  $email = $_POST['email'];

  $msgResult;

  define('HOST',	'localhost');
  define('USER',	'root');
  define('PASS',	'rootpassword');
  define('DB',	'my_database');

  $conn = mysqli_connect(HOST, USER, PASS, DB);

  $sql = "INSERT INTO member (`username`, `password`, `email`)
  VALUES('$username', '$password', '$email')";

  if (mysqli_query ($conn, $sql)) {
    $msgResult = 'Successfully to insert data.';
  } else {
    $msgResult = 'Unable to update status, Please try again later~';
  }
} else {
  $msgResult = 'Incompletely to add data.';
}

echo json_encode(array("result"=>$msgResult));
mysqli_close($conn);
?>
