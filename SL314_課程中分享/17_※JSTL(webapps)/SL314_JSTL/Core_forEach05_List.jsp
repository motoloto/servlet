<%@ page contentType="text/html;charset=Big5" pageEncoding="Big5" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Core_forEach</title>
</head>
<body>

<h2><c:out value="<c:forEach> ªº¥Îªk" /></h2>

<%	
	  List list = new ArrayList();
		  list.add("Hello");
		  list.add("World");
		request.setAttribute("list", list);
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			String str = (String)it.next();
			out.println(str);
		}

%>

<br>	
<c:forEach var="data" items="${list}" >
  ${data}
</c:forEach>

</body>
</html>