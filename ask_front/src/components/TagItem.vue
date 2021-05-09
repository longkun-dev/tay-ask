<template>
    <el-card class="box-card" shadow="never">
        <div class="layout1">
            <div>
                <el-tag type="primary">{{ tagName }}</el-tag>
            </div>
            <div class="tag-desc">
                <span>{{ tagDesc }}</span>
            </div>
            <div class="layout2 stat">
                <div class="layout3">
                    <span>{{ questionCount }}</span>
                    <span>questions</span>
                </div>
                <div style="margin-left: 35px">
                    <span>{{ questionCountToday }} asked today,</span>
                    <span> {{ questionCountThisWeek }} this week</span>
                </div>
            </div>
        </div>
    </el-card>
</template>
<script>
export default {
    data: function() {
        return {}
    },
    props: ['tagName', 'tagDesc', 'questionCount', 'questionCountToday', 'questionCountThisWeek']
}
</script>
<style scoped>
.layout1 {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: flex-start;
}

.box-card {
    width: 245px;
    height: 180px;
    margin: 10px 10px 0px 0px;
}

.el-card /deep/ .el-card__body {
    padding: 10px;
}

.el-card:hover{
    /* margin-top: -1px; */
}

.tag-desc {
    padding-top: 10px;
    font-size: 14px;
}

.el-tag {
    height: 30px;
}

.layout2 {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
}

.layout3 {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
}

.stat {
    padding-top: 10px;
    font-size: 12px;
    color: gray;
}
</style>
