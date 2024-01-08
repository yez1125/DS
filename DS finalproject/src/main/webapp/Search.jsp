<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Google-like Search</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url(https://pgw.udn.com.tw/gw/photo.php?u=https://uc.udn.com.tw/photo/2021/06/28/98/12749024.jpg&x=0&y=0&sw=0&sh=0&sl=W&fw=800&exp=3600&w=930); /* 替換成您的圖片路徑 */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }

        #search-container {
            max-width: 600px;
            width: 100%;
            padding: 20px;
            box-sizing: border-box;
            background-color: rgba(255, 255, 255, 0.8); /* 背景色透明度，您可以根據需要調整 */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            text-align: center;
        }

        img {
            display: block;
            margin: 0 auto;
        }

        form {
            margin-top: 20px;
        }

        #search-box {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }

        #search-button {
            padding: 10px;
            font-size: 16px;
            background-color: #4285f4;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div id="search-container">
        <img src="https://cdn-icons-gif.flaticon.com/12035/12035115.gif" alt="image" width="272" height="272">
        <form>
            <input type="text" id="search-box" name="keyword" placeholder="搜尋 Google 或輸入網址">
            <br>
            <button type="submit" id="search-button">On the Google 搜尋</button>
        </form>
    </div>
</body>
</html>
