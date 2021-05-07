<template>
    <div class="main">
        <div class="stat">{{ votes }} votes</div>
        <div class="stat">{{ answers }} answers</div>
        <div class="stat">{{ views }} views</div>
        <div>{{ questionTitle }}</div>
        <div>
            <el-tag :key="tag" v-for="tag in tags" :disable-transitions="false"
                @close="handleClose(tag)">{{ tag }}</el-tag>
        </div>
        <div>asked at {{ publishTime }} by {{ askedBy }}</div>
    </div>
</template>
<script>
export default ({
    data: function() {
        return {
        }
    },
    props: ['votes', 'answers', 'views', 'question-no', 'question-title', 'publish-time',
            'tags', 'asked-by', 'created-by'],
    methods: {
        handleClose(tag) {
            console.log('未实现')
        }
    }
})
</script>
<style scoped>
.main {
    width: 100%;
    min-height: 45px;
    padding: 10px 10px;
    display: flex;
    flex-direction: column;
    background-color: #edecec4c;
}

.stat {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
}

.el-tag {
    margin-right: 10px;
}
</style>
