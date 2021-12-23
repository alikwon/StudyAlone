let user = {
    name : 'Ted',
    greeting(){
        console.log(`Hello I'm ${this.name}`);
    }
}
user.greeting();


let greeting1 = `Hello, I'm ${user.name}.
Welcome to the team!`
console.log(greeting1);


let greeting2 = `Hello, I'm ${user.name}.
                Welcome to the team!`
console.log(greeting2);