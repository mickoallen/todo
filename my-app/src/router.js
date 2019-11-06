import Vue from "vue";
import Router from "vue-router";
import TodosList from "./components/TodosList.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "get",
      component: TodosList
    }
  ]
});