<template>
  <el-container>
    <el-header>Header</el-header>

    <el-container>
      <el-aside width="200px">
        <ul>
          <li v-for="item in nav">
            <router-link v-if="item.component" :to="item.path">
              <span>{{item.name}}</span>
            </router-link>
          </li>
        </ul>
      </el-aside>

      <el-container>
        <el-main>
          <slot></slot>
        </el-main>
      </el-container>

    </el-container>

  </el-container>
</template>

<script>
  export default {
    name: "Layout",

    data(){
      return {
        nav : this.$router.options.routes || []
      };
    }
  }
</script>

<style scoped>
  .el-header {
    background-color: #343a40;
    color: #FFFFFF;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    margin-top: 10px;
    background-color: rgb(244, 244, 245);;
    color: #333333;
    text-align: left;
    line-height: 40px;
  }

  .el-main {

  }

  .el-container {
    /*height: 100%!important;*/
  }

  /*body > .el-container {
      margin-bottom: 40px;
  }*/

  /*.el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
      line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
      line-height: 320px;
  }*/
</style>
