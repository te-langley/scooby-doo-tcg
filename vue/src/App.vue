<template>
  <div id="app">
    <header>Scooby Doo TCG</header>
    <main-nav />
    <main>
      <router-view />
    </main>
  </div>
</template>

<script>
import MainNav from './components/MainNav.vue'

export default {
    name: '',
    components: {
        MainNav
    }
}
</script>
