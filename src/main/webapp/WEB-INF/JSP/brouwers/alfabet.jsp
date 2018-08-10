<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang='nl'>
<head>
<v:head title='Brouwers op alfabet' />
</head>
<body>
	<v:menu />
	<h1>Brouwers op alfabet ${empty gekozenletter ? "" : gekozenletter}</h1>
	<ul class='zonderbolletjes'>
		<c:forEach items='${alfabet}' var='letter'>
			<spring:url value='/brouwers/alfabet/{letter}' var='letterURL'>
				<spring:param name='letter' value='${letter}' />
			</spring:url>
			<li><a href='${letterURL}'>${letter}</a></li>
		</c:forEach>
	</ul>
	<c:if test='${not empty brouwers}'>
		<ul>
			<c:forEach items='${brouwers}' var='brouwer'>
				<li>${brouwer.naam}(${brouwer.adres.gemeente})</li>
			</c:forEach>
		</ul>
	</c:if>
	<c:if test='${empty brouwers and not empty gekozenletter}'>
		<p>Er zijn geen brouwers met beginletter ${gekozenletter}</p>
	</c:if>
</body>
</html>