<template>
    <div class="list row">
        <div class="col-md-6">
            <h4>Todos List</h4>
            <ul>
                <li v-for="(todo, index) in todos" :key="index">
                    <router-link :to="{
                            name: 'customer-details',
                            params: { chore: chore }
                        }">
                            {{todos.chore}}
                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "todos-list",
  data() {
    return {
      customers: []
    };
  },
  methods: {
    retrieveTodos() {
      http
        .get("/get")
        .then(response => {
          this.todos = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveTodos();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.retrieveTodos();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}
</style>