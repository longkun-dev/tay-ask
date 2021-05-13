<template>
    <div style="padding-left: 15px">
        <el-menu :default-active='$route.name' class="el-menu-vertical-demo"
                router
                @open="handleOpen" @close="handleClose">
            <el-menu-item index="/">Home</el-menu-item>
            <el-menu-item index="allQuestions">Questions</el-menu-item>
            <el-menu-item index="tags">Tags</el-menu-item>
            <el-menu-item index="users">Users</el-menu-item>
        </el-menu>
    </div>
</template>
<script>
export default {
    data: function() {
        return {
        }
    },
    methods: {
        handleOpen(key, keyPath) {
            // console.log(key, keyPath)
        },
        handleClose(key, keyPath) {
            // console.log(key, keyPath)
        }
    }
};
</script>
<style scoped>
.el-menu-item {
    font-size: 16px;
    font-family: Arial, Helvetica, sans-serif;
    /* font-weight: bold; */
}
</style>