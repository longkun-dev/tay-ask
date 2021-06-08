<template>
  <div class="login">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="登录" name="1">
        <el-form :model="form" :rules="formRules" ref="form" label-width="100px" class="demo-ruleForm">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="form.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="pass">
            <el-input type="password" v-model="form.password" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submit('form')">登录</el-button>
            <el-button @click="resetForm('form')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>

      <el-tab-pane label="注册" name="2">
        <register></register>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import Register from './Register'

export default {
  components: {
    'register': Register
  },
  data () {
    return {
      activeName: '1',
      form: {
        username: '',
        password: ''
      },
      formRules: {
        username: [
          {required: true, message: '用户名不能为空', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码不能为空', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    handleClick (tab, event) {
    },
    submit (form) {
      console.log('提交')
    }
  }
}
</script>

<style scoped>
.login {
  width: 400px;
  margin: 0 auto;
}

.el-tabsitem {
  text-align: center;
  width: 60px;
}
</style>
