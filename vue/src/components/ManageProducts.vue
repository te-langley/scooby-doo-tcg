<template>
  <div class="manage-products">
    <new-card v-on:update-cards="refreshCards" />
    <card-table :cards="cards" />
  </div>
</template>

<script>
import NewCard from '../components/NewCard.vue'
import CardTable from '../components/CardTable.vue'
import CardService from '../services/CardService.js'

export default {
  name: '',
  components: {
    NewCard,
    CardTable
  },
  data() {
    return {
      cards: []
    }
  },
  created() {
    this.refreshCards();
  },
  methods: {
    refreshCards() {
      CardService.list().then((response) => {
        this.cards = response.data;
      });
    }
  }
}
</script>

<style>
</style>