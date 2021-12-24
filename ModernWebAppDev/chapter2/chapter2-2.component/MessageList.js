import MessageListItem from "./MessageListItem.js";
export default{
    name: 'MessageList',    // 필수는 아니지만 디버깅에 도움이 되기에 추가하는 것이 좋음
    template: `
    <ul>
        <message-list-item :key="item.id" v-for="item in items" :item="item" @delete="deleteMessage(item)"/>
    </ul>`,
    components: {
        MessageListItem,
    },
    props: {
        items:{
            type: Array,
            required: true,
        }
    },
    methods: {
        deleteMessage(message){
            this.$emit('delete',message);
        }
    },
}