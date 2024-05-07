<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post</title>

    <!-- CSS -->
    <link rel="stylesheet" href="./CSS/fullSite.css">
    <link rel="stylesheet" href="./CSS/tagColor.css">
    <link rel="stylesheet" href="./CSS/post.css">
</head>
<body>
    <?php
        require_once('header.php');
    ?>

    <main>

        


        <?php
            $postID = $_GET['id'];
            $postQuery = "SELECT * FROM Posts Where id = '". $postID ."';";
            $postResults = mysqli_query($conn, $postQuery);
            $post = mysqli_fetch_assoc($postResults);
            

            // Post image
            $imageQuery = "SELECT * FROM post_pics Where postID = '" . $postID . "';";
            $imageResults = mysqli_query($conn, $imageQuery);

            $profileQuery = "SELECT * FROM profiles WHERE email = '" . $post['profileid'] . "';";
            $profileResults = mysqli_query($conn, $profileQuery);
            $profile = mysqli_fetch_assoc($profileResults);

            // Post Tag
            //Generate tag color, by genereating a class for it
            $firstTagChar = strtolower($post['tag'][0]);
            //should convert into a number 1-36
            $tagNum = (int)base_convert($firstTagChar, 36, 10);

        ?>

        <div id="post">

            <?php
                //If its an image post, insert the image
                if($postImage = mysqli_fetch_assoc($imageResults)){
            ?>
                    <div class="img-container">
                        <img src="./postImages/<?php echo $postImage['picture'] ?>" alt="This image didn't load" class="post-img">
                    </div>
            <?php
                // Closing bracket for if-statement
                } 
            ?>
                <div class="post-text">
                    <!-- Post Title -->
                    <div class="post-title">
                        <h3><?php echo $post['title'] ?></h3>

                        <!-- Post Author -->
                        <div class="post-author-container">
                            <div class="author-pfp-container">
                                <!-- ToDo get poster's pfp from db -->
                                <img src="pfp/<?php echo $profile['picture'] ?>" alt="Poster's profile picture" class="author-pfp pfp">
                            </div>
                            <div class="author-name-container">
                                <a href="profile.php?email=<?php echo $profile['email'] ?>"><?php echo $profile['name'] ?></a>
                            </div>
                        </div>
                    </div>

                    <!-- Post Text Content -->
                    <div class="post-content">
                        <p><?php echo $post['textbody'] ?></p>
                    </div>
                </div>

                <!-- Post Tag-->
                <div class="post-tag">
                    <p class="tag tag<?php echo $tagNum ?>"><?php echo $post['tag'] ?></p>
                </div>

        </div>

        <h3 id="comments-header">Comments:</h3>
        <!-- Create Comment Bar -->
        <form action="post.php?id=<?php echo $postID ?>" method="POST" id="create-comment-bar">
            
            <div id="users-pfp-container">
                <img src="<?php echo $pic ?>" alt="Your profile picture." id="users-pfp" class="pfp">
            </div>

            <textarea name="comment" id="create-comment" rows="2" cols="50" placeholder="Add Comment... "></textarea>

            <button id="add-comment-button" type="submit">Add Comment</button>

        </form>
        
        <!-- PHP To Proccess creating a comment -->
        <?php
        if(isset($_POST['comment'])){
            $commentQuery = "INSERT into comments (postid, profileid, textbody) Values ('" . $post['id'] . "', '" . $email . "' , '" . $_POST['comment'] ."');";
            mysqli_query($conn, $commentQuery);
            echo '<script>self.location = "./post.php?id=' . $postID . '";</script>';
            die();
        }
        ?>
        

        <!-- ToDo: process comments in a loop -->

        <div id="comments">
            
            <div class="comment">
                <div class="comment-pfp-container">
                    <!-- ToDo: get comment pfp from db -->
                    <img src="<?php echo $pic ?>" alt="The commentor's pfp" class="comment-pfp pfp">
                </div>

                <div class="comment-content-container">
                    <p class="comment-content">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Odio voluptatibus a expedita debitis vel possimus natus, tenetur quo aut non asperiores sequi sit, necessitatibus rem?</p>
                    
                    <div class="comment-author">
                        <!-- ToDo: link to comment author's profile page. -->
                        <a href="">Commentor</a>
                    </div>
                </div>
            </div>

            <div class="comment">
                <div class="comment-pfp-container">
                    <!-- ToDo: get comment pfp from db -->
                    <img src="<?php echo $pic ?>" alt="The commentor's pfp" class="comment-pfp pfp">
                </div>

                <div class="comment-content-container">
                    <p class="comment-content">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Odio voluptatibus a expedita debitis vel possimus natus, tenetur quo aut non asperiores sequi sit, necessitatibus rem?</p>
                    
                    <div class="comment-author">
                        <!-- ToDo: link to comment author's profile page. -->
                        <a href="">Commentor</a>
                    </div>
                </div>
            </div>

            <div class="comment">
                <div class="comment-pfp-container">
                    <!-- ToDo: get comment pfp from db -->
                    <img src="<?php echo $pic ?>" alt="The commentor's pfp" class="comment-pfp pfp">
                </div>

                <div class="comment-content-container">
                    <p class="comment-content">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Odio voluptatibus a expedita debitis vel possimus natus, tenetur quo aut non asperiores sequi sit, necessitatibus rem?</p>
                    
                    <div class="comment-author">
                        <!-- ToDo: link to comment author's profile page. -->
                        <a href="">Commentor</a>
                    </div>
                </div>
            </div>
            
        </div>

    </main>


    <?php
        require_once('footer.php');
    ?>
</body>
</html>