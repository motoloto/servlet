<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="forms" uri="http://www.soccer.org/forms.tld" %>

<%-- Set page title --%>
<c:set var="pageTitle">Duke's Soccer League: Registration</c:set>

<%-- Create business services --%>
<jsp:useBean id="leagueSvc" class="sl314.model.LeagueService" />

<%-- Generate the HTML response --%>
<html>
<head>
  <title>${pageTitle}</title>
</head>
<body bgcolor='white'>

<%-- Generate page heading --%>
<!-- Page Heading -->
<table border='1' cellpadding='5' cellspacing='0' width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
  <td><h3>${pageTitle}</h3></td>
</tr>
</table>

<%-- Create the Progress Monitor --%>
<br/>
<table border='1' cellspacing='0' cellpadding='0' width='400'>
<tr height='20'>
  <td bgcolor='#CCCCFF' align='center' valign='center' height='20'>
    <b>1) Select League</b>
  </td>
  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
    <b>2) Enter Player Info</b>
 </td>
  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
    <b>3) Select Division</b>
  </td>
</tr>
</table>
<br/>

<%-- Report any errors (if any) --%>
<html:errors />

<%-- Present the form --%>
<form action='<c:url value="select_league.do" />' method='POST'>

<%-- Repopulate the year field --%>
Year: <input type='text' name='yearStr' value='${param.yearStr}' />
<br/><br/>

<%-- Repopulate the season drop-down menu --%>
Season:
<forms:select param='season'>
  <c:forEach var="season" items="${leagueSvc.allSeasons}">
    <forms:option value="${season}">${season}</forms:option>
  </c:forEach>
</forms:select>
<br/><br/>

<input type='Submit' value='Continue...' />
</form>
<%@ page contentType="text/html; charset=UTF-8"%>
</body>
</html>
