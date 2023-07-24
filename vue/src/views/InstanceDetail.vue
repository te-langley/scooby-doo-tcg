<template>
  <div class="instance-view">
    <div class="instance-cards">
      <product-info :product="product" />
      <run-info :run="run" />
      <instance-info :instance="instance" />
    </div>
    <button class="claim-button" @click="claim" v-if="instance.claimed === false">Claim</button>
    <button class="release-button" @click="release" v-else>Release</button>
  </div>
</template>

<script>
import InstanceInfo from '../components/info-cards/InstanceInfo.vue';
import InstanceService from '../services/InstanceService';

import ProductInfo from '../components/info-cards/ProductInfo.vue';
import RunInfo from '../components/info-cards/RunInfo.vue';

import ProductService from '../services/ProductService'
import ProductionRunService from '../services/ProductionRunService'

export default {
  name: 'instance-view',
  components: { ProductInfo, RunInfo, InstanceInfo },
  data() {
    return {
      product: {},
      run: {},
      instance: {}
    }
  },
  created() {
    InstanceService.getInstance(this.$route.params.serial).then((response) => {
      this.instance = response.data;
      ProductService.get(this.instance.productCode).then((response) => {
        this.product = response.data;
      });
      ProductionRunService.get(this.instance.productionRun).then((response) => {
        this.run = response.data;
      });
    });
  },
  methods: {
    claim() {
      alert("Claim")
    },
    release() {
      alert("Release")
    }
  }
}
</script>

<style>
.instance-cards {
  display: flex;
}

.claim-button {
  background-color: var(--kingston-mansion-moon);
  height: 32px;
  border: none;
  border-radius: 16px;
  color: var(--kingston-mansion-sky);
  padding: 0 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  cursor: pointer;
}

.release-button {
  background-color: var(--kingston-mansion-sky);
  height: 32px;
  border: none;
  border-radius: 16px;
  color: var(--kingston-mansion-moon);
  padding: 0 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  cursor: pointer;
}
</style>