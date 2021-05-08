<template>
    <div class="pane">
        <router-view></router-view>
        <el-row>
            <!-- <nav-header></nav-header> -->
            <header1></header1>
            <el-col :span="4">
                <side-bar style="margin-top: 15px"></side-bar>
            </el-col>
            <el-col :span="20">
                <div class="main">
                    <div class="item">
                        <h2>Top Questions</h2>
                        <el-button type="primary" @click="askQuestion">Ask Question</el-button>
                    </div>
                    <div class="question-number">21,191,897 questions</div>
                    <question-item style="padding-left: 0px" v-for="question in questions" :key="question.questionNo"
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
import QuestionItem from '../components/QuestionItem.vue'
import Header from '../components/Header.vue'

export default {
    data() {
        return {
            questions: [{
                questionNo: '1001',
                publishTime: '2021-05-06 21:22',
                votes: 1,
                answers: 2,
                views: 3,
                questionTitle: 'How can I learn python fastly?',
                questionContent: 'Test Content',
                tags: ["python", "pandas", "matplotlib", "seaborn"],
                askedBy: 'Zenkage',
                createdBy: 'Zenkage'
            }, {
                questionNo: '1002',
                publishTime: '2021-05-06 21:22',
                votes: 1,
                answers: 2,
                views: 3,
                questionTitle: 'How can I learn python fastly?',
                questionContent: 'Test Content',
                tags: ["python", "pandas", "matplotlib", "seaborn"],
                askedBy: 'Zenkage',
                createdBy: 'Zenkage'
            }, {
                questionNo: '1003',
                publishTime: '2021-05-06 21:22',
                votes: 1,
                answers: 2,
                views: 3,
                questionTitle: 'How can I learn python fastly?',
                questionContent: 'Test Content',
                tags: ["python", "pandas", "matplotlib", "seaborn"],
                askedBy: 'Zenkage',
                createdBy: 'Zenkage'
            }, {
                questionNo: '1004',
                publishTime: '2021-05-06 21:22',
                votes: 1,
                answers: 2,
                views: 3,
                questionTitle: 'How can I learn python fastly?',
                questionContent: 'Test Content',
                tags: ["python", "pandas", "matplotlib", "seaborn"],
                askedBy: 'Zenkage',
                createdBy: 'Zenkage'
            }]
        }
    },
    components: {
        'side-bar': SideBar,
        'question-item': QuestionItem,
        'header1': Header
    },
    methods: {
        askQuestion() {
            this.$router.push({path: '/ask', query: {}})
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

.question-number {
    font-size: 17px;
    font-weight: bold;
}
</style>