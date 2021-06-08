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
                        <h2>Tags</h2>
                    </div>
                    <div class="tag-desc">A tag is a keyword or label that categorizes your question
                        with other, similar questions. Using the right tags makes it easier for others to
                        find and answer your question.</div>
                    <div class="show-all-tags">
                        <el-link type="primary" :underline="false" @click="showAllTags">Show all tag synonyms</el-link>
                    </div>
                    <div>
                        <el-input v-model="searchTag" maxlength="50" placeholder="Filter by tag name"
                            style="width: 300px">
                            <i slot="prefix" class="el-input__icon el-icon-search"></i>
                        </el-input>
                    </div>
                    <div class="card-display">
                        <tag-item v-for="tag in tags" :key="tag.tagName"
                            :tagName="tag.tagName"
                            :tagDesc="tag.tagDesc"
                            :questionCount="tag.questionCount"
                            :questionCountToday="tag.questionCountToday"
                            :questionCountThisWeek="tag.questionCountThisWeek"></tag-item>
                    </div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import SideBar from '../components/SideBar.vue'
import Header from '../components/Header.vue'
import TagItem from '../components/TagItem.vue'

export default {
    data() {
        return {
            searchTag: '',
            tags: [{
                tagName: 'JavaScript1',
                tagDesc: 'For questions regarding programming in ECMAScript (JavaScript/JS) and its various dialects/implementations (excluding ActionScript). Please include...',
                questionCount: 2211717,
                questionCountToday: 546,
                questionCountThisWeek: 2902
            }, {
                tagName: 'JavaScript2',
                tagDesc: 'For questions regarding programming in ECMAScript (JavaScript/JS) and its various dialects/implementations (excluding ActionScript). Please include...',
                questionCount: 2211717,
                questionCountToday: 546,
                questionCountThisWeek: 2902
            }, {
                tagName: 'JavaScript3',
                tagDesc: 'For questions regarding programming in ECMAScript (JavaScript/JS) and its various dialects/implementations (excluding ActionScript). Please include...',
                questionCount: 2211717,
                questionCountToday: 546,
                questionCountThisWeek: 2902
            }, {
                tagName: 'JavaScript4',
                tagDesc: 'For questions regarding programming in ECMAScript (JavaScript/JS) and its various dialects/implementations (excluding ActionScript). Please include...',
                questionCount: 2211717,
                questionCountToday: 546,
                questionCountThisWeek: 2902
            }, {
                tagName: 'JavaScript5',
                tagDesc: 'For questions regarding programming in ECMAScript (JavaScript/JS) and its various dialects/implementations (excluding ActionScript). Please include...',
                questionCount: 2211717,
                questionCountToday: 546,
                questionCountThisWeek: 2902
            }, {
                tagName: 'JavaScript6',
                tagDesc: 'For questions regarding programming in ECMAScript (JavaScript/JS) and its various dialects/implementations (excluding ActionScript). Please include...',
                questionCount: 2211717,
                questionCountToday: 546,
                questionCountThisWeek: 2902
            }]
        }
    },
    components: {
        'side-bar': SideBar,
        'header1': Header,
        'tag-item': TagItem
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