<template>
  <div class="catalog-container">
    <router-link
      :to="{ name: 'card', params: { id: card.id } }"
      v-for="card in cards"
      :key="card.id"
    >
      <card :card="card" />
    </router-link>
  </div>
</template>

<script>
import Card from '../components/Card.vue'
import CardService from '../services/CardService.js'

export default {
  name: '',
  data() {
    return {
      cards: []
    }
  },
  created() {
    CardService.list().then((response) => {
      this.cards = response.data;
    });
  },
  components: {
    Card,
  }
}
</script>

<style>
.catalog-container {
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  justify-content: space-evenly;
}
</style>