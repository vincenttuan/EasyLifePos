<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Head -->
        <%@include file="include/head.jspf"  %>
        <!-- Google Chart -->
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                    ['Sex', 'Count'],
                    ['F', ${ mapSex['F'] }],
                    ['M', ${ mapSex['M'] }]
                ]);

                var options = {
                    title: 'Account of Sex'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                chart.draw(data, options);
            }
        </script>

    </head>
    <body style="padding: 10px">

        <div id="layout">
            <!-- Toggle -->
            <%@include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Member</h1>
                    <h2>${ mapSex }</h2>
                </div>
                <table class="pure-table" style="border: none;">
                    <td valign="top">
                        <!-- 表單 -->
                        <form class="pure-form" 
                              method="post" 
                              action="${pageContext.request.contextPath}/mvc/member/" >

                        </form>
                    </td>
                    <td valign="top">
                        <!-- 列表 -->
                        <form class="pure-form">
                            <fieldset>
                                <legend>Member list</legend>
                                <table class="pure-table pure-table-bordered" width="100%">
                                    <thead>
                                        <tr>
                                            <th>mid</th>
                                            <th>mno</th>
                                            <th>mnickname</th>
                                            <th>maccount</th>
                                            <th>mpassword</th>
                                            <th>memail</th>
                                            <th>mphone</th>
                                            <th>mfrom</th>
                                            <th>createtime</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="m" items="${ members }">
                                            <tr>
                                                <td>${ m.mid }</td>
                                                <td>${ m.mno }</td>
                                                <td>${ m.mnickname }</td>
                                                <td>${ m.maccount }</td>
                                                <td>${ m.mpassword }</td>
                                                <td>${ m.memail }</td>
                                                <td>${ m.mphone }</td>
                                                <td>${ m.mfrom }</td>
                                                <td>${ m.createtime }</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table> 
                            </fieldset>
                        </form>
                    </td>
                    <td valign="top">
                        <!-- 圖表 -->
                        <form class="pure-form">
                            <fieldset>
                                <legend>Sex chart</legend>
                                <div id="piechart" style="width: 500px; height: 300px;"></div>
                            </fieldset>
                        </form>
                    </td>
                </table>   

            </div>
        </div>

        <!-- Foot -->
        <%@include file="include/foot.jspf"  %>

    </body>
</html>