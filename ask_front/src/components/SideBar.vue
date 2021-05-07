<template>
    <div>
        <el-menu default-active='1' class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
            <el-menu-item index="1">
                <span slot="title">Home</span>
            </el-menu-item>
            <el-menu-item index="2">
                <span slot="title">Questions</span>
            </el-menu-item>
            <el-menu-item index="3">
                <span slot="title">Tags</span>
            </el-menu-item>
            <el-menu-item index="4">
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
        }
    }
};
</script>