<template>
  <div class="admin-runs">
    <new-production-run />
    <production-run-table :runs="$store.state.runs" />
  </div>
</template>

<script>
import NewProductionRun from '../components/NewProductionRun.vue'
import ProductionRunTable from '../components/ProductionRunTable.vue'

export default {
  name: 'admin-runs',
  components: {
    ProductionRunTable,
    NewProductionRun
  },
  created() {
    this.$store.dispatch('REFRESH_RUNS');
  }
}
</script>

<style>
.admin-runs {
  display: flex;
  align-items: flex-start;
  gap: 10px;
}
</style>