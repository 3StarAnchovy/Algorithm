function randomNum(min, max){
    var randNum = Math.random()*(max-min) + 1.2;
    return randNum;
}

console.log(randomNum(1.2, 1.4));
