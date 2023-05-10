
<%
int n = Integer.parseInt(request.getParameter("num"));
int i,flag=0;
for(i=2;i<=n/2;i++)
{
if(n%i==0)
{
flag=1;
break;
}
}
if(flag==0)
{
%>
<html>
<body>
<font size ="14" color="blue"><% out.println(n+"\t is a prime number"); %>
</body>
</html>
<%
}
else
{
%>
<html>
<body>
<font size ="14" color="red"><% out.println(n+"\t is not a prime number");%>
</body>
</html>
<%
}
%>