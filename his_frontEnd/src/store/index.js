import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: null,
    isLogin:false,
    token:""
  },
  getters:{
    currentUser(state){
      return state.user
    },
    isLogin(state){
      return state.isLogin
    }
  },
  mutations: {
    login(state, user) {
        state.user=user
        state.isLogin=true
    },
    logout(state) {
      sessionStorage.setItem("userName",null);
      sessionStorage.setItem("userToken","");
      state.user=null
      state.isLogin=false
      state.token=""
    }
  },
  actions: {

  },
  modules: {

  }
})
