<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Login page</title>

    <link rel="stylesheet" type="text/css" href="styleForLogin.css">

</head>
<body>
<form method="post" action="login">
    <div class="box-form">
        <div class="down">
            <h5>Login</h5>
            <div class="inputs">
                <input type="text" name="login" placeholder="Login" required minlength="4">
                <br>
                <input type="password" name="password" placeholder="password"
                       required minlength="6"
                       pattern="(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}">
            </div>

            <div class="remember-me">
                <label>
                    <input type="checkbox" name="rememberMe" checked/>
                    <span class="text-checkbox">Remember me</span>
                </label>
            </div>

            <h3>Don't have an account? <a href="/registration">Creat Your Account</a></h3>

            <div class="submit">
                <input type="Submit" name="submit" value="Login">
            </div>
        </div>
    </div>
</form>
</body>
</html>
