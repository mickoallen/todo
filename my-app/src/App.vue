<template>
    <div id="app" class="container-fluid">
        <div class="site-info">
            <h1>mOOOOOO</h1>
            <h3>Shit to do</h3>
        </div>
        
        <router-link to="/">Todos</router-link>
        
        <br/>
        <router-view/>
    </div>
</template>

<script>
export default {
  name: "app"
};
</script>

<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
}

.btn-primary {
  margin-right: 5px;
}

.container-fluid {
  text-align: center;
}
</style>