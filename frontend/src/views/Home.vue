<template>
  <div class="page">
    <nav-bar />
    <div class="container">
      <h1>Geam Web</h1>
      <el-row :gutter="20">
        <el-col :span="8" v-for="game in games" :key="game.id">
          <game-card :game="game" />
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import GameCard from "../components/GameCard.vue";
import { getGames } from "../api/game";

export default {
  name: "HomePage",
  components: { NavBar, GameCard },
  data() {
    return {
      games: []
    };
  },
  async created() {
    const { data } = await getGames();
    this.games = data.data || [];
  }
};
</script>

<style scoped>
.container {
  padding: 24px;
}
</style>
