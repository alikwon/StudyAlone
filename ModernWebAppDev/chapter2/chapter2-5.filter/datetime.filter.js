/* ● Vue 의 필터
    - 필터를 이용해 이중 중괄호 보간법 혹은 v-bind 표현법을 이용할 때 텍스트 형식을 지정
    - 표현식의 값을 첫 번째 인자로 가지는 자바스크립트 함수
    - Vue.filter() 로 전역으로 등록하거나 
    - options 객체의 filters 프로퍼티를 로컬로 등록할 수 있다.
    - filter는 "|"로 분리한 형태로 추가한다
        ex) {{item.dateTime | filterA | filterB }} --> filterA의 결과가 filterB에 전달됨
        ex) {{item.dateTime | filterA('MM/DD/YYYY') }} --> filterA의 두번째 인자로 'MM/DD/YYYY' 문자열을 보냄
*/


const formatter = 
    new Intl.DateTimeFormat('default',{ 
            timeZone: 'Asia/Seoul', 
            timeZoneName: 'long',
            year:'numeric', month: 'long', week: 'long', day: 'numeric',
            hour: 'numeric', minute: 'numeric', second: 'numeric' 
        });

Vue.filter('datetime',function(value){
    if(!value) return '';
    return formatter.format(value);
});