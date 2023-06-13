<template>
  <div id="app">
    <header>Scooby Doo TCG</header>
    <nav class="main-nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link v-bind:to="{ name: 'catalog' }">Catalog</router-link>
      <hr />
      <!-- TODO: Hide for non-admin users. -->
      <div class="admin">
        <div class="main-nav-header">Admin</div>
        <router-link v-bind:to="{ name: 'admin' }">
          Product Manager
        </router-link>
        <hr />
      </div>
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
      >
        Logout
      </router-link>
    </nav>
    <main>
      <router-view />
    </main>
  </div>
</template>
