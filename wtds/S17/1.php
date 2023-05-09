<!DOCTYPE html>
<html>
  <body onload="showGreeting()">
    <script>
      function showGreeting() {
        alert("Hello, Good Morning!");
      }
    </script>
    <h1>Student Registration Form</h1>
    <form>
      Name:
      <input type="text" id="name" name="name" >
      <br>
     Email:
      <input type="email" id="email" name="email" >
      <br>
      Phone:
      <input type="tel" id="phone" name="phone" >
      <br>
      <input type="submit" value="Submit">
    </form>
  </body>
</html>