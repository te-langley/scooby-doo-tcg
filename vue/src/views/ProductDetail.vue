<template>
  <div class="product-details">
    <product :product="product" />
    <production-run-table :runs="runs" />
  </div>
</template>

<script>
import Product from '../components/info-cards/ProductInfo.vue'
import ProductService from '../services/ProductService'

import ProductionRunTable from '../components/ProductionRunTable.vue'
import ProductionRunService from '../services/ProductionRunService'

export default {
  name: 'product-detail',
  components: {
    Product,
    ProductionRunTable
  },
  data() {
    return {
      product: {},
      runs: []
    }
  },
  created() {
    ProductService.get(this.$route.params.id).then((response) => {
      this.product = response.data;
    });
    ProductionRunService.getForProduct(this.$route.params.id).then((response) => {
      this.runs = response.data;
    });
  },
}
</script>

<style>
.product-details {
  display: flex;
  align-items: flex-start;
  gap: 10px;
}
</style>