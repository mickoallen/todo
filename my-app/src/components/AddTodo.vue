<template>
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
    </v-container>
  </v-form>
</template>

<script>
import http from "../http-common";

export default {
    methods: {
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
        }
    },
    getPriority() {
        var selectedPriority = this.selectedPriority.toUpperCase();
        return selectedPriority.toUpperCase();
    }
};
</script>