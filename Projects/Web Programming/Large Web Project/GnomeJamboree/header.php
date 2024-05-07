<?php
  include_once("server.php");
?>

<head>
  <link rel="stylesheet" href="./CSS/header.css">
</head>

<!-- Site Header -->
<header>

  <!-- Site Icon -->
  <div id="header-icon">
      <!-- ToDo: make and add image -->
      <img src="<?php echo $pic ?>" alt="add here: Gnome Jamboree Site Icon" id="site-icon">
  </div>

  <!-- Site Title -->
  <div id="site-title">
      <h1>Gnome Jamboree</h1>
  </div>

  <!-- Search Bar -->
  <div id="search-container">
      <label for="search-bar">Search:</label>
      <input type="text" id="search-bar" placeholder="Search...">
  </div>

  <!-- Navigation Links -->
  <nav id="links">
    <!-- Home -->
    <div id="home-container" class="header-link">
      <!-- ToDo: Change back to index.php once sessions are set up correctly-->
        <a href="./index.php" id="home-link">Home:</a>
    </div>

    <!-- Recommended -->
    <div id="recommended-container" class="header-link">
        <a href="./index.html" id="recommended-link">Recommended</a>
    </div>

    <!-- Profile -->
    <?php if(isset($_SESSION['email'])){ ?>
      <div id="profile-container" class="header-link">
        <a href="profile.php?email=<?php echo $email ?>" id="profile-link">Profile: <?php echo $name ?></a>
      </div>
    <?php } else{?>
      <div id="profile-container" class="header-link">
        <a href='login.php'>Login</a>
      </div>  
    <?php }?>

    <!-- Create Post -->
    <?php if(isset($_SESSION['email'])){ ?>
      <div id="create-post-container">
        <a href="./createPost.php">Create Post</a>
      </div>
    <?php } ?>
  </nav>
</header>
