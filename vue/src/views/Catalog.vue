<template>
  <div class="catalog-container">
    <router-link
      v-bind:to="{ name: 'card', params: { id: card.id } }"
      v-for="card in cards"
      v-bind:key="card.id"
    >
      <card v-bind:card-id="card.id" />
    </router-link>
  </div>
</template>

<script>
import Card from '../components/Card.vue'
import cardService from '../services/CardService.js'

export default {
  name: '',
  data() {
    return {
      cards: []
    }
  },
  created() {
    cardService.list().then((response) => {
      this.cards = response.data;
    });
  },
  components: {
    Card
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