import Vue from "vue";
import Vuex from "vuex";
import { getToken, removeToken, setToken } from "../utils/auth";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    token: getToken(),
    user: null
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.token = token;
      setToken(token);
    },
    SET_USER(state, user) {
      state.user = user;
    },
    LOGOUT(state) {
      state.token = "";
      state.user = null;
      removeToken();
    }
  }
});
