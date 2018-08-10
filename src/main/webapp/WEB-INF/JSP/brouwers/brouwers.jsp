<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Brouwers' />
</head>
<body>
	<v:menu />
	<h1>Alle brouwers</h1>
	<table>
		<thead>
			<tr>
				<th scope="col">Nummer</th>
				<th scope="col">Naam</th>
				<th scope="col">Straat</th>
				<th scope="col">HuisNr</th>
				<th scope="col">PostCode</th>
				<th scope="col">Gemeente</th>
				<th scope="col">Omzet</th>
			</tr>
		</thead>
		<c:forEach items='${brouwers}' var="brouwer">
			<tbody>
				<tr>
					<td>${brouwer.id}</td>
					<td>${brouwer.naam}</td>
					<td>${brouwer.adres.straat}</td>
					<td>${brouwer.adres.huisNr}</td>
					<td>${brouwer.adres.postcode}</td>
					<td>${brouwer.adres.gemeente}</td>
					<td>${brouwer.omzet}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>