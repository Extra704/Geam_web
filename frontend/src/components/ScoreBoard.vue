<template>
  <el-descriptions :column="2" border>
    <el-descriptions-item label="Score">{{ score }}</el-descriptions-item>
    <el-descriptions-item label="Time">{{ duration }}s</el-descriptions-item>
  </el-descriptions>
</template>

<script>
export default {
  name: "ScoreBoard",
  props: {
    score: {
      type: Number,
      default: 0
    },
    duration: {
      type: Number,
      default: 0
    }
  }
};
</script>
