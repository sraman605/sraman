<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>phoneBook - Sraman Bajracharya app</title>
    <link rel="stylesheet" href="../css/app.css">
    <link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<div class="container-fluids">
    <header>
        <!-- Static navbar -->
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">ePhoneBook</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="/contact">Contacts</a></li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%
                            HttpSession session1 = request.getSession();
                            if((String) session1.getAttribute("uname") == null){
                        %>

                        <li class="m-3"><a type="button" class=" m-3" href="#" data-toggle="modal" data-target="#loginModal">Login</a></li>
                        <li class="m-3"><a type="button" class=" m-3" data-toggle="modal" data-target="#registerModal" href="../navbar-fixed-top/">Register</a></li>

                        <%
                            }
                            else{
                        %>
                        <li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                Hello ${sessionScope.uname}
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">

                                <li><a href="/contact">My contacts</a></li>
                                <li><a onclick="document.getElementById('form1').submit()">Logout</a></li>
                            </ul>
                        <form action="/logout" method="post" id="form1"></form>
                        </li>
                        <%
                            }
                        %>
                        </a>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </nav>

        <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Login Now</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="/login" method="post" class="form">
                            <div class="form-group">
                                <label for="">Email</label>
                                <input type="text" name="email" class="form-control input" placeholder="Enter your email" required>
                            </div>

                            <div class="form-group">
                                <label for="">Password</label>
                                <input type="password" name="password" class="input form-control" required>
                            </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-success form-control">Login</button>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Register Now</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="/register" method="post" class="form">
                            <div class="form-group">
                                <label for="">Name</label>
                                <input type="text" name="name" class="form-control input" placeholder="Enter your name">
                            </div>

                            <div class="form-group">
                                <label for="">Email</label>
                                <input type="text" name="email" class="form-control input" placeholder="Enter your email">
                            </div>

                            <div class="form-group">
                                <label for="">Phone Number</label>
                                <input type="text" name="phoneno" class="form-control input" placeholder="Enter your phone number">
                            </div>

                            <div class="form-group">
                                <label for="">Password</label>
                                <input type="password" name="password" class="input form-control" placeholder="Your password">
                            </div>

                            <div class="form-group">
                                <label for="">Confirm Password</label>
                                <input type="password" class="input form-control" placeholder="Confirm your Password">
                            </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-primary form-control">Register</button>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>



    </header>
</div>