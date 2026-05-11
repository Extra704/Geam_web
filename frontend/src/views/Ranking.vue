<template>
  <div class="page">
    <nav-bar />
    <div class="container">
      <h2>Global Ranking</h2>
      <el-table :data="rows" border>
        <el-table-column prop="nickname" label="Nickname" />
        <el-table-column prop="bestScore" label="Best Score" />
      </el-table>
    </div>
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import { getGlobalRanking } from "../api/ranking";

export default {
  name: "RankingPage",
  components: { NavBar },
  data() {
    return {
      rows: []
    };
  },
  async created() {
    const { data } = await getGlobalRanking();
    this.rows = data.data || [];
  }
};
</script>

<style scoped>
.container {
  padding: 24px;
}
</style>
