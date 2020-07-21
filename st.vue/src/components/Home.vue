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
          class="el-menu-vertical-demo"
          background-color="#fff"
          text-color="#1E1E1E"
          active-text-color="#ffd04b">
          <el-submenu :index="item.menuId+''" v-for="item in menulist" :key="item.menuId">
            <template slot="title">
              <i :class="iconObj[item.menuId]"></i>
              <span>{{item.menuName}}</span>
            </template>
              <el-menu-item :index="subitem.submeid+''" v-for="subitem in item.submenuList" :key="subitem.submeid">
                <template slot="title">
                  <i class="el-icon-menu"></i>
                  <span>{{subitem.submenuName}}</span>
                </template>
              </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <!--右边内容主体 -->
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>
<script>
export default {
  name: 'home',
  data () {
    return {
      pageIndex: 1,
      pageSize: 5,
      menulist: [],
      iconObj: {
        1: 'el-icon-user-solid',
        2: 'el-icon-s-grid',
        3: 'el-icon-s-release',
        4: 'el-icon-help',
        5: 'el-icon-s-operation'
      }
    }
  },
  // computed: {
  //   user(){
  //     return this
  //   }
  // },
  created () {
    this.getAllmenus()
  },
  methods: {
    quit () {
      window.sessionStorage.clear()
      this.$router.push('/login')
    },
    getAllmenus () {
      this.getRequest('/menus').then(resp => {
        this.menulist = resp.data.extend.menus
        console.log('11')
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
