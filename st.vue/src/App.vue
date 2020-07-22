<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  name: 'app'
}
</script>
<style>
.el-card{
  margin-top:20px;
  font-size: 12px;
  box-shadow: 0 1px 1px rgba(0,0,0,0.15) !important;
}
.el-button{
  size: small;
}
</style>
