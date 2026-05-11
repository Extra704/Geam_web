<template>
  <div class="page">
    <nav-bar />
    <div class="container">
      <h2>Profile</h2>
      <el-card>
        <p>Extend this page with profile editing and history records.</p>
      </el-card>
    </div>
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";

export default {
  name: "ProfilePage",
  components: { NavBar }
};
</script>

<style scoped>
.container {
  padding: 24px;
}
</style>
