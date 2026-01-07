<%@ page import="java.util.*,com.codegnan.dto.Vehicle" %>
<!DOCTYPE html>
<html>
<head>
<title>All Vehicles</title>
<style>
body{font-family:Arial;background:#f4f6f8;}
table{
    margin:auto;
    border-collapse:collapse;
    width:70%;
    background:white;
}
th,td{
    padding:12px;
    border:1px solid #ddd;
    text-align:center;
}
th{background:#2563eb;color:white;}
a{
    text-decoration:none;
    color:#2563eb;
    font-weight:bold;
}
</style>
</head>
<body>

<h2 align="center">🚗 Vehicle List</h2>

<table>
<tr>
    <th>ID</th>
    <th>Brand</th>
    <th>Model</th>
    <th>Price</th>
</tr>

<%
List<Vehicle> list = (List<Vehicle>)request.getAttribute("list");
for(Vehicle v : list){
%>
<tr>
    <td><%=v.getId()%></td>
    <td><%=v.getBrand()%></td>
    <td><%=v.getModel()%></td>
    <td><%=v.getPrice()%></td>
</tr>
<% } %>

</table>

</body>
</html>
