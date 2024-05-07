<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="./CSS/fullSite.css">
    <link rel="stylesheet" href="./CSS/signup.css">
</head>
<?php include("server.php"); ?>
<body>
    <form action="signup.php" enctype="multipart/form-data" method="POST" id="signup-form">
        <div id="signup-title-container">
            <h1 id="signup-title">Sign Up</h1>
        </div>
    
        <div id="email-container">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email">
        </div>

        <div id="username-container">
            <label for="name">Username:</label>
            <input name="name" id="name">
        </div>

        <div id="pass-container">
            <label for="pass">Password:</label>
            <input type="password" name="pass" id="pass">
        </div>

        <div id="pass2-container">
            <label for="pass2">Retype Password:</label>
            <input type="password" name="pass2" id="pass2">
        </div>

        <div id="pfp-container">
            <label for="pic">Profile Picture:</label>
            <input type="file" name="pic" id="pic">
        </div>

        <div id="desc-container">
            <label for="desc">Description:</label>
            <textarea col="50" row="10" name="desc" id="desc">Write a bit about yourself
            </textarea>
        </div>

        <div id="buttons">
            <a href="./login.php">
                <button id="loginIn-button" type="button">Log In</button>
            </a>
            <button id="signup-submit" type="submit">Sign Up</button>
        </div>
    </form>

</body>
<?php
    // include("footer.php"); 
    if(isset($_POST['pass'])){

        // ToDo: Include a check to make sure that user does not already exist.

        $file_name = $_FILES['pic']['name'];
        $temp = $_FILES['pic']['tmp_name'];
        $folder = 'pfp/' . $file_name;

        $name = $_POST['name'];
        $password = hash('sha256', $_POST['pass']);
        $desc = $_POST['desc'];
        $email = $_POST['email'];

        $profileQuery = "SELECT * FROM profiles WHERE email = '$email'";
        $ProfileResult = mysqli_query($conn,$profileQuery);

        if($row = mysqli_fetch_assoc($ProfileResult)){
            echo "User already exists!";
            exit();
        }
    
        mysqli_query($conn,"INSERT INTO profiles (name,password,description,picture,email) VALUES ('$name','$password','$desc','$file_name','$email')");

        if(!move_uploaded_file($temp,$folder)){
            echo "upload error!";
        }

        $_SESSION['email'] = $email;
        $_SESSION['name'] = $name;
        $_SESSION['pic'] = $file_name;

        header("Location: ./index.php");
    }
?>
</html>