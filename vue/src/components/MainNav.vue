<template>
  <nav class="main-nav">
    <router-link v-bind:to="{ name: 'home' }"> Home </router-link>
    <router-link v-bind:to="{ name: 'catalog' }"> Catalog </router-link>
    <router-link v-bind:to="{ name: 'admin' }"> Product Manager </router-link>
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
      Logout
    </router-link>
  </nav>
</template>

<script>
export default {

}
</script>

<style>
.main-nav {
  display: flex;
  flex-direction: column;
  background-color: var(--kingston-mansion-black);
  text-align: center;
}

.main-nav a {
  color: var(--kingston-mansion-lawn);
  padding: 8px;
}

.main-nav a.router-link-exact-active {
  background-color: var(--kingston-mansion-lawn);
  color: var(--kingston-mansion-black);
}

.main-nav a:hover {
  background-color: var(--kingston-mansion-purple);
  color: var(--kingston-mansion-black);
}
</style>