<template>
  <div class="admin-products">
    <new-card v-on:update-products="refreshProducts" hidden/>
    <card-table :cards="products" hidden/>
  </div>
</template>

<script>
import NewCard from './NewCard.vue'
import CardTable from './CardTable.vue'
import ProductService from '../services/ProductService.js'

export default {
  name: 'admin-products',
  components: {
    NewCard,
    CardTable
  },
  data() {
    return {
      products: []
    }
  },
  created() {
    this.refreshProducts();
  },
  methods: {
    refreshProducts() {
      ProductService.list().then((response) => {
        this.products = response.data;
      });
    }
  }
}
</script>

<style>
.admin-products {
  display: flex;
  align-items: flex-start;
  gap: 16px;
}
</style>