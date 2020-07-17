<template>
  <el-container class="home-container">
    <!-- 头部 -->
    <el-header>
      <div style="display:flex; justify-content: space-between;">
        <div class="img-style">
          <img src="../assets/e.jpg">
        </div>
        <div>
          <span>人事管理</span>
        </div>
      </div>
      <div>
        <el-dropdown>
          <span class="el-dropdown-link">
            当前用户<i></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item icon="el-icon-user-solid">个人资料</el-dropdown-item>
            <el-dropdown-item icon="el-icon-close"><el-link :underline="false" @click="quit">退 出</el-link></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
      </el-header>
    <!-- 主体 -->
    <el-container>
      <!-- 左侧边菜单 -->
      <el-aside width="200px">
        <el-menu
          background-color="#FFFFFF"
          text-color="#131212"
          active-text-color="#ffd04b">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>员工资料</span>
            </template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">人事管理</span>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">薪资管理</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">系统管理</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <!--右边内容主体 -->
      <el-main>Main</el-main>
    </el-container>
  </el-container>
</template>
<script>
export default {
  name: 'home',
  data () {
    return {
      pageIndex: 1,
      pageSize: 5
    }
  },
  // computed: {
  //   user(){
  //     return this
  //   }
  // },
  created () {
    this.getAllemps()
  },
  methods: {
    quit () {
      window.sessionStorage.clear()
      this.$router.push('/login')
    },
    getAllemps () {
      const url = 'api/wareHouseIn/getAllWareHouseIn/?'
      this.getRequest(url, { pageindex: this.pageIndex, pageSize: this.pageSize }).then(resp => {
        console.log(resp)
        
      })
    }
  }
}
</script>
<style lang="less" scoped>
.home-container{
  height: 100%;
}
.el-header{
  background-color: #409EFF;
  display: flex;
  justify-content: space-between;
  padding-left: 0px;
  align-items: center;
  color:aliceblue;
  font-size: 25px;
  div{
    display: flex;
    align-items: center;
    span{
      margin-left:15px
    }
  }
}
.el-aside{
  background-color: #FFFFFF
}
.el-main{
  background-color: #E7EBEF
}
.img-style{
  width: 60px;
  height: 60px;
   img{
    width:100%;
    height: 100%;
  }
}
</style>
