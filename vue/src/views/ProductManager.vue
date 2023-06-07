<template>
  <div class="product-manager">
    <!-- TODO: Toggle between operations divs. -->
    <div class="card-operations">
      <new-card />
      <card-table :cards="cards" />
    </div>
    <div class="production-runs-operations">
      <new-production-run />
      <production-run-table :runs="runs"/>
    </div>
  </div>
</template>

<script>
import NewCard from '../components/NewCard.vue'
import NewProductionRun from '../components/NewProductionRun.vue'
import ProductionRunTable from '../components/ProductionRunTable.vue'
import CardTable from '../components/CardTable.vue'
import CardService from '../services/CardService.js'
import ProductionRunService from '../services/ProductionRunService.js'

export default {
  name: 'product-manager',
  components: {
    ProductionRunTable,
    NewCard,
    NewProductionRun,
    CardTable
  },
  data() {
    return {
      cards: [],
      runs: []
    }
  },
  created() {
    CardService.list().then((response) => {
      this.cards = response.data;
    });
    ProductionRunService.list().then((response) => {
        this.runs = response.data;
    })
  },
}
</script>

<style>
.product-manager {
  width: 100%;
  height: 100%;
  background-color: rgb(92, 82, 109, 0.5);
  display: flex;
  flex-direction: column;
}

.card-operations {
  display: flex;
  align-items: flex-start;
  gap: 10px;
}

.production-runs-operations {
  display: flex;
  align-items: flex-start;
  gap: 10px;
}

</style>