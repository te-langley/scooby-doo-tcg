<template>
  <div class="card-details">
    <card :card="card" />
    <production-run-table :runs="runs" />
  </div>
</template>

<script>
import Card from '../components/info-cards/ProductInfo.vue'
import CardService from '../services/CardService'

import ProductionRunTable from '../components/ProductionRunTable.vue'
import ProductionRunService from '../services/ProductionRunService'

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
    CardService.get(this.$route.params.id).then((response) => {
      this.card = response.data;
    });
    ProductionRunService.getForProduct(this.$route.params.id).then((response) => {
      this.runs = response.data;
    });
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