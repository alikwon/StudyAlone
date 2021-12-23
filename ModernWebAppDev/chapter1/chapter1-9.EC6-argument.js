/* 매개 변수 기본값 정의 */
const shoppingCart = [];
function addToCart(item, size = 1) {
    shoppingCart.push({ item: item, count: size });
}
addToCart("Apple"); // size를 정의하지않아도 기본값 1
addToCart("Orange", 2);

console.log(shoppingCart);

/*=======================================================================

    - ES6에서는 나머지 매개변수 구문으로 무한개의 매개변수를 배열로 정의하는데 사용 */
    
    // ES5
    function workout5(exercise1) {
        console.log(arguments instanceof Array);
        var todos = Array.prototype.slice.call(arguments, workout5.length);
        console.log("Start from " + exercise1);
        console.log(todos.length + " more to do");
        console.log("Args length: " + workout5.length);
    }
    
    // ES6 : "..." 로 나머지 매개변수 
    function workout6(exercise2, ...todos) {
        console.log(todos instanceof Array);
        console.log("Start from " + exercise2);
        console.log(todos.length + " more to do");
        console.log("Args length: " + workout6.length);
    }
    
    workout5("Treadmill", "Pushup", "Spinning");
    workout6("Treadmill", "Pushup", "Spinning");
    
    
    
/*=======================================================================
● 전개구문
    - ES6에서 3점 표기법을 함수 선언 내에 사용하면 그것이 나머지 매개변수를 정의한다
    - 배열에 사용하면 배열의 요소들을 전개시킨다 */

let urgentTasks = ['Buy three tickets','Call'];
let nomalTasks = ['Book a hotel', 'Rent a car'];
let allTasks = [...urgentTasks, ...nomalTasks];

console.log(allTasks);

((first, second) => {
    console.log('Working on ' + first + ' and ' + second);
})(...allTasks);

((...a) => {
    a.forEach((v,i) => {
        console.log(i,v);
    });
})(...allTasks);