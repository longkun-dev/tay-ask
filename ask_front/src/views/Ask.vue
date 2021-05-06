<template>
    <div>
        <router-view></router-view>
        <div class="pane">
            <nav-header></nav-header>
            <el-row>
                <el-col :span="24">
                    <span class="question-title">Ask a public question</span>
                    <img class="img" src='../assets/images/background.svg'>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="16">
                    <el-form style="width: 90%" ref="form" :model="form" label-position="top" label-width="80px">
                        <el-form-item label="Title">
                            <span>Be specific and imagine you’re asking a question to another person</span>
                            <el-input type="textarea" v-model="form.questionTitle" maxlength="120"
                                :autosize="{ minRows: 1, maxRows: 10}"></el-input>
                        </el-form-item>
                        <el-form-item label="Body">
                            <span>Include all the information someone would need to answer your question</span>
                            <el-input type="textarea" v-model="form.questionContent" maxlength="600"
                                :autosize="{ minRows: 3, maxRows: 10}"></el-input>
                        </el-form-item>
                        <el-form-item label="Tags">
                            <span>Add up to 5 tags to describe what your question is about</span><br/>
                            <el-tag :key="tag" v-for="tag in form.tags" closable :disable-transitions="false"
                                @close="handleClose(tag)">{{tag}}</el-tag>
                            <el-input class="input-new-tag" v-if="inputVisible" v-model="inputValue"
                                ref="saveTagInput" @keyup.enter.native="handleInputConfirm"
                                @blur="handleInputConfirm"></el-input>
                            <el-button v-else class="button-new-tag" size="medium" @click="showInput">
                                + New Tag</el-button>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">Post your question</el-button>
                        </el-form-item>
                    </el-form>
                </el-col>
                <el-col :span="8" v-if="showStep1">
                    <el-row>
                        <span>Step 1: Draft your question</span>
                    </el-row>
                    <el-row>
                        <span>The community is here to help you with specific coding, algorithm, or language problems.</span>
                        <span>Avoid asking opinion-based questions.</span>
                    </el-row>
                    <el-collapse v-model="activeName" accordion>
                        <el-collapse-item title="1. Summarize the problem" name="1">
                            <div>· Include details about your goal</div>
                            <div>· Describe expected and actual results</div>
                            <div>· Include any error messages</div>
                        </el-collapse-item>
                        <el-collapse-item title="2. Describe what you have tried" name="2">
                            <div>Show what you’ve tried and tell us what you found (on this site
                                 or elsewhere) and why it didn’t meet your needs. You can get 
                                 better answers when you provide research.</div>
                        </el-collapse-item>
                        <el-collapse-item title="3. Show some code" name="3">
                            <div>When appropriate, share the minimum amount of code others 
                                need to reproduce your problem (also called a minimum, 
                                reproducible example)</div>
                        </el-collapse-item> 
                    </el-collapse>
                </el-col>
                <el-col :span="8" v-if="showStep2">
                    <el-row>
                        <span>Step 2: Review your question</span>
                    </el-row>
                    <el-row>
                        <span>The community is here to help you with specific coding, algorithm, or language problems.</span>
                        <span>Avoid asking opinion-based questions.</span>
                    </el-row>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
import NavHeader from '../components/NavHeader.vue'

export default {
    data() {
        return {
            form: {
                tags: [],
                questionTitle: '',
                questionContent: ''
            },
            activeName: '1',
            showStep1: true,
            showStep2: false,
            inputVisible: false,
            inputValue: '',
            bg: {
                backgroundImage: 'url(' + require('../assets/images/background.svg') + ')',
                backgroundRepeat: "no-repeat",
                backgroundSize: "100% 100%",
            },
        }
    },
    components: {
        'nav-header': NavHeader
    },
    methods: {
        onSubmit() {
            // 表单校验
            if (!this.check()) {
                return
            }

            // TODO 要把 [问题标题] 字段改为 NOT NULL
            this.showStep1 = false
            this.showStep2 = true
            let param = {
                'questionTitle': this.form.questionTitle,
                'questionContent': this.form.questionContent,
                'tags': this.form.tags.join(';')
            }
            console.log("param: ", param)
            this.openMessageWarning('暂未开发')
        },
        check() {
            if (this.form.questionTitle === '') {
                this.openMessageWarning('问题标题不能为空')
                return false
            }
            
            if (this.form.questionContent === '') {
                this.openMessageWarning('问题内容不能为空')
                return false
            }

            return true
        },
        handleClose(tag) {
            this.form.tags.splice(this.form.tags.indexOf(tag), 1)
        },
        showInput() {
            this.inputVisible = true
            this.$nextTick(_ => {
                this.$refs.saveTagInput.$refs.input.focus()
            })
        },
        handleInputConfirm() {
            let inputValue = this.inputValue
            if (inputValue) {
                this.form.tags.push(inputValue)
            }
            this.inputVisible = false
            this.inputValue = ''
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
.el-row {
    margin-top: 15px;
    margin-bottom: 15px;
}

.question-title {
    font-size: 20px;
    font-weight: bold;
    height: 130px;
    width: 100%;
    vertical-align: middle;
}

.img {
    vertical-align: middle;
    height: 120px;
    margin-left: 30%;
}

.pane {
    /* padding: 10px 25px 0 25px; */
    width: 70%;
    height: 100%;
    margin-left: 15%;
}

.el-tag + .el-tag {
    margin-left: 10px;
}

.button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
}

.input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
}
</style>