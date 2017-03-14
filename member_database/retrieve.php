<?php
define('HOST',	'localhost');
define('USER',	'root');
define('PASS',	'rootpassword');
define('DB',	'my_database');

$conn = mysqli_connect(HOST, USER, PASS, DB);

$sql = "SELECT * FROM member";
$queried = $conn->query($sql);

$result = array();
while ($record = mysqli_fetch_array($queried)) {
  array_push ($result, array(
    "username"=>$record['username'],
    "password"=>$record['password'],
    "email"=>$record['email']));
}

echo json_encode($result);
mysqli_close($conn);
?>
