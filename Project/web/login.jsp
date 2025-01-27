<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="css/login.css">
    </head>

    <body>

        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="signup">
                    <h1>Create Account</h1>
                    <input name="user" type="text" placeholder="Username" />
                    <input name="pass" type="password" placeholder="Password" />
                    <input name="repass" type="password" placeholder="Repeat Password" />
                    <input name="address" type="text" placeholder="Address" />
                    <input name="phone" type="text" placeholder="Phone number" />
                    <button type="submit">Sign Up</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form action="login">
                    <h1>Sign in</h1>
                    <input name="username" type="text" placeholder="Username" />
                    <input name="password" type="password" placeholder="Password" />
                    <a href="#">Forgot your password?</a>
                    <button name="sup1" type="submit">Sign In</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>To keep connected with us please login with your personal info</p>
                        <button class="ghost" id="signIn">Sign In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hello, Friend!</h1>
                        <p>Enter your personal details and start journey with us</p>
                        <button class="ghost" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/login.js"></script>

    </body>

</html>