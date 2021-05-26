<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
div {
	margin-bottom: 8px;
}

label {
	display: inline-block;
	width: 120px;
	text-align: left;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trade Management</title>
</head>
<body>
	<b>Create/Update Trades</b>
	<br>
	<br>
	<form action="addTrade" method="POST">
		<div>
			<label>Trade ID:</label> <input type="text" name="tradeID">
			Should be mandatory
		</div>
		<div>
			<label>Version:</label> <input type="text" name="version">
			Should be numeric value
		</div>
		<div>
			<label>CounterParty ID:</label> <input type="text"
				name="counterPartyID">
		</div>
		<div>
			<label>Book ID:</label> <input type="text" name="bookId"><br>
		</div>
		<div>
			<label>Maturity Date:</label> <input type="text" name="maturityDate">
			Should be "dd/mm/yyyy" format
		</div>
		<br>
		<div>
			<input type="submit" value="Create/Update"><br>
		</div>
	</form>
</body>
</html>



