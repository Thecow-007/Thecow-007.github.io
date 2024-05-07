<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gnome Jamboree</title>

    <link rel="stylesheet" href="./CSS/fullSite.css">
    <link rel="stylesheet" href="./CSS/index.css">
    <link rel="stylesheet" href="./CSS/tagColor.css">
</head>
<?php include_once("header.php"); ?>
<body>
    <!-- Main -->
    <main>
        <div id="posts-list">


            <?php
                //select posts from db
                $postQuery = "SELECT * FROM Posts";
                $postResults = mysqli_query($conn, $postQuery);

                while($PostI = mysqli_fetch_assoc($postResults)){

                    //Generate tag color, by genereating a class for it
                    $firstTagChar = strtolower($PostI['tag'][0]);
                    //should convert into a number 1-36
                    $tagNum = (int)base_convert($firstTagChar, 36, 10);

                    // Check if its an image post
                    $imageQuery = "SELECT * FROM post_pics Where postID = '" . $PostI['id'] . "';";
                    $imageResults = mysqli_query($conn, $imageQuery);

                    $profileQuery = "SELECT * FROM profiles WHERE email = '" . $PostI['profileid'] . "';";
                    $profileResults = mysqli_query($conn, $profileQuery);
                    $profile = mysqli_fetch_assoc($profileResults);

                    // These are image posts
                    if($postImage = mysqli_fetch_assoc($imageResults)){ ?>
                        
                        <div class="post img-post">

                            <!-- Post's Image -->
                            <div class="img-container">
                                <img src="./postImages/<?php echo $postImage['picture'] ?>" alt="This image didn't load" class="post-img">
                            </div>

                            <!-- Post Title -->
                            <div class="post-title">
                                <h3><?php echo $PostI['title'] ?></h3>

                                <div class="post-author-container">
                                    <div class="author-pfp-container">
                                        <!-- ToDo get poster's pfp from db -->
                                        <img src="pfp/<?php echo $profile['picture'] ?>" alt="Poster's profile picture" class="author-pfp">
                                    </div>
                                    <div class="author-name-container">
                                        <a href="profile.php?email=<?php echo $profile['email'] ?>"><?php echo $profile['name'] ?></a>
                                    </div>
                                </div>
                            </div>

                            <!-- Post Text Content -->
                            <div class="post-content">
                                <p><?php echo $PostI['textbody'] ?></p>
                            </div>

                            <!-- Post Tag-->
                            <div class="post-tag">
                                <p class="tag tag<?php echo $tagNum ?>"><?php echo $PostI['tag'] ?></p>
                            </div>

                            <!-- Recommended Comments -->
                            <div class="rec-comments-container">
                                <!-- ToDo: Implement recommended comments -->
                                <p>Recommended Comments:</p>

                                <!-- First Comment -->
                                <div class="rec-comment">
                                    <div class="rec-comment-content">
                                        <p>Rock and Stone Brother!</p>
                                        <p class="comment-author">-realDwarf</p>
                                    </div>
                                </div>

                                <!-- Second Comment -->
                                <div class="rec-comment">
                                    <div class="rec-comment-container">
                                        <p>That's quonqky my dude!</p>
                                        <p class="comment-author">-quonkyQnome</p>
                                    </div>
                                </div>
                            </div>

                            <!-- Link to all comments -->
                            <div class="all-comments-container">
                                <!-- ToDo make a correct link -->
                                <a href="./post.php?id=<?php echo $PostI['id'] ?>">-See all comments</a>
                            </div>

                        </div>

                    <?php }
                    // These are text posts
                    else{ ?>

                <div class="post txt-post">
                    <!-- Post Title -->
                    <div class="post-title">
                        <h3><?php echo $PostI['title'] ?></h3>

                        <div class="post-author-container">
                            <div class="author-pfp-container">
                                <!-- ToDo get poster's pfp from db -->
                                <img src="pfp/<?php echo $profile['picture'] ?>" alt="Poster's profile picture" class="author-pfp">
                            </div>
                            <div class="author-name-container">
                                <a href="profile.php?email=<?php echo $profile['email'] ?>"><?php echo $profile['name'] ?></a>
                            </div>
                        </div>
                    </div>
                    <!-- Post Text Content -->
                    <div class="post-content">
                        <p><?php echo $PostI['textbody'] ?></p>
                    </div>

                    <!-- Post Tag-->
                    <div class="post-tag">
                        <!-- ToDo implement tag hash system -->
                        <p class="tag tag<?php echo $tagNum ?>"><?php echo $PostI['tag'] ?></p>
                    </div>

                    <!-- Recommended Comments -->
                    <div class="rec-comments-container">
                        <p>Recommended Comments:</p>

                        <!-- First Comment -->
                        <div class="rec-comment">
                            <div class="rec-comment-content">
                                <p>only 2 decades? thats nothing! I once slept in for 200 years by accident!</p>
                                <p class="comment-author">-realGnome</p>
                            </div>
                        </div>

                        <!-- Second Comment -->
                        <div class="rec-comment">
                            <div class="rec-comment-container">
                                <p>That's quonqky my dude!</p>
                                <p class="comment-author">-quonkyQnome</p>
                            </div>
                        </div>
                    </div>

                    <!-- Link to all comments -->
                    <div class="all-comments-container">
                        <!-- ToDo make a correct link -->
                        <a href="./post.php?id=<?php echo $PostI['id'] ?>">-See all comments</a>
                    </div>

                </div>      
                    <?php }
                }
            ?>      
        </div>
    </main>

</body>
<?php include_once("footer.php"); ?>
</html>