<?php
define('HOST',	'localhost');
define('USER',	'root');
define('PASS',	'rootpassword');
define('DB',	'my_database');

$conn = mysqli_connect(HOST, USER, PASS, DB);

if (!$conn) {
  die("Connection failed: " .mysqli_connect_error());
}
?>
