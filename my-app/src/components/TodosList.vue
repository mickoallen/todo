<template>
    <v-container>
        <v-row>
            <v-col cols="6">
                <v-card class="mx-auto" max-width="400" tile>
                    <v-card-title>Todo list!</v-card-title>
                    <v-card-text>
                        <v-list-item v-for="todo in todos" v-bind:key="todo.id">
                            <v-list-item-content>
                                <v-list-item-title>{{todo.chore}}</v-list-item-title>
                            </v-list-item-content>
                        </v-list-item>
                    </v-card-text>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import http from "../http-common";

export default {
    name: "todos-list",
    data() {
        return {
            todos: []
        };
    },
    methods: {
        retrieveTodos() {
            http.get("/get")
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