<template>
    <div class="header1">
        <div class="header">
            <div>
                <el-image class="image" :src="image" fit="fill"></el-image>
            </div>
            <div>
                <span class="header-item">Products</span>
            </div>
            <div>
                <el-input maxlength="100" v-model="searchContent"
                    size="medium" placeholder="Search..."></el-input>
            </div>
        </div>
        <div>
            <el-avatar class="avatar" shape="square" :src="avatar" fit="fill"></el-avatar>
        </div>
    </div>
</template>
<script>
import logo from '@/assets/images/stack-overflow.png'

export default {
    data: function() {
        return {
            image: logo,
            searchContent: '',
            avatar: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
        }
    }
}
</script>
<style scoped>
.image {
    /* padding-left: 10px; */
    width: 200px;
    height: 75px;
}

.header {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: space-between;
    align-items: center;
}

.header-item {
    font-size: 20px;
    padding: 20px 20px;
    /* font-weight: bold; */
}

.header1 {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: space-between;
    align-items: center;
    padding: 5px 20px;
}

.el-input {
    min-width: 350px;
}
</style>