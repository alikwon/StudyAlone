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
//------------------------------------------------------------------------

const advice = 'Stay hungry. Stay foolish.';

let advisor = {
    __proto__ : new TeamMember('Adam',['Consulting']),  //프로토타입 설정
    advice,                                             //프로퍼티 축약 표현
    greeting(){                                         //메소드 축약 표현
        super.greeting();                               //super 메소드 호출
        console.log(this.advice);
    },
    [advice.split('.')[0]]: 'Always learn more'         //계산된 프로퍼티 이름
}

console.log(TeamMember.prototype.isPrototypeOf(advisor));
console.log(advisor instanceof TeamMember);

advisor.greeting();
console.log(advisor['Stay hungry']);