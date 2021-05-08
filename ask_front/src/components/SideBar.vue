<template>
    <div>
        <el-menu default-active='Home' class="el-menu-vertical-demo" @open="handleOpen"
                @close="handleClose" @select="select">
            <el-menu-item index="Home">
                <span slot="title">Home</span>
            </el-menu-item>
            <el-menu-item index="Questions">
                <span slot="title">Questions</span>
            </el-menu-item>
            <el-menu-item index="Tags">
                <span slot="title">Tags</span>
            </el-menu-item>
            <el-menu-item index="Users">
                <span slot="title">Users</span>
            </el-menu-item>
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
            console.log(key, keyPath)
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath)
        },
        select(index, indexPath) {
            switch(index) {
                case 'Home':
                    this.$router.push({path: '/', query: {}})
                    break
                case 'Questions':
                    this.$router.push({path: '/allQuestions', query: {}})
                    break
            }
            console.log("index: ", index, "  indexPath: ", indexPath)
        }
    }
};
</script>
<style scoped>
span {
    font-size: 16px;
    font-family: Arial, Helvetica, sans-serif;
    /* font-weight: bold; */
}
</style>