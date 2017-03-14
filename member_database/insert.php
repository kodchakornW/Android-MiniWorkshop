<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $username = $_POST['username'];
  $password = $_POST['password'];
  $email = $_POST['email'];

  define('HOST',	'localhost');
  define('USER',	'root');
  define('PASS',	'rootpassword');
  define('DB',	'my_database');

  $conn = mysqli_connect(HOST, USER, PASS, DB);

  $sql = "INSERT INTO member (`username`, `password`, `email`)
            VALUES('$username', '$password', '$email')";

  if (mysqli_query ($conn, $sql)) {
    echo 'Successfully to update status';
  } else {
    echo 'Unable to update status, Please try again later~';
  }
} else {
  echo 'Incompletely to add data.';
}
mysqli_close($conn);
?>
