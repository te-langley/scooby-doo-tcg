<template>
  <div class="catalog-container">
    <router-link
      :to="{ name: 'product', params: { id: product.productCode } }"
      v-for="product in products"
      :key="product.id"
    >
      <product :product="product" />
    </router-link>
  </div>
</template>

<script>
import Product from '../components/info-cards/ProductInfo.vue'
import ProductService from '../services/ProductService.js'

export default {
  name: '',
  data() {
    return {
      products: []
    }
  },
  created() {
    ProductService.list().then((response) => {
      this.products = response.data;
    });
  },
  components: {
    Product,
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