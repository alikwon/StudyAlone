function User(name) {
    console.log('I\'m "' + this.constructor.name + '" context');
    this.name = name;
    this.speak = function () {
        console.log('"'+this.name + '" is speaking from "' + this.constructor.name + '"context.' );
        var drink = function(){
            console.log('Drinking in "'+this.constructor.name +'"  context');
        }
        drink();
    };
    
    function ask() {
        console.log('Asking from "'+this.constructor.name +'"  context');
        console.log('Who am I? "'+this.name + '"');
    }
    ask();
}

var name = 'Unknown';
var user = new User('Ted');
user.speak();