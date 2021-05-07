<template>
    <div class="pane">
        <router-view></router-view>
        <el-row>
            <nav-header></nav-header>
            <el-col :span="4">
                <side-bar style="margin-top: 35px"></side-bar>
            </el-col>
            <el-col :span="20">
                <div class="main">
                    <h2>Top Questions</h2>
                    <question-item v-for="question in questions" :key="question.questionNo"
                        :votes="question.votes" :answers="question.answers"
                        :views="question.views" :question-no="question.questionNo"
                        :question-title="question.questionTitle" :publish-time="question.publishTime"
                        :tags="question.tags" :asked-by="question.askedBy"
                        :created-by="question.createdBy"></question-item>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import SideBar from '../components/SideBar.vue'
import NavHeader from '../components/NavHeader.vue'
import QuestionItem from '../components/QuestionItem.vue'

export default {
    data() {
        return {
            questions: [{
                questionNo: '1001',
                publishTime: '2021-05-06 21:22',
                votes: 1,
                answers: 2,
                views: 3,
                questionTitle: 'Test Title',
                questionContent: 'Test Content',
                tags: ["python", "pandas", "matplotlib", "seaborn"],
                askedBy: 'Zenkage',
                createdBy: 'Zenkage'
            }]
        }
    },
    components: {
        'side-bar': SideBar,
        'nav-header': NavHeader,
        'question-item': QuestionItem,
        QuestionItem
    },
    methods: {
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
    padding: 30px 30px;
}
</style>