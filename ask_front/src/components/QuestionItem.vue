<template>
    <div class="main">
        <div class="stat">
            <div>{{ votes }}</div>
            <span>votes</span>
        </div>
        <div class="stat">
            <div>{{ answers }}</div>
            <span>answers</span>
        </div>
        <div class="stat">
            <div>{{ views }}</div>
            <span>views</span>
        </div>
        <div class="stat">
            <div class="question">
                <div>
                    <el-link class="link" type="primary" :href="'https://baidu.com?questionNo=' + questionNo"
                        :underline="false">{{ questionTitle }}</el-link>
                </div>
                <div class="remark">
                    <div>
                        <el-tag :key="tag" v-for="tag in tags" :disable-transitions="false"
                            @close="handleClose(tag)">{{ tag }}</el-tag>
                    </div>
                    <div style="margin-left: 30px">
                        <span>asked by 
                            <el-link type="primary" :href="'https://baidu.com?username=' + askedBy">{{ askedBy }}</el-link>
                             at {{ publishTime }}</span>
                    </div>
                </div>
            </div>
        </div>
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
    padding: 10px 0px;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    border-bottom: 2px solid #eee;
    /* border-top: 2px solid #eee; */
}

.stat {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    font-size: 21px;
    margin-right: 15px;
}

.stat span {
    font-size: 14px;
}

.el-tag {
    margin-right: 10px;
    margin-top: 5px;
    padding: 0px 6px;
    height: 30px;
}

.question {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    flex-wrap: wrap;
    padding: 8px 8px;
}

.remark {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    flex-wrap: nowrap;
}

.link {
    font-size: 18px;
}
</style>
