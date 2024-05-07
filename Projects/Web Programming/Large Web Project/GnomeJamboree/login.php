<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <script src="./JS/login.js"></script>
    <link rel="stylesheet" href="./CSS/fullSite.css">
    <link rel="stylesheet" href="./CSS/login.css">
</head>

<?php 
    // include_once("header.php");
    if(isset($_GET["logout"])){
        session_start();
        session_unset();
        session_destroy();
    }
    
    include_once("server.php");
?>
<body>
<form action="login.php" method="POST" onsubmit="return validateLogin()" id="login-form">
        <div id="login-title-container">
            <h1 id="login-title">Login</h1>
        </div>

        <div id="email-container">
            <label for="email">Email:</label>
            <input type="text" name="email" id="email">
            <p id="email-message" class="error-message"></p>
        </div>

        <div id="pass-container">
            <label for="pass">Password:</label>
            <input type="password" name="pass" id="pass">
            <p id="pass-message" class="error-message"></p>
        </div>

        <div id="login-buttons">
            <button id="login-submit" type="submit">Login</button>
            <a href="./signup.php">
                <button id="sign-up" type="button">Sign Up</button>
            </a>
        </div>
    </form>
</body>
<?php 
    if(isset($_POST['email'])){
        $email = $_POST['email'];
        $pass = hash('sha256', $_POST['pass']);

        $query = "SELECT * FROM profiles WHERE email = '$email' and password = '$pass'";
        $result = mysqli_query($conn,$query);
        
        if($row = mysqli_fetch_assoc($result)){
            $_SESSION['email'] = $row['email'];
            $_SESSION['name'] = $row['name'];
            $_SESSION['pic'] = $row['picture'];
            header("Location: ./index.php");
        }
    }
    ?>
</html>

