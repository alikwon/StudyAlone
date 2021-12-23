import User from "./user.js";
import * as Roles from './role.js';
import completeTask from "./task.js";
import { completedCount } from "./task.js";
// import completeTask, {completedCount} from './task.js';

let user = new User('Ted', Roles.USER);
completeTask(user);

console.log(`Total completed ${completedCount}`);

// 가져온 객체를 변경할 수 있다는 것만 보여준다. 하지만 좋은 사례는 아니다.
// completedCount++;

User.prototype.walk = function () {
    console.log(`${this.name} walks`);
};

user.walk();
