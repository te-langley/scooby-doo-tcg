<template>
  <div class="card-details">
    <card v-bind:card="card" />
    <production-run-table :runs="runs" />
  </div>
</template>

<script>
import Card from '../components/Card.vue'
import ProductionRunTable from '../components/ProductionRunTable.vue'
import productionRunService from '../services/ProductionRunService'
import cardService from '../services/CardService'

export default {
  name: 'card-detail',
  components: {
    Card,
    ProductionRunTable
  },
  data() {
    return {
      card: {},
      runs: []
    }
  },
  created() {
    cardService.get(this.$route.params.id).then((response) => {
      this.card = response.data;
    });
    productionRunService.getForProduct(this.$route.params.id).then((response) => {
      this.runs = response.data;
    })
  },
}
</script>

<style>
.card-details {
  display: flex;
  align-items: flex-start;
  gap: 10px;
}
</style>