<template>
    <div class="layout1">
        <div class="layout-stat">
            <div>{{ votes }}</div>
            <span>votes</span>
            <div>{{ answers }}</div>
            <span>answers</span>
            <div>{{ views }}</div>
            <span>views</span>
        </div>
        <div class="layout-stat question">
            <div>
                <el-link type="primary" :underline="false" :href="'https://baidu.com?questionNo=' + questionNo">
                    {{ questionTitle }}
                </el-link>
            </div>
            <div style="margin-top: 8px">
                <span>{{ questionContent }}</span>
            </div>
            <div style="margin-top: 8px;">
                <el-tag v-for="tag in tags" :key="tag">{{ tag }}</el-tag>
                <span style="margin-left: 30px">asked by {{ askedBy }} at {{ publishTime }}</span>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data: function() {
        return  {
        }
    },
    props: ['questionNo', 'questionTitle', 'questionContent', 'votes',
            'answers', 'views', 'tags', 'publishTime', 'askedBy', 'createdBy']
}
</script>
<style scoped>
.layout1 {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    /* align-items:; */
    width: 100%;
    height: 125px;
    border-bottom:2px solid #eee;
    padding: 10px;
}

.layout-stat {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    /* font-size: 20px; */
}

.layout-stat span {
    padding-bottom: 8px;
    font-size: 14px;
}

.question {
    font-size: 18px;
    padding-left: 20px;
    align-items: flex-start;
}

.el-link {
    font-size: 18px;
}

.el-tag {
    margin-top: 5px;
    margin-right: 10px;
    height: 30px;
}
</style>