<template>
  <el-container>
    <el-header >
      <Header></Header>
    </el-header>

    <el-container>

      <el-aside style="width: 175px">
        <LeftSideMenu></LeftSideMenu>
      </el-aside>

      <el-container>
        <el-main style="padding-left: 10px;">
          <slot></slot>
        </el-main>
      </el-container>

    </el-container>

  </el-container>
</template>

<script>
  import Header from './top/Header';
  import LeftSideMenu from './left/LeftSideMenu';

  export default {
    name: "Layout",

    data(){
      return {
        nav : this.$router.options.routes || []
      };
    },

    components : {
      LeftSideMenu,
      Header
    }
  }
</script>

<style scoped>
</style>
