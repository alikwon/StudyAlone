class User {
    constructor(name, interests) {
        this.name = name;
        this.interests = interests;
    }
    greeting(){
        console.log('Hi I\'m '+ this.name);
    }
    get interestsCount(){
        return this.interests ? this.interests.length : 0;
    }
}


class TeamMember extends User {
    constructor(name,interests){
        super(name,interests);
        this._tasks = [];
        this._welcomeText = 'Welcom to the team!';
    }
    greeting(){
        console.log('I\'m '+this.name+'. '+this._welcomeText);
    }
    work(){
        console.log('I\'m working on '+this._tasks.length + ' tasks.');
    }
    set tasks(tasks){
        let acceptedTasks = [];
        if(tasks.length > TeamMember.maxTasksCapacity()){
            acceptedTasks = tasks.slice(0, TeamMember.maxTasksCapacity());
            console.log('It\'s over max capacity. Can only take two');
        }else{
            acceptedTasks = tasks;
        }
        this._tasks = this._tasks.concat(acceptedTasks);
    }
    static maxTasksCapacity(){
        return 2;
    }
}

let member = new TeamMember('Sunny',['Traveling']);
member.greeting();
member.tasks = ['Buy three tickets','Book a hotel','Rent a car'];
member.work();

console.log(member.interestsCount); // User 클래스에 있는 기능이 동작함
member.interestsCount = 2;
console.log(member.interestsCount); // set이 없어서 변경안됨
console.log(member.tasks);          // get 이 없음


User.prototype.eat = function(){
    console.log('What will I have for lunch?');
};
member.eat();


User.sleep = function () {
    console.log('Go to Sleep');
};

// member.sleep(); // Error
User.sleep();

console.log(User.prototype.hasOwnProperty('eat'));
console.log(User.hasOwnProperty('eat'));

console.log('')

console.log(User.prototype.hasOwnProperty('sleep'));
console.log(User.hasOwnProperty('sleep'));