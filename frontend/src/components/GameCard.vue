<template>
  <el-card shadow="hover">
    <h3>{{ game.name }}</h3>
    <p>{{ game.description }}</p>
    <el-button type="primary" @click="$router.push(`/game/${game.id}`)">Start</el-button>
  </el-card>
</template>

<script>
export default {
  name: "GameCard",
  props: {
    game: {
      type: Object,
      required: true
    }
  }
};
</script>
