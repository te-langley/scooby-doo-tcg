<template>
  <div class="run-detail-container">
    <div class="info">
      <card :card="card" />
      <production-run :run="run" />
    </div>
    <div class="actions">
      <button>Cancel</button>
      <button>Accept</button>
      <button disabled="disabled">Complete</button>
    </div>
  </div>
</template>

<script>
import Card from '../components/Card.vue'
import ProductionRun from '../components/ProductionRun.vue'

import CardService from '../services/CardService'
import ProductionRunService from '../services/ProductionRunService'

export default {
  name: 'run-detail',
  components: {
    Card,
    ProductionRun
  },
  data() {
    return {
      card: {},
      run: {}
    }
  },
  created() {
    ProductionRunService.get(this.$route.params.id).then((response) => {
      this.run = response.data;
      CardService.get(this.run.productCode).then((response) => {
        this.card = response.data;
      });
    });
  },
}
</script>

<style>
.run-detail-container {
    display: flex;
    flex-direction: column;
}

.run-detail-container .info {
    display: flex;
    justify-content: center;
    gap: 16px;
}

.run-detail-container .actions {
    display: flex;
    gap: 10px;
}
</style>