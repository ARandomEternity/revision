<%@ page import="java.util.*" %>
<%
if(request.getParameter("s1")!=null)
{
int n,a,i,sum = 0;
n= Integer.parseInt(request.getParameter("num"));
a = n;
for(i=1;i<a;i++)
{
if(a%i==0)
{
sum=sum + i;
}
}
if(sum==a)
{
out.println(+n+ "is a perfect number");
}
else
{
out.println(+n+ "is not a perfect number");
}
}
%>