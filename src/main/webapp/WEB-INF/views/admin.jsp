<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>가게 허가 신청</title>
    <!-- 글씨체 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: rgb(247, 237, 244);
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: "Jua", sans-serif;
            font-weight: 500;
            font-style: normal;
        }

        .content {
            width: 715px;
            height: 100vh;
            background-color: rgb(252, 246, 247);
            display: grid;
            grid-template-rows: 1fr 10fr 1fr;
        }

        aside {
            background-color: #f0f0f0;
            width: 200px;
            padding: 20px;
            position: fixed;
            left: 0;
            top: 0;
            bottom: 0;
        }

        aside nav ul {
            list-style: none;
            padding: 0;
        }

        aside nav ul li a {
            display: block;
            padding: 10px;
            color: black;
            text-decoration: none;
        }

        main {
            flex-grow: 1;
            padding: 20px;
            margin-left: 240px;
        }

        .file-upload {
            margin-top: 50px;
            padding: 20px;
            border: 1px solid #555151;
            border-radius: 5px;
        }

        .file-upload h2 {
            margin-bottom: 20px;
            margin-top: 0; 
        }

        .file-upload .form-group {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            margin-bottom: 15px;
        }

        .file-upload .form-group-row {
            display: flex;
            align-items: center;
            width: 100%;
        }

        .file-upload label {
            flex: 0 0 150px;
            margin-right: 10px;
        }

        .file-upload input[type="text"],
        .file-upload input[type="file"],
        .file-upload select {
            flex: 1;
            padding: 10px;
            border: 1px solid #aaaaaa;
            background-color: #dddddd;
            border-radius: 5px;
            font-size: 16px;
        }

        .file-upload .form-group p {
            color: red;
            font-size: 14px;
            margin-left : 165px;
            align-self: flex-start;
            display: none; /* 초기에는 숨김 */
        }

        .file-upload button {
            background-color: #19209b;
            border-radius: 10px;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            margin-left: auto; /* This line will move the button to the right */
        }

        .file-upload button:hover {
            background-color: #97b8c2;
        }
    </style>
</head>
<body>
    <aside>
        <nav>
            <ul>
                <li><a href=""><h1>배민관리자</h1></a></li>
                <li><a href="">홈</a></li>
                <li><a href="">사장계정관리</a></li>
                <li><a href="">손님계정관리</a></li>
                <li><a href="">리뷰관리</a></li>
                <li><a href="">문의사항</a></li>
                <li><a href="">가게 허가 신청</a></li>
            </ul>
        </nav>
    </aside>

    <main>
        <div class="header">
            <h2>가게 허가 신청</h2>
        </div>
        <div class="file-upload">
            <form action="submit_file.php" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="name">가게 이름:</label>
                        <input type="text" id="name" name="name" required>
                    </div>
                    <p id="nameError">10글자 내로 작성해주세요.</p>
                </div>      
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="address">가게 주소:</label>
                        <input type="text" id="address" name="address" required>
                    </div>
                    <p id="addressError">25글자 내로 작성해주세요.</p>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="address-detail">가게 상세 주소:</label>
                        <input type="text" id="address-detail" name="address-detail" required>
                    </div>
                    <p id="addressDetailError">15글자 내로 작성해주세요.</p>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="store_category_no">가게 종목:</label>
                        <select id="store_category_no" name="store_category_no" required>
                            <option value="1">찜,탕,찌개</option>
                            <option value="2">족발,보쌈</option>
                            <option value="3">돈까스,회,일식</option>
                            <option value="4">패스트푸드</option>
                            <option value="5">피자</option>
                            <option value="6">고기구이</option>
                            <option value="7">야식</option>
                            <option value="8">양식</option>
                            <option value="9">1인분</option>
                            <option value="10">치킨</option>
                            <option value="11">중식</option>
                            <option value="12">아시안</option>
                            <option value="13">백반,죽,국수</option>
                            <option value="14">도시락</option>
                            <option value="15">분식</option>
                            <option value="16">카페,디저트</option>
                            <option value="17">채식</option>
                            <option value="18">반찬</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="company_resistraion_number">사업자 등록 번호:</label>
                        <input type="text" id="company_resistraion_number" name="company_resistraion_number" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="business_resistration">사업자 등록증:</label>
                        <input type="file" id="business_resistration" name="business_resistration" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <button type="submit">제출</button>
                    </div>
                </div>
            </form>
        </div>
    </main>

    <script>
        function validateForm() {
            var name = document.getElementById("name").value;
            var address = document.getElementById("address").value;
            var addressDetail = document.getElementById("address-detail").value;

            var nameError = document.getElementById("nameError");
            var addressError = document.getElementById("addressError");
            var addressDetailError = document.getElementById("addressDetailError");

            var valid = true;

            if (name.length > 10) {
                nameError.style.display = "block";
                valid = false;
            } else {
                nameError.style.display = "none";
            }

            if (address.length > 25) {
                addressError.style.display = "block";
                valid = false;
            } else {
                addressError.style.display = "none";
            }

            if (addressDetail.length > 15) {
                addressDetailError.style.display = "block";
                valid = false;
            } else {
                addressDetailError.style.display = "none";
            }

            return valid;
        }
    </script>
</body>
</html>
