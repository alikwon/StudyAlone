/* 
● 비구조화 할당 

 
1. 객체 비구조화     */
{
    let user = { name: "Sunny", interests: ["Traveling", "Swimming"] };

    // 비구조화 할당 --> 일치하지 않는 프로퍼티(tasks)는 기본값 설정
    let { name, interests, tasks = [] } = user;

    console.log(name);
    console.log(interests);
    console.log(tasks);

    // user의 name 프로퍼티값을 선택하고 firstName 변수에 할당
    let { name: firstName } = user;

    console.log(firstName);
}

/* ========================================================

2. 배열 비구조화    */
{
    let [first, second] = ["Traveling", "Swimming", "Shopping"];
    console.log(first);
    console.log(second);

    // 배열 뒷부분 요소만 필요한 경우 ( + 기본값 설정)
    let [, , third, fourth = ""] = ["Traveling", "Swimming", "Shopping"];
    console.log(third);
    console.log(fourth);
}

/* ========================================================

3. 중첩 비구조화    */
{
    let user = { name: "Sunny", interests: ["Traveling", "Swimming"] };
    let {
        interests: [, second],
    } = user;

    console.log(second);
    // console.log(interests);  // ReferenceError

    const fruits = [
        { name: "apple", price: 100 },
        { name: "orange", price: 80 },
    ];
    let [, { name: secondFruitName }] = fruits;
    console.log(secondFruitName);
}

/* ========================================================

3. 나머지 요소   */
{
    let [first, ...others] = ["Traveling", "Swimming", "Shopping"];
    console.log(others);

    const fruits = [
        { name: "apple", price: 100 },
        { name: "orange", price: 80 },
    ];

    let [...myFruits] = fruits;
    console.log(myFruits[0].name);

    // 배열 복사시 "얇은 복제"
    //값 추가시 원본배열에 영향을 주지않음
    myFruits.push({ name: "banana", price: 90 });
    console.log(myFruits.length);
    console.log(fruits.length);

    //값 변경시 원본 배열 값도 변경됨
    myFruits[0].price = 110;
    console.log(fruits[0].price);
}

/* ========================================================

3. 함수 매개변수 비구조화   */
{
    function workout({ gym }, times) {
        console.log("Working in " + gym + " for " + times + " times");
    }
    let thisWeek = { gym: "Gym A" };
    workout(thisWeek, 2);
}

{
    function workout({ gym, todos }) {
        let [first] = todos;
        console.log("Start " + first + " in " + gym);
    }
    let today = { gym: "Gym A", todos: ["Treadmill", "Pushup"] };
    workout(today);
    // workout({gym: 'Gym B'}); // Uncaught TypeError: todos is not iterable
}

{
    function workout({ gym, todos = ["Treadmill"] }) {
        let [first] = todos;
        console.log("Start " + first + " in " + gym);
    }
    let today = { gym: "Gym A" };
    workout(today);
    // workout(); // Uncaught TypeError: Cannot destructure property 'gym' of 'undefined' as it is undefined.
}
{
    function workout({ gym = "", todos = ["Treadmill"] } = {}) {
        let [first] = todos;
        console.log("Start " + first + " in " + gym);
    }
    workout();
}
