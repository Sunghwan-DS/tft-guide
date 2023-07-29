function playerLevelUp() {
    var levelEl = document.getElementById("level_value");
    var levelupValue = parseInt(document.getElementById("level").value) + 1;

    if (levelupValue > 11) {
        alert("더이상 레벨업을 할 수 없습니다.");
        return;
    }

    document.getElementById("level").value = levelupValue;
    levelEl.innerHTML = String(levelupValue);
}

function playerLevelDown() {
    var levelEl = document.getElementById("level_value");
    var levelupValue = parseInt(document.getElementById("level").value) - 1;

    if (levelupValue < 1) {
        alert("더이상 레벨다운을 할 수 없습니다.");
        return;
    }

    document.getElementById("level").value = levelupValue;
    levelEl.innerHTML = String(levelupValue);
}

function clickUseAdItem(e) {
    e.classList.toggle("active");
    if (e.classList.contains("active")) {
        document.getElementById("adItemYn").value = "Y";
    } else {
        document.getElementById("adItemYn").value = "N";
    }
}

function clickUseApItem(e) {
    e.classList.toggle("active");
    if (e.classList.contains("active")) {
        document.getElementById("apItemYn").value = "Y";
    } else {
        document.getElementById("apItemYn").value = "N";
    }
}

function clickUseDefItem(e) {
    e.classList.toggle("active");
    if (e.classList.contains("active")) {
        document.getElementById("defItemYn").value = "Y";
    } else {
        document.getElementById("defItemYn").value = "N";
    }
}

function addChampion(id) {
    championNos = document.getElementById("championNos").value;

    if (championNos !== "" && championNos.split(",").length >= document.getElementById("level").value) {
        alert("챔피언을 더 넣을 수 없습니다");
        return;
    }

    if (championNos === "") {
        document.getElementById("championNos").value = id;
    } else {
        document.getElementById("championNos").value = championNos + "," + id;
    }
    getChampionGuideAjax();
}

function getChampionGuideAjax() {

    var url = "/guide/champions";
    var card = "<li>\n" +
        "                <div>이미지1</div>\n" +
        "                <div>이름1</div>\n" +
        "            </li>"

    $.ajax({
        type: "GET",
        url: url,
        data: {
            level: document.getElementById("level").value,
            adItemYn: document.getElementById("adItemYn").value,
            apItemYn: document.getElementById("apItemYn").value,
            defItemYn: document.getElementById("defItemYn").value,
            championNos: document.getElementById("championNos").value
        },
        dataType: 'json',
        success: function (response) {
            console.log(response);
            var championUseList = response.useChampions;
            var championUseListHTML = "";

            for (var i = 0; i < championUseList.length; i++) {
                championUseListHTML += "<li><div><img src=" + championUseList[i].imgUrl + "></div><div>" + championUseList[i].championName + "</div></li>"
            }
            document.getElementById("champion_use_list").innerHTML = championUseListHTML;

            var recommendChampionsGroup = response.recommendChampions;
            console.log(recommendChampionsGroup);
            var recommendChampionListHTML = "";
            var additionalSynergyListHTML = "";
            for (i = 0; i < recommendChampionsGroup.length; i++) {
                recommendChampionListHTML = "";
                additionalSynergyListHTML = "";
                console.log(recommendChampionsGroup[i]);
                for (var j = 0; j < recommendChampionsGroup[i].recommendChampions.length; j++) {
                    recommendChampionListHTML += "<li><div><img src=" + recommendChampionsGroup[i].recommendChampions[j].imgUrl + "></div><div>" + recommendChampionsGroup[i].recommendChampions[j].championName + "</div></li>"
                }
                for (var j = 0; j < recommendChampionsGroup[i].additionalSynergies.length; j++) {
                    additionalSynergyListHTML += "<div>" + recommendChampionsGroup[i].additionalSynergies[j].name + recommendChampionsGroup[i].additionalSynergies[j].count +"</div>";
                }
                document.getElementById("recommend_champion_list").innerHTML = recommendChampionListHTML;
                document.getElementById("additional_synergies").innerHTML = additionalSynergyListHTML;
            }
        }
    });
}