<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<link rel="icon" href="/resources/img/favicon1.ico" type="image/x-icon">
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	파일 : <input type="file" name="file1" id="file1"><br>
	이름 : <input type="text" name="custname" id="custname"><br>
	전화번호 : <input type="text" name="phone" id="phone"><br>
	주소 : <input type="text" name="address" id="address"><br>
	지역 : <input type="text" name="city" id="city"><br>
	등급 : <input type="text" name="grade" id="grade"><br>
	가입일 : <input type="text" name="joindate" id="joindate"><br>
	
	<button onclick="upload()">전송</button>
 
<script>
function upload(){
	var data = new FormData();
	data.append('file1',$('#file1')[0].files[0]);
	data.append('custname',$('#custname').val())
	data.append('phone',$('#phone').val())
	data.append('address',$('#address').val())
	data.append('city',$('#city').val())
	data.append('grade',$('#grade').val())
	data.append('joindate',$('#joindate').val())
	$.ajax({
		url:'/sp-file/upload',
		enctype:'multipart/form-data',
		data:data,
		processData: false,
		contentType:false,
		method:'POST',
		success:function(res){
			if(res==1){
				alert('등록 성공!');
				location.href='/sp-file'
			}else{
				alert('등록 실패');
			}
		},
		error:function(err){
			
		}
	})
}
</script>
</body>
</html>
