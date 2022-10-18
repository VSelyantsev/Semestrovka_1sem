<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration page</title>
    <link rel="stylesheet" type="text/css" href="registrationCss.css">
</head>


<body>
<div class="container">
    <h2 class="header">Sign Up Form</h2>
    <form method="post" action="registration">

        <div class="box">
            <label for="firstName" class="fl fontLabel">First Name: </label>
            <div class="new iconBox">
                <img src="images/logo/man.jpg" class="pictures">
            </div>
            <div class="fr">
                <input type="text" name="firstname" placeholder="Enter First Name"
                       class="textBox" autofocus="on" required>
            </div>
        </div>

        <div class="box">
            <label for="secondName" class="fl fontLabel"> Last Name: </label>
            <div class="fl iconBox">
                <img src="images/logo/man.jpg" class="pictures">
            </div>
            <div class="fr">
                <input type="text" required name="lastname"
                       placeholder="Enter Last Name" class="textBox">
            </div>
        </div>

        <div class="box">
            <label for="login" class="fl fontLabel"> Login: </label>
            <div class="fl iconBox">
                <img src="images/logo/man.jpg" class= "pictures">
            </div>
            <div class="fr">
                <input type="text" required name="login" placeholder="Enter Login" class="textBox">
            </div>
        </div>

        <div class="box">
            <label for="email" class="fl fontLabel"> Email ID: </label>
            <div class="fl iconBox">
                <img src="images/logo/emaillogo.jpg" class="pictures">
            </div>
            <div class="fr">
                <input type="email" required name="email" placeholder="Enter Email" class="textBox">
            </div>
        </div>

        <div class="box">
            <label for="password" class="fl fontLabel"> Password </label>
            <div class="fl iconBox">
                <img src="images/logo/passwordlogo.jpg" class="pictures">
            </div>
            <div class="fr">
                <input type="Password" required name="password" placeholder="Enter Password" class="textBox">
            </div>
        </div>

        <div class="box radio">
            <label for="gender" class="fl fontLabel"> Gender: </label>
            <input type="radio" name="gender" value="Male" required> Male &nbsp; &nbsp; &nbsp; &nbsp;
            <input type="radio" name="gender" value="Female" required> Female
        </div>
        
        <div class="cls">
            <input type="Submit" name="Submit" class="submit" value="sumbit">
        </div>

        <div class="sign-in-container">
            <p>Alreade have an account? <a href="/login" class="sign-in">Sign in</a></p>
        </div>

    </form>
</div>
</body>
</html>