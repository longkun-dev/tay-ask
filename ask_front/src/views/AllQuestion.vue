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
                        <h2>All Questions</h2>
                        <el-button type="primary" @click="askQuestion">Ask Question</el-button>
                    </div>
                    <div class="question-number">{{ count }} questions</div>
                    <div v-if="questionList.length > 0">
                        <question-item style="padding-left: 0px" v-for="question in questionList"
                        :key="question.questionNo"
                        :votes="question.votes" :answers="question.answers"
                        :views="question.views" :question-no="question.questionNo"
                        :question-title="question.questionTitle"
                        :questionContent="question.questionContent"
                        :publish-time="question.publishTime"
                        :tags="question.tags" :asked-by="question.askedBy"
                        :created-by="question.createdBy"></question-item>
                    </div>
                    <div v-else style="margin-top: 20px">
                        <span>没有相关数据</span>
                    </div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import SideBar from '../components/SideBar.vue'
import QuestionItem from '../components/AllQuestionItem.vue'
import Header from '../components/Header.vue'

export default {
    data() {
        return {
            questionList: [],
            count: 0,
            questionCount: 20
        }
    },
    components: {
        'side-bar': SideBar,
        'question-item': QuestionItem,
        'header1': Header
    },
    created() {
        this.queryData(this.questionCount)
        this.queryQuestionCount()
    },
    methods: {
        queryData(count) {
            if (Number.isNaN(count)) {
                count = this.questionCount
            }
            let params = {
                'questionCount': count
            }
            this.axios.get('question/list/top', { params }).then((res) => {
                if (res.status === 200) {
                    let list = res.data.data
                    list.forEach(element => {
                        let tagStr = element.tags
                        if (this.isNotEmpty(tagStr)) {
                            element.tags = tagStr.split(';')
                        } else {
                            element.tags = []
                        }
                    })
                    this.questionList = list
                } else {
                    this.openMessageError('请求错误')
                }
            })
        },
        queryQuestionCount() {
            this.axios('question/count').then((res) => {
                if (res.status === 200) {
                    this.count = res.data.data
                } else {
                    this.openMessageError('请求错误')
                }
            })
        },
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