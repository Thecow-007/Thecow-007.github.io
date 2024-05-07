<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Post</title>

    <!-- CSS -->
    <link rel="stylesheet" href="./CSS/createPost.css">
    <link rel="stylesheet" href="./CSS/fullSite.css">
</head>
<!-- Header -->
<?php
    include_once("header.php");
?>

<body>
    
    <!-- Create Post Form -->
    <form action="./createPost.php" method="POST" id="create-post-form" enctype="multipart/form-data">

        <!-- Post Title -->
        <div id="post-title-container">
            <label for="post-title">Post Title:</label>
            <input type="text" id="post-title" name="title">
        </div>

        <!-- Post Content -->
        <div id="post-content-container">
            <label for="post-content">Post Content:</label>
            <textarea name="content" id="post-content" cols="60" rows="5"></textarea>
        </div>

        <!-- Post Tag -->
        <div id="post-tag-container">
            <label for="post-tag">Post Tag:</label>
            <select name="tag" id="post-tag">
                <option value="beards">Beards</option>
                <option value="critters">Critters</option>
                <option value="flowers">Flowers</option>
                <option value="gardening">Gardening</option>
                <option value="gossip">Gossip</option>
                <option value="hats">Hats</option>
                <option value="mushrooms">Mushrooms</option>
                <option value="pipes">Pipes</option>
                <option value="poetry">Poetry</option>
                <option value="stew">Stew</option>
                <option value="whimsy">Whimsy</option>
            </select>
        </div>

        <!-- Post Image -->
        <div id="post-image-container">
            <label for="post-image">Image:</label>
            <input type="file" name="image" id="post-image">
        </div>

        <!-- Create Post Button -->
        <div id="create-post-container">
            <button type="submit" id="create-post-button">Create Post</button>
        </div>
    </form>

</body>
</html>


<!-- Footer -->
<?php
    include_once("footer.php");
?>

<!-- PHP to insert post to DB -->
<?php

    function generateRandomString($length) {
        // Define the possible characters to include in the random string
        $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
        
        // Shuffle the characters
        $shuffled = str_shuffle($characters);
        
        // Initialize an empty string to hold the random string
        $randomString = '';

        // Loop to generate the random string
        for ($i = 0; $i < $length; $i++) {
            // Pick a random character from the shuffled characters
            $randomString .= $shuffled[rand(0, strlen($characters) - 1)];
        }

        // Return the generated random string
        return $randomString;
    }

    if(isset($_POST['title']) && isset($_POST['content'])){
        $title = addslashes($_POST['title']);
        $content = addslashes($_POST['content']);
        $tag = addslashes($_POST['tag']);
        
        //ToDo get user's email from session (?) and replace here.
        mysqli_query($conn, "Insert into Posts(profileid, title, textbody, tag) Values('" . $email . "', '" . $title . "', '" .  $content . "', '" .  $tag . "');");
        $postID = mysqli_insert_id($conn);

        //image upload handling.
        if($image_name = $_FILES['image']['name']){
            // Randomize image name, so that users can upload files with the same name.
            $image_name = substr($image_name, 0, 20);
            $image_name .= generateRandomString(100);
            $img_temp = $_FILES['image']['tmp_name'];
            $img_folder = 'postImages/' . $image_name;


            if(!move_uploaded_file($img_temp, $img_folder)){
                echo "upload error!";
            }

            mysqli_query($conn, "Insert into post_pics(picture, postid) Values('" . $image_name . "', '" .  $postID . "');");
        }

        header("Location: ./index.php");
    }

?>