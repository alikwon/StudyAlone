const fruits = [
    { name: "apple", price: 100 },
    { name: "orange", price: 80 },
    { name: "banana", price: 120 },
];

/*=======================================================

● 변형1
인자가 없을 때 빈 괄호 세트()가 필요하다. */
var countFruits6 = () => fruits.length;
console.log(countFruits6());

// ES5 코드
var countFruits5 = function () {
    return fruits.length;
};
console.log(countFruits5());


/*======================================================= 

● 변형2
- 하나의 인자가 있을 때 괄호는 생략 가능하다
- 표현식의 값은 함수의 반환 값이다.*/
var arr6 = fruits.filter((fruit) => fruit.price > 80);
console.log(arr6);

// ES5 코드
var arr5 = fruits.filter(function (fruit) {
    return fruit.price > 80;
});
console.log(arr5);


/*=======================================================

● 변형3
함수가 객체 리터럴을 반환할 때 괄호로 감싸야 한다.*/
var inventory6 = fruits.map((fruit) => ({ name: fruit.name, storage: 1 }));
console.log(inventory6);

// ES5 코드
var inventory5 = fruits.map(function (fruit) {
    return { name : fruit.name, storage: 1 };
});
console.log(inventory5);

//  주의 사항
//   >  화살표함수에 중괄호를 사용하면 함수 본문은 단일 또는 여러명령문으로 구성되어야 함.
var sum = (a,b) => { return a + b};
var sum2 = (a,b) => { a + b }; //undifined
var sum3 = (a,b) => a + b;
console.log(sum(1,2));
console.log(sum2(1,2));
console.log(sum3(1,2));


/*=======================================================
● 변형4
화살표함수가 구문들로 이뤄진 본문을 가지고 있고 결과를 반환해야 할 때 return 구문이 필요하다.*/
var inventory2_6 = fruits.map(fruit => {
    console.log('Checking '+fruit.name + ' storage');
    return { name : fruit.name, storage: 1 };
});
console.log(inventory2_6);

// ES5 코드
var inventory2_5 = fruits.map(function(fruit){
    console.log('Checking '+fruit.name + ' storage');
    return { name : fruit.name, storage: 1 };
});
console.log(inventory2_5);




/*=======================================================
=========================================================
 - 화살표함수는 자신의 this를 가지지 않는다 
 - ES5 함수는 분리된 실행 컨텍스트를 생성하지만, 화살표함수는 상위 스코프의 실행 컨텍스트를 사용한다.*/
var shoppingCart6 ={
    items : ['Apple', 'Orange'],
    inventory: { Apple : 1, Orange : 0},
    checkout(){
        this.items.forEach(item => {
            if(this.inventory[item]){
                console.log('Item ' + item + ' has sold out.');
            }
        });
    }
}
shoppingCart6.checkout();

//ES5 코드
var shoppingCart5 ={
    items : ['Apple', 'Orange'],
    inventory: { Apple : 1, Orange : 0},
    checkout(){
        //컨택스트를 재할당하고 forEach에 전달한 콜백에서 참조할 수 있도록 클로저 활용.
        var that = this; 
        this.items.forEach(function(item) {
            if(that.inventory[item]){
                console.log('Item ' + item + ' has sold out.');
            }
        });
    }
}
shoppingCart5.checkout();


/* =========================================================
    - 화살표함수는 분리된 실행 컨텍스트를 가지고 있지 않아서 
        call(), apply(), bind()메소드를 활용해 호출하면 첫 번째 인자로 전달받은 실행 컨텍스트가 무시됨. */
var name = 'Unknown';
var greeting = () => {
    console.log('Hi I\'m ' + this.name);
}
// var greeting = function(){
//     console.log('Hi I\'m ' + this.name);
// }

greeting.call({name: 'Sunny'});
greeting.apply({name: 'Tod'});

var newGreeting = greeting.bind({name: 'James'});
newGreeting();

/*==================================================================
    - 화살표함수는 상위 스코프의 실행 컨텍스트 ("자신을 감싸고 있는 객체를 실행하는 컨텍스트")를 이용하기 때문에 
        객체의 메소드를 정의하는데 사용하는 것은 부적합함. --> 계산을 하는데 이용 */
var shoppingCart ={
    items : ['Apple', 'Orange'],
    inventory: { Apple : 1, Orange : 0},
    checkout: () => {
        this.items.forEach(item => {
            if(that.inventory[item]){
                console.log('Item ' + item + ' has sold out.');
            }
        });
    }
}
// shoppingCart.checkout(); // Uncaught TypeError 


class User {
    constructor(name){
        this.name = name;
    }
}
User.prototype.swim = () => {
    // this는 User 객체를 참조하지 않음 --> 전역 컨텍스트 참조
    console.log(this.name + ' is swimming'); 
};

var user = new User('Test');
user.swim();


/*
    - 화살표함수는 프로토타입 객체를 가지지 않는다 
        > 따라서 생성자 함수를 가지지 않는다 
        > new 연산자로 호출할 수도 없다.        */
const WorkoutPlan = () => {};
// const WorkoutPlan = function() {};

let workoutPlan = new WorkoutPlan();
console.log(WorkoutPlan.prototype);