<template>
<div>
  <!-- 面包屑导航区 -->
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>人事管理</el-breadcrumb-item>
    <el-breadcrumb-item>活动列表</el-breadcrumb-item>
  </el-breadcrumb>
  <!-- 卡片视图区 -->
  <el-card>
    <el-row class="row-position">
      <el-col :span="7">
        <el-button-group>
          <el-button size="small" type="primary" icon="el-icon-plus">新增</el-button>
          <el-button size="small" icon="el-icon-edit">编辑</el-button>
          <el-button size="small" icon="el-icon-delete">删除</el-button>
        </el-button-group>
      </el-col>
      <el-col :span="7" :offset="10">
        <el-input size="small" placeholder="请输入需要查找的内容">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </el-col>
    </el-row>
    <el-card>
      <el-table
        @selection-change="handleSelectionChange"
        style="width: 100%"
        :data="empsData"
        stripe
        >
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="gender"
          label="性别"
          width="180">
        </el-table-column>
        <el-table-column
          prop="birthday"
          label="生日">
        </el-table-column>
      </el-table>
    </el-card>
  </el-card>
</div>
</template>
<script>
export default {
  data () {
    return {
      empsData: [],
      multipleSelection: []
    }
  },
  created () {
    this.getAllemps()
  },
  methods: {
    getAllemps () {
      const url = 'emps/findall?'
      this.getRequest(url, { pageindex: this.pageIndex, pageSize: this.pageSize }).then(resp => {
        this.empsData = resp.data.extend.emps
      })
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
      console.log(val)
    }
  }
}
</script>
<style lang="less" scoped>
.row-position{
  margin-bottom:10px
}
</style>
