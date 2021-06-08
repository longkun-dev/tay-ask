<template>
    <div class="pane">
        <router-view></router-view>
        <el-row>
            <header1></header1>
            <el-col :span="4">
                <side-bar style="margin-top: 15px"></side-bar>
            </el-col>
            <el-col :span="20">
                <div class="main">
                    <div class="item">
                        <h2>Users</h2>
                    </div>
                    <div>
                        <el-input v-model="searchUser" maxlength="50" placeholder="Filter by user"
                            style="width: 300px">
                            <i slot="prefix" class="el-input__icon el-icon-search"></i>
                        </el-input>
                    </div>
                    <div class="card-display">
                        <user-item v-for="user in users"
                            :key="user.userId"
                            :userId="user.userId"
                            :username="user.username"
                            :location="user.location"
                            :headImg="user.headImg"
                            :reputation="user.reputation"
                            :tags="user.tags"></user-item>
                    </div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import SideBar from '../components/SideBar.vue'
import Header from '../components/Header.vue'
import UserItem from '../components/UserItem.vue'

export default {
    data() {
        return {
            searchUser: '',
            users: [{
                'userId': '1001',
                'username': 'Gordon Linoff',
                'location': 'New York, United States',
                'reputation': '2185',
                'headImg': 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                'tags': ['sql', 'mysql', 'sql-server']
            }, {
                'userId': '1002',
                'username': 'akrun',
                'location': 'New York, United States',
                'reputation': '1960',
                'headImg': 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                'tags': ['sql', 'mysql', 'sql-server']
            }, {
                'userId': '1003',
                'username': 'Kuala Lumpur',
                'location': 'Territory of Kuala Lumpur, Malaysia',
                'reputation': '1947',
                'headImg': 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                'tags': ['r', 'dplyr', 'tidyverse']
            }, {
                'userId': '1009',
                'username': 'Gordon Linoff',
                'location': 'New York, United States',
                'reputation': '2185',
                'headImg': 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                'tags': ['sql', 'mysql', 'sql-server']
            }, {
                'userId': '1004',
                'username': 'akrun',
                'location': 'New York, United States',
                'reputation': '1960',
                'headImg': 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                'tags': ['sql', 'mysql', 'sql-server']
            }, {
                'userId': '1005',
                'username': 'Kuala Lumpur',
                'location': 'Territory of Kuala Lumpur, Malaysia',
                'reputation': '1947',
                'headImg': 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                'tags': ['r', 'dplyr', 'tidyverse']
            }, {
                'userId': '1006',
                'username': 'Gordon Linoff',
                'location': 'New York, United States',
                'reputation': '2185',
                'headImg': 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                'tags': ['sql', 'mysql', 'sql-server']
            }, {
                'userId': '1007',
                'username': 'akrun',
                'location': 'New York, United States',
                'reputation': '1960',
                'headImg': 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                'tags': ['sql', 'mysql', 'sql-server']
            }, {
                'userId': '1008',
                'username': 'Kuala Lumpur',
                'location': 'Territory of Kuala Lumpur, Malaysia',
                'reputation': '1947',
                'headImg': 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
                'tags': ['r', 'dplyr', 'tidyverse']
            }]
        }
    },
    components: {
        'side-bar': SideBar,
        'header1': Header,
        'user-item': UserItem
    },
    methods: {
        showAllTags() {
            this.openMessageWarning('暂未开发..')
        },
        openMessage(msg) {
            this.$message({
                message: msg,
                duration: 3000
            })
        },
        openMessageSuccess(msg) {
            this.$message({
                message: msg,
                type: 'success',
                duration: 3000
            })
        },
        openMessageError(msg) {
            this.$message({
                message: msg,
                type: 'error',
                duration: 3000
            })
        },
        openMessageWarning(msg) {
            this.$message({
                message: msg,
                type: 'warning',
                duration: 3000
            })
        }
    }
}
</script>

<style scoped>
.pane {
    /* padding: 10px 25px 0 25px; */
    width: 70%;
    height: 100%;
    margin-left: 15%;
}

.main {
    padding: 5px 25px;
}

.item {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    flex-wrap: nowrap;
}

.tag-desc {
    font-size: 15px;
    font-weight: bold;
    width: 80%;
}

.card-display {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: flex-start;
    align-items: center;
}

.show-all-tags {
    font-size: 13px;
    padding: 15px 0 15px 0;
}
</style>