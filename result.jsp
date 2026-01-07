<%@ page import="com.codegnan.dto.Vehicle" %>
<!DOCTYPE html>
<html>
<head>
<title>Search Result</title>
<style>
body{
    font-family:Arial;
    background:#eef2ff;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}
.card{
    background:white;
    padding:30px;
    border-radius:10px;
    width:300px;
    box-shadow:0 10px 25px rgba(0,0,0,0.2);
}
</style>
</head>
<body>

<div class="card">
<%
Vehicle v = (Vehicle)request.getAttribute("v");
if(v==null){
%>
<h3>No Vehicle Found</h3>
<%
}else{
%>
<h2>Vehicle Details</h2>
<p><b>ID:</b> <%=v.getId()%></p>
<p><b>Brand:</b> <%=v.getBrand()%></p>
<p><b>Model:</b> <%=v.getModel()%></p>
<p><b>Price:</b> ₹<%=v.getPrice()%></p>
<% } %>
</div>

</body>
</html>
