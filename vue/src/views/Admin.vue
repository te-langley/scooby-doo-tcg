<template>
  <div class="product-manager">
    <admin-nav @div-selected="updateDisplay" />
    <admin-products v-if="displayed === 'products'" />
    <admin-production-runs v-else/>
  </div>
</template>

<script>
import AdminNav from '../components/AdminNav.vue'
import AdminProducts from '../components/AdminProducts.vue'
import AdminProductionRuns from '../components/AdminProductionRuns.vue'


export default {
  name: 'admin',
  components: {
    AdminNav,
    AdminProducts,
    AdminProductionRuns
  },
  data() {
      return {
          displayed: 'products'
      }
  },
  methods: {
      updateDisplay(value) {
          this.displayed = value;
      }
  }
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

</style>