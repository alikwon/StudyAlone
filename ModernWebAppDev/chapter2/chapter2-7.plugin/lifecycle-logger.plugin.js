/*
    ● 플러그인
     - Vue 프레임워크에 확장성을 제공하는 좋은 방법
     - Vue 에서 가장 많이 활용되는 Vuex, Vue Router가  "플러그인"
     - 만드는법 : install([Vue생성자], [플러그인을 구성하는데 사용할 options]) 를 가지는 일반 객체 생성
     - 믹스인 사용시 모듈을 가져와야하고, 비활성화하려면 여러파일을 변경해야함 --> 이상적이지 않음
     - Vue app에서 사용시 플러그인을 모듈로 가져와서 Vue.use()호출
*/

const switchers = {
    created: true,
    beforeMount: true,
    mounted: true,
    destroyed: true,
};

export default {
    install(Vue, options) {
        Object.assign(switchers, options);
        Vue.mixin({
            created() {
                if (switchers.created) {
                    console.log(`${this.$options.name} created`);
                }
            },
            beforeMount() {
                if (switchers.beforeMount) {
                    console.log(`${this.$options.name} about to mount`);
                }
            },
            mounted() {
                if (switchers.mounted) {
                    console.log(`${this.$options.name} mounted`);
                }
            },
            destroyed() {
                if (switchers.destroyed) {
                    console.log(`${this.$options.name} destroyed`);
                }
            },
        });
    },
};
