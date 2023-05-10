<%
String inputString = request.getParameter("uname");
String reverseString = null;
if(inputString != null && !inputString.trim().isEmpty()) {
reverseString = new StringBuilder(inputString).reverse().toString();
}
out.println("Reverse String is\t"+ reverseString);
%>
