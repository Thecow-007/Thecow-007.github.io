<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<?php 

include("header.php");

$profileEmail = $_GET["email"];
if(isset($_SESSION['email'])){
$loggedEmail = $_SESSION['email'];

if(isset($_POST['follow'])){
    $query = "INSERT INTO followings (sourceprofile,followingprofile) 
    VALUES ('$loggedEmail','$profileEmail');";
    mysqli_query($conn,$query);
}
else if(isset($_POST['unfollow'])){
    $query = "DELETE FROM followings 
    WHERE sourceprofile = '$loggedEmail' AND followingprofile = '$profileEmail';";
    mysqli_query($conn,$query);
}

$query = "SELECT * FROM followings WHERE sourceprofile = '$loggedEmail' AND followingprofile = '$profileEmail'";
$result = mysqli_query($conn,$query);
$rowf = mysqli_fetch_assoc($result);
}
?>

<body>
    <p><?php 

    $query = "SELECT * FROM profiles WHERE email = '$profileEmail';";
    $result = mysqli_query($conn,$query);

    $row = mysqli_fetch_assoc($result);

    echo $row["name"];


    if(isset($_SESSION['email']) && $profileEmail != $loggedEmail){
            if(!isset($rowf["sourceprofile"])){
                echo " not followed";
            }
            else{
                echo " followed";
            }
        
    }
    ?></p>
    <p><?php 
    echo $row["email"];

    if(isset($_SESSION["email"]) && $profileEmail != $_SESSION["email"]){
        $action = "profile.php?email=" . $_GET["email"];
        $follow = !isset($rowf["sourceprofile"])? "follow" : "unfollow";
        echo "<form method='post' action='$action'> 
            <input type='submit' name='$follow' value='$follow'>
        </form>";
    }
    ?></p>
    <p>
        <?php 
            $query = "SELECT * FROM followings WHERE sourceprofile = '$profileEmail';";
            $result = mysqli_query($conn,$query);
            echo "following <br>";
            while($follower = mysqli_fetch_assoc($result)){
                $id = $follower['followingprofile'];
                $query = "SELECT * FROM profiles WHERE email = '$id'";
                $rizzult = mysqli_query($conn,$query);
                $rizzow = mysqli_fetch_assoc($rizzult);
                $name = $rizzow['name'];
                $followEmail = $rizzow['email'];
                echo "<a href='profile.php?email=$followEmail' id='profile-link'>$name</a><br>";
            }

            $query = "SELECT * FROM followings WHERE followingprofile = '$profileEmail';";
            $result = mysqli_query($conn,$query);
            echo "followers <br>";
            while($follower = mysqli_fetch_assoc($result)){
                $id = $follower['sourceprofile'];
                $query = "SELECT * FROM profiles WHERE email = '$id'";
                $rizzult = mysqli_query($conn,$query);
                $rizzow = mysqli_fetch_assoc($rizzult);
                $name = $rizzow['name'];
                $followEmail = $rizzow['email'];
                echo "<a href='profile.php?email=$followEmail' id='profile-link'>$name</a><br>";
            }
        ?>
    </p>
    <?php if($profileEmail == $loggedEmail){?>
    <form action="login.php?logout=true" method="post">
            <input type="submit" name="log out" value="Log Out">
    </form>
    <form action="profile.php?email=$profileEmail" method="post">
            <input type="submit" name="edit" value="Edit">
    </form>
    
    <?php } ?>
</body>

<?php include("footer.php") ?>

</html>