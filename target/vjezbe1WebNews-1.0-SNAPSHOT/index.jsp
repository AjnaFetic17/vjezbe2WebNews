<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lorem ipsum | Login</title>
        <script src="https://kit.fontawesome.com/40015dd949.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="styles.css" />
        <link rel="stylesheet" href="index.css" />
        <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'>

    </head>
    <body>
        <div class="container">
            <div class="right">
                
                <h1>Welcome to <br> Lorem ipsum.</h1>

            </div>
            <div class="left">
                <h1>Login</h1>
                <div class="icons-container">
                    <div class="tooltip1">
                        <a href="registration.jsp" >
                            <div class="icon-border">
                                <i class="fa-solid fa-user-plus"></i>

                            </div>
                        </a> 
                        <span class="tooltiptext1">
                            Registracija...
                        </span>               
                    </div>
                    <div class="tooltip2">
                        <a href="ShowNewsList" >

                            <div class="icon-border">
                                <i class="fa-solid fa-ghost"></i> 
                            </div>
                        </a>
                        <span class="tooltiptext2">Nastavi kao gost...</span>
                    </div>

                </div>
                <div class="form-container">
                    <p>
                        ili koristite vaš račun
                    </p>
                    <form action="Login" method="post" autocomplete="off">
                        <input type="text" name="email" value="${user.email}" placeholder="Email" required> 
                        <input type="password" name="password" value="${user.password}" placeholder="Password" required>
                                       <p id="message">${(poruka != null) ? poruka : ""}</p>

                        <button type="submit" name="submit">LOG IN</button>
                    </form>
                </div>


            </div>

        </div>

    </body>
</html>