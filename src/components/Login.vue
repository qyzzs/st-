<template>
<div class="login_container">
  <div class="login_box">
    <!-- 头像区 -->
    <div class="avatar_box">
      <img src="../assets/logo.png"/>
    </div>
    <!-- 登录表单区 -->
    <el-form ref="loginFormRef" :model="userinfo" :rules="loginFormRules" label-width="0px" class="login_form" >
      <el-form-item prop="userName">
        <el-input v-model="userinfo.userName" placeholder="请输入用户名" suffix-icon="el-icon-user"></el-input>
      </el-form-item>
      <el-form-item prop="passWord">
        <el-input v-model="userinfo.passWord" placeholder="请输入密码" type="password" suffix-icon="el-icon-edit"></el-input>
      </el-form-item>
      <div class="check_btn">
        <div class="checkbox">
          <el-checkbox v-model="checked">十天内免登录</el-checkbox>
        </div>
        <div class="btn">
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="info" @click="resetLoginForm">重置</el-button>
        </div>
      </div>
    </el-form>
  </div>
</div>

</template>
<script>
export default {
  name: 'Login',
  data () {
    return {
      checked: false,
      userinfo: {
        userName: '',
        passWord: ''
      },
      loginFormRules: {
        userName: [{ required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在3到10个字符', trigger: 'blur' }],
        passWord: [{ required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在6到15个字符', trigger: 'blur' }]
      }
    }
  },
  methods: {
    resetLoginForm () {
      this.$refs.loginFormRef.resetFields()
    },
    login () {
      this.$refs.loginFormRef.validate(async valid => {
        if (!valid) { } else {
          const url = 'api/user/checkUser/?'
          const resp = await this.getRequest(url, { username: this.userinfo.userName })
          console.log(resp)
          if (resp.status === 200 && this.userinfo.passWord === resp.data.Data.UserPwd) {
            this.$message.success('登陆成功')
            window.sessionStorage.setItem('token', resp.data.Data.UserId)
            this.$router.push('/home')
          } else {
            this.$message.error('登录失败')
            // 暂时使用userid作为token
          }
        }
      }
      )
    }
  }
}
</script>
<style lang="less" scoped>
.login_container {
  background-color: #2b4b6b;
  height: 100%;
}
.login_box{
  width: 450px;
  height: 350px;
  background-color: #ffffff;
  border-radius:3px;
  position: absolute;
  left:50%;
  top:50%;
  transform: translate(-50%,-50%)
}
 .avatar_box{
    height: 130px;
    width:130px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding:10px;
    box-shadow: 0 0 10px #ddd;
    position: absolute;
    left:50%;
    transform: translate(-50%,-50%);
    background-color: #ffffff;
    img{
      width:100%;
      height:100%;
      border-radius: 50%;
      background-color: #eeeeee
    }
  }
  .login_form{
    position: absolute;
    bottom: 0px;
    width: 100%;
    padding: 0 10px;
    box-sizing: border-box;
  }
  .check_btn{
    display: grid;
    grid-template-columns:50% 50%;
    margin-bottom:25px;
  }
  .checkbox{
    display:flex;
    justify-content:flex-start;
  }
  .btn{
    display:flex;
    justify-content:flex-end;
  }
</style>
