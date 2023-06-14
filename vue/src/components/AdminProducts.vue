<template>
  <div class="admin-products">
    <new-card v-on:update-products="refreshProducts" />
    <card-table :cards="products" />
  </div>
</template>

<script>
import NewCard from './NewCard.vue'
import CardTable from './CardTable.vue'
import CardService from '../services/CardService.js'

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
      CardService.list().then((response) => {
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