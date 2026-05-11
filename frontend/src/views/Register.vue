<template>
  <div class="page form-page">
    <el-card class="card">
      <h2>Register</h2>
      <el-form :model="form">
        <el-form-item label="Username">
          <el-input v-model="form.username" />
        </el-form-item>
        <el-form-item label="Nickname">
          <el-input v-model="form.nickname" />
        </el-form-item>
        <el-form-item label="Password">
          <el-input v-model="form.password" type="password" />
        </el-form-item>
        <el-button type="primary" @click="handleRegister">Register</el-button>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { register } from "../api/auth";

export default {
  name: "RegisterPage",
  data() {
    return {
      form: {
        username: "",
        nickname: "",
        password: ""
      }
    };
  },
  methods: {
    async handleRegister() {
      await register(this.form);
      this.$router.push("/login");
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
