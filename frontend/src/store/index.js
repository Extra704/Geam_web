import { createStore } from "vuex";
import { getToken, removeToken, setToken } from "../utils/auth";

export default createStore({
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
