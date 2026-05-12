import { createRouter, createWebHashHistory } from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Register from "../views/Register.vue";
import Game from "../views/Game.vue";
import Ranking from "../views/Ranking.vue";
import Profile from "../views/Profile.vue";
import Admin from "../views/Admin.vue";
import { getToken } from "../utils/auth";

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    { path: "/", name: "Home", component: Home },
    { path: "/login", name: "Login", component: Login },
    { path: "/register", name: "Register", component: Register },
    { path: "/game/:id", name: "Game", component: Game, meta: { requiresAuth: true } },
    { path: "/ranking", name: "Ranking", component: Ranking },
    { path: "/profile", name: "Profile", component: Profile, meta: { requiresAuth: true } },
    { path: "/admin", name: "Admin", component: Admin, meta: { requiresAuth: true } }
  ]
});

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && !getToken()) {
    next("/login");
    return;
  }
  next();
});

export default router;
