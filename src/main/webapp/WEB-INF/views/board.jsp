<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="jsh.tftguide.champion.domain.Champion" %>
<%@ page import="java.util.List" %>
<%
    List<Champion> champions = (List<Champion>) request.getAttribute("champions");
%>

<!DOCTYPE HTML>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TFT GUIDE Game Board</title>
    <link href="css/board.css" rel="stylesheet" type="text/css">
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="js/board.js"></script>
</head>
<body>
    <h1>Game Board</h1>

    <input type="hidden" name="level" id="level" value="1">
    <input type="hidden" name="adItemYn" id="adItemYn" value="N">
    <input type="hidden" name="apItemYn" id="apItemYn" value="N">
    <input type="hidden" name="defItemYn" id="defItemYn" value="N">
    <input type="hidden" name="championNos" id="championNos" value="">

    <div id="level_box" class="flexBox">
        <span id="level_title">Lv</span>
        <span id="level_value">1</span>
        <button id="levelup_btn" onclick="playerLevelUp()">레벨 업</button>
        <button id="leveldown_btn" onclick="playerLevelDown()">레벨 다운</button>
    </div>

    <div id="champion_use" class="flexBox">
        <span id="champion_use_title">사용중인 기물 : </span>
        <ul id="champion_use_list" class="champion_list">
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
        <button id="item_AD" class="use_item_btn" onclick="clickUseAdItem(this)">AD</button>
        <button id="item_AP" class="use_item_btn" onclick="clickUseApItem(this)">AP</button>
        <button id="item_DEF" class="use_item_btn" onclick="clickUseDefItem(this)">방템</button>
    </div>

    <div id="recommend_champion" class="flexBox">
        <span id="recommend_champion_title">추천 기물 : </span>
        <ul id="recommend_champion_list" class="champion_list">
            <li>
                <div>이미지1</div>
                <div>이름1</div>
            </li>
            <li>
                <div>이미지2</div>
                <div>이름2</div>
            </li>
        </ul>
        <div id="additional_synergies"></div>
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

    <div id="champion_list" class="flexBox">
        <ul class="champion_list">
            <% for (Champion champion : champions) { %>
            <li onclick="addChampion(<%=champion.getId()%>)">
                <div><img src="<%=champion.getImageFilePath() + champion.getImageFileName()%>.png"></div>
                <div><%=champion.getName()%></div>
            </li>
            <% } %>
        </ul>
    </div>

    <button>게임 종료</button>
</body>
</html>
