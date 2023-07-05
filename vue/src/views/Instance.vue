<template>
  <div class="instance-view">
    Not yet implemented...
    <product-info />
    <run-info />
    <instance-info />
  </div>
</template>

<script>
import InstanceInfo from '../components/info-cards/InstanceInfo.vue';
import ProductInfo from '../components/info-cards/ProductInfo.vue';
import RunInfo from '../components/info-cards/RunInfo.vue';

export default {
  name: 'instance-view',
  components: { ProductInfo, RunInfo, InstanceInfo },
}
</script>

<style>
</style>