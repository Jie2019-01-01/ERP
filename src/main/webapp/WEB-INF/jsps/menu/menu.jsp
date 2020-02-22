<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>tree-view</title>
	
	<link  rel="stylesheet" href="js/treeview/jquery.treeview.css"/>
	<link  rel="stylesheet" href="js/treeview/screen.css"/>
	
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/treeview/jquery.cookie.js"></script>
	<script type="text/javascript" src="js/treeview/jquery.treeview.min.js"></script>
	<script type="text/javascript" src="js/treeview/jquery.treeview.async.js"></script>

</head>
<body>

	<ul id="black" class="filetree treeview"></ul>

</body>
	<script type="text/javascript">
		$('#black').treeview({
			url: 'menu_showMenu.action'
		});
	</script>
</html>