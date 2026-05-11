<template>
  <div class="page form-page">
    <el-card class="card">
      <h2>Login</h2>
      <el-form :model="form">
        <el-form-item label="Username">
          <el-input v-model="form.username" />
        </el-form-item>
        <el-form-item label="Password">
          <el-input v-model="form.password" type="password" />
        </el-form-item>
        <el-button type="primary" @click="handleLogin">Login</el-button>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { login } from "../api/auth";

export default {
  name: "LoginPage",
  data() {
    return {
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    async handleLogin() {
      const { data } = await login(this.form);
      this.$store.commit("SET_TOKEN", data.data.token);
      this.$router.push("/");
    }
  }
};
</script>

<style scoped>
.form-page {
  display: flex;
  justify-content: center;
  padding-top: 80px;
}

.card {
  width: 420px;
}
</style>
