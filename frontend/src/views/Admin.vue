<template>
  <div class="page">
    <nav-bar />
    <div class="container">
      <h2>Admin Console</h2>
      <el-card>
        <p>Add user management, game management, and announcements here.</p>
      </el-card>
    </div>
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";

export default {
  name: "AdminPage",
  components: { NavBar }
};
</script>

<style scoped>
.container {
  padding: 24px;
}
</style>
