<template>
  <div class="current-user" v-if="$store.getters.isLoggedIn">
    <div class="user-image"><img :src="ppPath" /></div>
    <div class="user-name">{{ $store.state.user.username }}</div>
  </div>
</template>

<script>
export default {
  name: 'current-user',
  computed: {
    ppPath() {
      let file = '';
      try {
        file = require('../assets/images/pp.png');
      } catch {
        file = require('../assets/images/pp.png');
      }
      return file;
    },
  },
}
</script>

<style>
.current-user {
  height: 50px;
  width: 100%;
  background-color: black;
  color: white;
  border-radius: 25px;
  display: flex;
  font-size: 24px;
  align-items: center;
  gap: 5px;
}

.user-image img {
  width: 50px;
  height: 50px;
  border-radius: 25px;
}
</style>