<template>
    <div>
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal"
            @select="handleSelect">
            <el-menu-item index="1">
                <i class="fa fa-stack-overflow" aria-hidden="true" style="color: red; margin-right: 10px"></i>
                <span slot="title">Stack overflow</span>
            </el-menu-item>
            <el-menu-item index="2">Products</el-menu-item>
            <el-menu-item index="3">
                <el-input v-model="searchContent" prefix-icon="el-icon-search" placeholder="Search..."
                    maxlength="700" style="width: 980px"></el-input>
            </el-menu-item>
            <el-submenu index="4">
                <template slot="title">
                    <div class="block"><el-avatar shape="square" :size="40" :src="squareUrl"></el-avatar></div>
                </template>
                <el-menu-item index="4-1">Information</el-menu-item>
                <el-menu-item index="4-2">Logout</el-menu-item>
            </el-submenu>
        </el-menu>
        <div class="line"></div>
    </div>
</template>
<script>
import 'font-awesome/css/font-awesome.min.css'

export default {
    data: function() {
        return {
            activeIndex: '1',
            searchContent: '',
            squareUrl: 'https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png'
        }
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        }
    }
};
</script>
<style scoped>
.el-menu-item {
    font-weight: bold;
    font-size: medium;
    font-family: Arial, Helvetica, sans-serif;
    padding-left: 0;
    border-bottom: none;
}

.el-menu--horizontal > .el-menu-item.is-active {
    border-bottom: none;
}
</style>