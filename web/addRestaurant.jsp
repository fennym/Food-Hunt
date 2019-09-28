<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Restaurant</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/addValidation.js"></script>

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
                <li class="active"><a href="adminHome.jsp">Home</a></li>
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


            <div class="container">
                <h2>Add a Restaurant</h2>
                <form action="AddRestaurantController" method="post" onsubmit="return validateAddForm();">

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="Name">Name: </label>
                            <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="Type">Type: </label>
                            <select class="form-control" id="type" name="type">
                                <option value="Indian">Indian</option>
                                <option value="Chinese">Chinese</option>
                                <option value="Italian">Italian</option>
                                <option value="Mexican">Mexican</option>
                                <option value="Thai">Thai</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="Address">Address: </label>
                            <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
                            <input type="text" class="form-control" id="city" placeholder="Enter City" name="city">
                            <input type="text" class="form-control" id="state" placeholder="Enter State" name="state">
                            <input type="text" class="form-control" id="zip" placeholder="Enter zipcode" name="zip">
                            <input type="text" class="form-control" id="country" placeholder="Enter country" name="country">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="Tags">Tags:</label>
                            <input type="text" class="form-control" id="tags" placeholder="Enter Tags" name="tags">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="Latitude">Latitude: </label>
                            <input type="text" class="form-control" id="latitude" placeholder="Enter latitude" name="latitude">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="longitude">Longitude: </label>
                            <input type="text" class="form-control" id="longitude" placeholder="Enter longitude" name="longitude">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="Phone">Phone: </label>
                            <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="FoodRating">Food Rating: </label>
                            <input type="text" class="form-control" id="foodrating" placeholder="Enter Food Rating" name="foodrating">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="AccessibilityRating">Accessibility Rating: </label>
                            <input type="text" class="form-control" id="accessibilityrating" placeholder="Enter Accessibility Rating" name="accessibilityrating">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="AmbienceRating">Ambience Rating: </label>
                            <input type="text" class="form-control" id="ambiencerating" placeholder="Enter Ambience Rating" name="ambiencerating">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="OverallRating">Overall Rating: </label>
                            <input type="text" class="form-control" id="overallrating" placeholder="Enter Overall Rating" name="overallrating">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label >Open Timings: </label>
                            <input type="time" class="form-control" id="opentiming" placeholder="Enter Open Timings" name="opentiming">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label >Close Timings: </label>
                            <input type="time" class="form-control" id="closetiming" placeholder="Enter Close Timings" name="closetiming">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="SeatCapacity">Seat Capacity: </label>
                            <input type="text" class="form-control" id="seatcapacity" placeholder="Enter Seat Capacity" name="seatcapacity">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="TableArrangement">Table Arrangement: </label>
                            <input type="text" class="form-control" id="tablearrangement" placeholder="Enter Table Arrangement" name="tablearrangement">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="HomeDelivery">Home Delivery: </label>
                            <select class="form-control" id="homedelivery" name="homedelivery">
                                <option value="true">Yes</option>
                                <option value="false">No</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-lg-6">
                            <label for="Picture">Picture: </label>
                            <input type="file" class="form-control" id="picture" placeholder="Upload picture" name="picture">
                        </div>
                    </div>

                    <input type="submit" name="submit" value="Add" class="btn btn-lg btn-primary btn-block"><br>
                    <a type="button" href="adminHome.jsp" class="btn btn-danger btn-lg">Cancel</a>

                </form>
            </div>


        </div>
        <div class="col-sm-2 sidenav">
            <div class="well">
                <p>ADS</p>
            </div>
            <div class="well">
                <p>ADS</p>
            </div>
        </div>
    </div>
</div>


<footer class="container-fluid text-center">
    <p>Food Hunt - Copyright &copy; 2018</p>
</footer>

</body>
</html>
