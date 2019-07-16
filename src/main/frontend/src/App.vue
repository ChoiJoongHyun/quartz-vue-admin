<template>
  <div id="app" style="margin-top: 0">

    <Layout>
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
    </Layout>

    <!--<img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
  </div>
</template>

<script>
import Layout from './layout/Layout'

export default {
  name: 'app',
  components: {
    Layout
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
