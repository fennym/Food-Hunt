<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Bookings</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/addValidation.js"></script>
    <script src="js/userSearch.js"></script>
    <script src="js/searchJS.js"></script>

    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {
            height: 450px
        }

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 135%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }

            .row.content {
                height: auto;
            }
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">FoodHunt</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="userHome.jsp">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">

        </div>
        <div class="col-sm-8 text-left">

            <h2>My Bookings</h2>

            <br><br>

            <table>
                <thead>
                <tr>
                    <th>Restaurant</th>
                    <th>Cuisine</th>
                    <th></th>
                </tr>
                </thead>
                <tbody id="myTable">
                <tr>
                    <td><a href="restaurantDetail.jsp">Taj India</a></td>
                    <td>Indian</td>
                    <td>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModalCancel">
                            Cancel Booking
                        </button>
                    </td>
                </tr>
                <tr>
                    <td><a href="restaurantDetail.jsp">Taj 101</a></td>
                    <td>Indian</td>
                    <td>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModalCancel">
                            Cancel Booking
                        </button>
                    </td>
                </tr>
                <tr>
                    <td><a href="restaurantDetail.jsp">Fernandos</a></td>
                    <td>Mexican</td>
                    <td>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModalCancel">
                            Cancel Booking
                        </button>
                    </td>
                </tr>
                <tr>
                    <td><a href="restaurantDetail.jsp">Cava</a></td>
                    <td>Mediterranean</td>
                    <td>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModalCancel">
                            Cancel Booking
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>


        </div>
        <div class="col-sm-2 sidenav">
            <div class="well">
                <p><span class="glyphicon glyphicon-cog"></span> &nbsp;Edit Account</p>
            </div>

            <div class="well">
                <p><span class="glyphicon glyphicon-file"></span> &nbsp;My Bookings</p>
            </div>

        </div>
    </div>
</div>


<!-- Modal -->
<div id="myModalCancel" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Confirm Cancel</h4>
            </div>
            <div class="modal-body">

                <p>Are you sure you want to Cancel this Booking?</p>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Yes</button>

                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>

    </div>
</div>

<footer class="container-fluid text-center">
    <p>Food Hunt - Copyright &copy; 2018</p>
</footer>

</body>
</html>
