// var a = document.getElementsByClassName("a");

// for (let val of a) {
//     console.log(val);
// }

// for (let val in a) {
//     console.log(val);
// }

// for (let i = 0; i < a.length; i++) {
//     console.log(a[i]);
// }

// Array.prototype.filter.call(a,function(val) {
//     console.log(val);
// });
// console.log('[getElementsByClassName] ')
// console.log(a)

// var b = document.querySelectorAll('.a');

// console.log('[querySelectorAll]')
// console.log(b)
// console.log()
// b.forEach(val => {
//     console.log(val)
// });


function User(name, inter) {
    this.name = name;
    this.inter = inter;
}

var user = new User('IronMan',['날기','술마시기']);

User.prototype.greeting = function () {
    console.log("Hi, I'm " + this.name + "!");
};


//상속
function TeamMember(name, inter, task) {
    User.call(this, name, inter);
    this.task = task;
}

TeamMember.prototype = Object.create(User.prototype);

TeamMember.prototype.greeting = function () {
    console.log('I\'m '+this.name+'. Welcome to the Team')
}

TeamMember.prototype.work = function () {
    console.log('I\'m working on '+this.task.length+' tasks');
}

var member = new TeamMember("Sunny",['여행'],['티켓사기','호텔예약']);

member.greeting();
member.work();

console.log(member instanceof TeamMember);
console.log(member instanceof User);
console.log(member instanceof Object);

User.prototype.eat = function () {
    console.log('점심 뭐먹을래?');
}

member.eat();
user.eat();

Object.prototype.move = function(){
    console.log('이제 모든 오브젝트가 move를 호출할 수 있다')
}

member.move();
user.move();

var alien ={};
alien.move();
User.move();


//--------------------------------------

