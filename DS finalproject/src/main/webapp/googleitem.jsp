<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
<style type="text/css">

body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            /*justify-content: center;*/

            height: 100vh;
            background-image: url(https://pgw.udn.com.tw/gw/photo.php?u=https://uc.udn.com.tw/photo/2021/06/28/98/12749024.jpg&x=0&y=0&sw=0&sh=0&sl=W&fw=800&exp=3600&w=930); /* 替換成您的圖片路徑 */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }
#padding{
	padding: 0px 0px 15px 15px;
}
a {
	color: #0B173B;
	font-size: 30px;
	text-decoration: none;
}
a:hover{
text-decoration:underline;
}
.border-style {
	border-radius: 90px/90px;
}
</style>
</head>
<body>
<body>
<form action='${requestUri}' method='get'>

	<div style='position: absolute;margin-left:50px;margin-top: 230px; background-color: MediumSeaGreen'>
		<%
		String[][] orderList = (String[][]) request.getAttribute("query");
		for (int i = 0; i < orderList.length; i++) {
			String s=orderList[i][1];
			
		%>
		
		<a href='<%=s%>'><%=orderList[i][0]%> </a> <br>連結<br>
		<br>
		<%
}
%>
	</div>
	<div>
		<img src="https://i.pinimg.com/736x/c6/35/ee/c635eec91f05b8a1c4f03a7b2eae770c.jpg"
			style='position: absolute; width: 150px; height: 100px; left: 50%; top: 50%; margin-top: -280px; margin-left: -650px'>
	</div>
	<div>
		
		
		<input type='text' class="border-style" id="padding" name='keyword'
			style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -250px; margin-left: -450px; width: 800px; height: 25px; margin right  = 10px'
			placeholder = '請輸入關鍵字'  class="underLineStyle inputPaddingRight"  value='<%=request.getParameter("keyword")%>'/>
		<button style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -240px; margin-left: 150px; width: 200px; height: 25px; margin right  = 10px'
			type="submit" id="search-button">On the Google 搜尋</button>
	</div>

</form>
</body>
</html>