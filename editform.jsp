<%@ page import="com.codegnan.dto.Vehicle" %>
<!DOCTYPE html>
<html>
<head>
<title>Edit Vehicle</title>
<style>
body{
    background:#fdf4ff;
    font-family:Arial;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}
.card{
    background:white;
    padding:30px;
    width:350px;
    border-radius:10px;
}
input,button{
    width:100%;
    padding:10px;
    margin-top:10px;
}
button{
    background:#7c3aed;
    color:white;
    border:none;
}
</style>
</head>
<body>

<div class="card">
<h2>Edit Vehicle</h2>

<%
Vehicle v = (Vehicle)request.getAttribute("vehicle");
%>

<form method="post" action="update.do">
<input type="hidden" name="id" value="<%=v.getId()%>">
<input name="brand" value="<%=v.getBrand()%>">
<input name="model" value="<%=v.getModel()%>">
<input name="price" value="<%=v.getPrice()%>">
<button>Update</button>
</form>

</div>

</body>
</html>
