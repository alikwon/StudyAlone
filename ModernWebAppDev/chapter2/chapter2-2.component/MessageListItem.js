// import lifecycleLogger from '/chapter2/chapter2-6.mixins/lifecycle-logger.mixin.js'; // 믹스인
export default{
    name: 'MessageListItem',    // 필수는 아니지만 디버깅에 도움이 되기에 추가하는 것이 좋음
    template: `
    <li>
        {{item.text}} - {{item.createdAt | datetime}}
        <button @click="deleteClick">X</button>
    </li>`,
    props: {
        item:{
            type: Object,
            required: true,
        },
        items:{
            type: Array,
            required: false,
        }
    },
    methods: {
        deleteClick(){
            this.$emit('delete');
        }
    },
}