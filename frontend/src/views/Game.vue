<template>
  <div class="page">
    <nav-bar />
    <div class="container">
      <h2>{{ game.name || 'Game' }}</h2>
      <score-board :score="score" :duration="duration" />
      <el-button type="success" @click="mockFinish">Finish Current Round</el-button>
    </div>
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import ScoreBoard from "../components/ScoreBoard.vue";
import { getGameDetail, submitScore } from "../api/game";

export default {
  name: "GamePage",
  components: { NavBar, ScoreBoard },
  data() {
    return {
      game: {},
      score: 0,
      duration: 0
    };
  },
  async created() {
    const { data } = await getGameDetail(this.$route.params.id);
    this.game = data.data || {};
  },
  methods: {
    async mockFinish() {
      this.score = Math.floor(Math.random() * 100);
      this.duration = Math.floor(Math.random() * 60);
      await submitScore({
        gameId: Number(this.$route.params.id),
        score: this.score,
        duration: this.duration,
        result: "SUCCESS"
      });
      this.$message.success("Score submitted");
    }
  }
};
</script>

<style scoped>
.container {
  padding: 24px;
}
</style>
