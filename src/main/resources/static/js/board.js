function playerLevelUp() {
    var levelEl = document.getElementById("level_value");
    var levelupValue = parseInt(document.frmMain.level.value) + 1;

    document.frmMain.level.value = levelupValue;
    levelEl.innerHTML = String(levelupValue);
}

function clickUseAdItem(e) {
    e.classList.toggle("active");
    if (e.classList.contains("active")) {
        document.frmMain.adItemYn.value = "Y";
    } else {
        document.frmMain.adItemYn.value = "N";
    }
}

function clickUseApItem(e) {
    e.classList.toggle("active");
    if (e.classList.contains("active")) {
        document.frmMain.apItemYn.value = "Y";
    } else {
        document.frmMain.apItemYn.value = "N";
    }
}

function clickUseDefItem(e) {
    e.classList.toggle("active");
    if (e.classList.contains("active")) {
        document.frmMain.defItemYn.value = "Y";
    } else {
        document.frmMain.defItemYn.value = "N";
    }
}