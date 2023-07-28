<!DOCTYPE HTML>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TFT GUIDE Game Board</title>
    <link href="css/board.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/board.js"></script>
</head>
<body>
    <h1>Game Board</h1>
    <div id="level" class="flexBox">
        <span id="level_title">Lv</span>
        <span id="level_value">1</span>
        <button id="levelup_btn" onclick="">레벨 업</button>
    </div>

    <div id="champion_use" class="flexBox">
        <span id="champion_use_title">사용중인 기물 : </span>
        <ul class="champion_list">
            <li>
                <div>이미지1</div>
                <div>이름1</div>
            </li>
            <li>
                <div>이미지2</div>
                <div>이름2</div>
            </li>
        </ul>
    </div>

    <div id="item_use" class="flexBox">
        <span id="item_use_title">템 방향성 : </span>
        <button id="item_AD" value="ad" class="kind_of_use_item" onclick="clickUseItem(this)">AD</button>
        <button id="item_AP" value="ap" class="kind_of_use_item" onclick="clickUseItem(this)">AP</button>
        <button id="item_DEF" value="def" class="kind_of_use_item" onclick="clickUseItem(this)">방템</button>
    </div>

    <div id="recommend_champion" class="flexBox">
        <span id="recommend_champion_title">추천 기물 : </span>
        <ul class="champion_list">
            <li>
                <div>이미지1</div>
                <div>이름1</div>
                <div>추가시너지1</div>
            </li>
            <li>
                <div>이미지2</div>
                <div>이름2</div>
                <div>추가시너지2</div>
            </li>
        </ul>
    </div>

    <div id="recommend_deck" class="flexBox">
        <span id="recommend_deck_title">추천 덱 : </span>
        <ul class="champion_list">
            <li>
                <div>이미지1</div>
                <div>이름1</div>
            </li>
            <li>
                <div>이미지2</div>
                <div>이름2</div>
            </li>
        </ul>
    </div>

    <button>게임 종료</button>
</body>
</html>
