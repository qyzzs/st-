<template>
  <el-card>
  <el-table
    :data="empsData"
    height="250"
    border
    style="width: 100%">
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
</template>
<script>
export default {
  data () {
    return {
      empsData: []
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
    }
  }
}
</script>
<style lang="less" scoped>

</style>
