// https://vuejs.org/v2/guide/custom-directive.html

// `v-focus`라는 전역 사용자 정의 지시자 등록하기
/*
<지시자 정의 객체 내에 추가할 훅 함수>
    ● bind : 지시자가 처음 요소에 바인딩 됐을 때 한번만 수행. 여기서 일회성 설정을 수행
    ● inserted : 바인딩 된 요소가 부모 노드에 삽입됐을 때 호출된다. 그러나 이 시점에서 부모노드는 DOM에 삽입되지 않았을 수 있다.
    ● update : 포함하는 컴포넌트의 VNode가 업데이트 됐을 때 호출. 하지만 자식 컴포넌트의 VNode가 업데이트되기 전에 호출될 수 있다.
    ● componentUpdated : 컴포넌트의 VNode와 자식 컴포넌트의 VNode가 업데이트된 후에 호출
    ● unbind : 요소에서 지시자의 바인딩이 해제될 때 한 번만 호출

*/
Vue.directive('focus', {
    //바인딩 된 요소가 DOM에 삽입될 때
    inserted: function(el){
        //요소에 초점을 준다
        el.focus();
    }
});