/*
    let : 변수 정의
    const : 상수 정의

    - 블록레벨의 스코프를 가짐
    - 호이스팅 적용안됨
*/

function workout() {
    let gym = 'Gym A';

    const gymStatuses = {'Gym A':'open', 'Gym B':'open', 'Gym C':'closed'};

    for (let gym in gymStatuses) {
        console.log(gym + ' is ' + gymStatuses[gym]);
    }

    {
        const gym = 'Gym B';
        console.log('Workout in ' + gym);
        
        // gym = 'Gym C'; //Error
    }

    console.log('Workout in ' + gym);

    {
        function gym(){
            console.log('Workout in a separate gym');
        }
        gym();
    }

    if(gymStatuses[gym] === 'open'){
        let exercises = ['Treadmill','Pushup','Spinning'];
    }
    // console.log(exercises);

    try {
        let gym = 'Gym C';
        console.log('Workout in ' +gym);
        throw new Error('Gym is closed');
    } catch (err) {
        console.log(err);
        let gym = 'Gym D';
        console.log('Working in '+gym);
    }
}
workout();
