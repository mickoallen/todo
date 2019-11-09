import Vue from "vue";
import Router from "vue-router";
import TodosList from "./components/TodosList.vue";
import AddTodo from "./components/AddTodo.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "get",
      component: TodosList
    },
    {
      path: "/nextPage",
      name: "add",
      component: AddTodo
    }
  ]
});