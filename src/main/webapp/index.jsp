<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>login</title>
</head>
<body>

<form action="index">
  <label for="name">Name</label>
  <input name="name" type="text" id="name">
  <label for="password">Password</label>
  <input name="password" type="password" id="password">
  <button type="submit">Login</button>
</form>

<h1>Random Number:</h1>
<p id="randomNumber">Loading...</p>
<script>
  function getRandomNumber() {
    // Generate a random number (for example, between 1 and 100)
    var random = Math.floor(Math.random() * 100) + 1;
    document.getElementById("randomNumber").textContent = random;
  }

  // Call getRandomNumber initially
  getRandomNumber();
</script>
<form  method="post" action="LoggedServlet">
  <button type="submit">LogOut</button>
</form>


</body>
</html>