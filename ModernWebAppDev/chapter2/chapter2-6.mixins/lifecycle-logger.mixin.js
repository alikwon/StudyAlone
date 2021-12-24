/*
    ● 믹스인
    
     - 컴포넌트 외에 코드를 재사용할 수 있는 또 다른 방법
     - Vue 컴포넌트의 option객체에 믹스인을 혼합한다.
     - 전역으로 적용시 주의필요
*/

export default{
    created(){
        console.log(`${this.$options.name} created`);
    },
    beforeMount() {
        console.log(`${this.$options.name} about to mount`);
    },
    mounted() {
        console.log(`${this.$options.name} mounted`);
    },
    destroyed() {
        console.log(`${this.$options.name} destroyed`);
    },
}