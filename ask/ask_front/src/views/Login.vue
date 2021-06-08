<template>
  <div id="login_main">
    <div class="login-box">
      <h1 style="color: white">登录</h1>
      <el-form ref="form" :model="form" style="width: 50%;">
        <el-form-item label="">
          <el-input v-model="form.userId" placeholder="用户名.."></el-input>
        </el-form-item>
        <el-form-item label="">
          <el-input type="password" v-model="form.password" placeholder="登录密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login" :disabled="loginBtnDisabled">登录</el-button>
          <el-button type="info" @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
import image from '@/assets/images/login_background.jpeg'

export default {
  data() {
    return {
      backgroundImage: image,
      form: {
        userId: 'U0001',
        password: '123'
      },
      loginBtnDisabled: false
    }
  },
  created() {
    this.showLoginMessage()
  },
  methods: {
    showLoginMessage() {
      if (this.$route.query) {
        this.openMessageWarning('登录信息已过期，请重新登录')
      }
    },
    login() {
      if (this.isEmpty(this.form.userId) || this.isEmpty(this.form.password)) {
        this.openMessageWarning('用户名和密码不能为空')
        return
      }
      this.loginBtnDisabled = true
      let param = this.form
      this.axios.post('auth/login', param).then((res) => {
        if (res.data.code === 200) {
          this.openMessageSuccess('登录成功')
          this.$router.push({path: '/', query: {}})
        } else {
          this.openMessageError(res.data.message)
        }
        this.loginBtnDisabled = false
      })
    },
    resetForm() {
      this.form.userId = '',
        this.form.password = '',
        this.openMessageSuccess('表单重置成功')
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
#login_main {
  background: url('../assets/images/login_background.jpeg');
  background-size: 100% 100%;
  width: 100%;
  height: 100%;
  /* z-index: 1; */
  position: fixed;
  /*兼容浏览器版本*/
  -webkit-background-size: cover;
  -o-background-size: cover;
  background-size: cover;

  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}

.login-box {
  width: 550px;
  height: 380px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.login-box::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 550px;
  height: 380px;
  margin: auto;
  border-radius: 5px;
  background: rgba(255, 255, 255, .2);
  box-shadow: 3px 3px 6px 3px rgba(0, 0, 0, .5);
}
</style>
