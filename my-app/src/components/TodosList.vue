<template>
    <v-container>
        <v-row>
            <v-col cols="6">
                <v-card class="mx-auto" max-width="900" tile>
                    <v-card-title>Todo list!</v-card-title>
                                  <v-data-table
                                    :headers="headers"
                                    :items="todos"
                                    :items-per-page="20"
                                    class="elevation-1"
                                  ></v-data-table>
                </v-card>
            </v-col>

            <v-col>
                <v-form>
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="6">
                          <v-text-field
                            placeholder="Chore"
                            v-model="todo"
                            single-line
                          ></v-text-field>
                        </v-col>
                      </v-row>

                    <v-divider></v-divider>

                      <v-row>

                       <v-container fluid>
                        <v-subheader>Select Priority</v-subheader>
                           <v-radio-group v-model="selectedPriority" :mandatory="true" @click="getPriority">
                             <v-radio label="ALL" value="ALL"></v-radio>
                             <v-radio label="HIGH" value="HIGH"></v-radio>
                             <v-radio label="MED" value="MED"></v-radio>
                             <v-radio label="LOW" value="LOW"></v-radio>
                           </v-radio-group>
                         </v-container>
                      </v-row>

                      <v-col cols="12" sm="6">
                        <div class="text-center">
                          <v-btn rounded color="primary" dark @click="addTodo">Add Chore</v-btn>
                        </div>
                      </v-col>
                      <v-col cols="12" sm="6">
                        <div class="text-center">
                          <v-btn rounded color="error" dark @click="removeAll">DELETE ALL</v-btn>
                        </div>
                      </v-col>
                    </v-container>
                  </v-form>
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
            todos: [],
            headers: [
              { text: 'Chore', value: 'chore' },
              { text: 'Priority', value: 'priority' },
              { text: 'finished', value: 'finished' }
            ]
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
        },
        addTodo() {
            http.post('/add',
                            {
                                chore: this.todo,
                                priority: this.selectedPriority,
                                finished: false
                            }
                      ).catch( error => {
                        console.log('error: ' + error);
                      });
            },
        removeAll() {
            console.log("hahaaaa");
             http.post("/removeAll")
                            .catch(e => {
                               console.log(e);
              });
        },
        getPriority() {
            var selectedPriority = this.selectedPriority.toUpperCase();
            return selectedPriority.toUpperCase();
    }},
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