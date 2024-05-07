<?php 

    $server = "localhost";
    $user = "root";
    $pass = "";
    $name = "gnomedb";
    $conn = "";
    try{
        $conn = mysqli_connect($server,$user,$pass,$name);
    }
    catch(mysqli_sql_exception $e){
        echo "Connection Issue: " . $e;
    }

    session_start();
    if(isset ($_SESSION["email"])){
        $name = $_SESSION["name"];
        $email = $_SESSION["email"];
        $pic = 'pfp/' . $_SESSION["pic"];
        //echo "<img src='$pic'> <a href='profile.php/?id=$email'>$name</a>"; 
    }
    else{
        // echo "<p>Guest</p>";
        $name = "Guest";
        $email = "guest@gmail.com";
        $pic = "./Site Images/site-icon.png";
    }

    function closeConnection(){
        $conn -> close();
    }
?>