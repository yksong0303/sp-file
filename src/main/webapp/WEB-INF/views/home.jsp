<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<input type="file" name="file1" id="file1">
	<input type="text" name="writer" id="writer">
	<button onclick="upload()">전송</button>

<script>
function upload(){
	var data = new FormData();
	data.append('file1',$('#file1')[0].files[0]);
	data.append('writer',$('#writer').val())
	$.ajax({
		url:'/upload',
		enctype:'multipart/form-data',
		data:data,
		processData: false,
		contentType:false,
		method:'POST',
		success:function(res){
			
		},
		error:function(err){
			
		}
	})
}
</script>
</body>
</html>
