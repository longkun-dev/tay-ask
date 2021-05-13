<template>
    <el-card class="box-card" shadow="never">
        <div class="layout1">
            <div style="display: block">
                <el-image style="width: 75px; height: 75px; padding-top: 10px"
                 :src="headImg" fit="fill"></el-image>
            </div>
            <div class="layout2" style="padding-left: 15px">
                <span>{{ username }}</span>
                <span style="font-size: 13px; color: rgb(0, 0, 0, 0.6)">
                    {{ location }}</span>
                <span>{{ reputation }}</span>
                <span>
                    <el-link type="primary" v-for="tag in tags" :key="tag"
                        :href="'https://bing.com/search?q=' + tag"
                        target="_blank"
                        style="padding-right: 5px">{{ tag }}</el-link>
                </span>
            </div>
        </div>
    </el-card>
</template>
<script>
export default {
    data: function() {
        return {}
    },
    props: ['userId', 'headImg', 'username', 'location', 'reputation', 'tags']
}
</script>
<style scoped>
.layout1 {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: flex-start;
    flex-wrap: nowrap;
}

.layout2 {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    /* align-items: center; */
    flex-wrap: wrap;
}

.box-card {
    width: 250px;
    height: 150px;
    margin: 10px 10px 0px 0px;
}

.el-card /deep/ .el-card__body {
    padding: 10px;
}

.layout2 span {
    padding-top: 8px;
}

</style>
