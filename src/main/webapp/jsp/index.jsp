<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        

        <style>
            table,
            th {
                border: 1px solid orange;
            }
            .dynamicBox {
                border: 3px solid green;
                width: 155x;
                height: 155px;
                padding: 20px;
                margin: 20px;
                font-size: 17px;
                color: blueviolet;
            }
            #messageChangeResponseBox,
            #itemIdBox,
            #messageMoneyBox {
                border: 3px solid green;
                height: 40px;
            }
            #messageResponseBox {
                border: 3px solid green;
                height: 60px;
                font-size: 20px;
                text-align: center;
            }
            hr {

                border: solid 1px black;
                width: 96%;
                color: #FFFF00;
                height: 1px;
            }
            h3 {
                text-align: center;
                font-size: 37px;
                font-weight: bold;
            }
            #dollarButton,
            #dimeButton,
            #quarterButton,
            #nickelButton {
                width: 100%;
                margin: 5px;
            }
            #messageMoneyBox,
            #itemIdBox {
                font-size: 30px;
                text-align: center;
            }
            label {
                font-size: 30px;
            }
            #messageChangeResponseBox {
                height: 50px;
            }
            backgroundPic {
                background-size: 100%;
                background-repeat: no-repeat;
                width: 100%;
                overflow-x: hidden;
            }
            body {
                background: url(light-streaks-backgrounds-ppt.jpg) no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
        </style>

    </head>
    <body>
        <font color="black">
        <br>
        <br>
        <div class="container">


            <h1>
                <center> Vending Machine </center>
            </h1>
            <hr>

            <div class="row">
                <!--//*****************************************************************************************//
//***************************CANDY BOXES********************************************************//
//*****************************************************************************************//-->

                <div class="col-md-9" id="vendingBox">

                    <c:forEach var="item" items="${itemListsss}">
                        <a href="${pageContext.request.contextPath}/Items?ItemNumbersssss=${item.itemId}&total=${total}">
                            <div class="col-md-3 box dynamicBox">
                                <c:out value="${item.itemId}" />
                                <div class="text-center">
                                    <c:out value="${item.itemName}" />
                                </div> 
                                <div class="text-center">
                                    <c:out value="$${item.itemPrice}" /> 
                                </div> 
                                <div class="text-center">Quantity Left: 
                                    <c:out value="${item.quantity}" /> 
                                </div> 
                            </div> 
                        </a>
                    </c:forEach>
                    
                </div>



                <!--//*****************************************************************************************//
//**************************TOTAL $ IN********************************************************//
//*****************************************************************************************//-->

                <div class="col-md-3">
                    <form class="calculationForm">
                        <h3> Total $ in </h3>

                        <div class="col-md-12 form-group">
                        </div>
                        <div class="col-md-12 " id="messageMoneyBox">
                            ${total}${remove}
                        </div>
                        <br>
                        <div class="col-md-6">
                            <a href="${pageContext.request.contextPath}/Dollar/addDollar?ItemNumbersssss=${itemId}">
                                <button type="button" class="btn btn-default" id="dollarButton">Add Dollar</button>
                            </a>
                            <a href="${pageContext.request.contextPath}/Dollar/addDime?ItemNumbersssss=${itemId}">
                                <button type="button" class="btn btn-default" id="dimeButton">Add Dime</button>
                            </a>
                        </div>
                        <div class="col-md-6">
                            <a href="${pageContext.request.contextPath}/Dollar/addQuarter?ItemNumbersssss=${itemId}">
                                <button type="button" class="btn btn-default" id="quarterButton">Add Quarter</button>
                            </a>
                            <a href="${pageContext.request.contextPath}/Dollar/addNickel?ItemNumbersssss=${itemId}">
                                <button type="button" class="btn btn-default" id="nickelButton">Add Nickel</button>
                            </a>
                        </div>
                        <hr>
                        <!--//*****************************************************************************************//
//***************************MESSAGES********************************************************//
//*****************************************************************************************//-->

                        <h3>Messages</h3>
                        <div class="col-md-12 " id="messageResponseBox">
                            ${message}
                        </div>
                        <br><br><br>
                        <label for="itemIdBox" class="col-md-4 control-label">Item: </label>

                        <div class="col-md-8" id="itemIdBox">

                            ${itemId}

                        </div>

                        <div class="col-md-12 form-group">
                            <a href="${pageContext.request.contextPath}/Dollar/makePurchase?ItemNumbersssss=${itemId}">
                                <button type="button" id="purchaseButton" class="btn btn lg">Make Purchase</button>
                            </a>
                        </div>
                        <hr>




                        <!--//*****************************************************************************************//
//***************************CHANGE********************************************************//
//*****************************************************************************************//-->
                        <h3>Change</h3>
                        <div class="col-md-12 " id="messageChangeResponseBox">
                            ${showChange}
                        </div>
                        <div class="col-md-12 form-group">
                            <a href="${pageContext.request.contextPath}/Dollar/returnChange">
                                <button type="button" id="returnChangeButton" class="btn btn lg">Return Change</button>
                            </a>
                        </div>

                    </form>
                </div>
            </div>



        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        </font>
    </body>
</html>

