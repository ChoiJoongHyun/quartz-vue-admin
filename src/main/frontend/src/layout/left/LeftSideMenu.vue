<template>
  <div>
    <el-menu class="el-menu-vertical"
             background-color="#545c64"
             text-color="#fff"
             active-text-color="#ffd04b"
             :collapse="isCollapse"
             style="width: 170px">

      <template v-if="item.component" v-for="(item, index) in nav">

        <template v-if="item.children">
          <el-submenu :index="`${index}`">

            <template slot="title">
              <i :class="item.meta.icon"></i>
              <span slot="title">{{item.meta.title}}</span>
            </template>

            <template v-for="(c, i) in item.children">
              <el-menu-item v-on:click="moveRouterPath(c.path)"
                            :index="`${index}-${i}`">
                {{c.meta.title}}
              </el-menu-item>
            </template>

          </el-submenu>
        </template>

        <template v-else>
          <el-menu-item :index="`${index}`" v-on:click="moveRouterPath(item.path)">
            <i :class="item.meta.icon"></i>
            <span slot="title">
              {{item.meta.title}}
            </span>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
  export default {
    name: "LeftSideMenu",

    data() {
      return {
        isCollapse: false,
        nav : this.$router.options.routes || []
      };
    },

    methods: {
      moveRouterPath(path) {
        window.location.href = '#' + path;
      }
    }
  }
</script>

<style scoped>

  .el-menu-vertical:not(.el-menu--collapse) {
    text-align: left;
    width: 200px;
    min-height: 350px;
  }

</style>
