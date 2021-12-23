/* 
  ● 호이스팅 (Hoisting)
  : 자바스크립트의 인터프리터가 함수 선언과 변수선언을
    선언들이 속해 있는 스코프의 최상다능로 "끌어올리는" 방법에 관한 일종의 비유 
*/

travel = 'No plan';
var travel;
console.log(travel);

function travel() {
    console.log('Traveling');
}
// travel();  // Uncaught Type Error : travel is not a function

//-------------------------------------------------------------------------


/* 자바스크립트의 인터프리터는 위 코드 처리시 다음과 같이 이해함 */
// 1. 함수 선언은 최상위로 위치 시킴
function travel() {
    console.log('Traveling');
}
// 2. 변수 선언은 함수 선언 아래에 위치 시킴
var travel;
travel = 'No plan';

console.log(travel);
// travel();  // Uncaught Type Error : travel is not a function

/*
    var travel = function(){} 과 같은 함수 표현식은
    변수선언이기도 해서 함수 선언처럼 최상위로 이동되지 않음
*/

//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

function workOut() {
    var goToGym = function(){
        console.log('Workout in Gym AAA');
    }
    goToGym();
    function goToGym(){
        console.log('Workout in Gym BBB');
    }
    return;
}
workOut();

//>>>>>>인터프리터의 처리>>>>>>

function workOut() {
    //1. 최상위에 함수선언 이동
    function goToGym(){  
        console.log('Workout in Gym B');
    }

    //2. 변수를 선언하지만 대입은 하지않음
    var goToGym;
    goToGym();
    goToGym = function(){
        console.log('Workout in Gym A');
    }
    return;
}
workOut();