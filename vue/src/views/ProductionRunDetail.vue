<template>
  <div class="run-detail-container">
    <div class="info">
      <product :product="product" />
      <production-run :run="run" />
    </div>
    <div class="actions">
      <button v-if="canCancelRun" @click="cancelRun">Cancel</button>
      <button v-if="canAcceptRun" @click="acceptRun">Accept</button>
      <button v-if="canCompleteRun" @click="completeRun">Complete</button>
    </div>
    <experimental-form :inRun="run"/>
  </div>
</template>

<script>
import Product from '../components/info-cards/ProductInfo.vue'
import ProductService from '../services/ProductService'

import ProductionRun from '../components/info-cards/RunInfo.vue'
import ProductionRunService from '../services/ProductionRunService'

import InstanceService from '../services/InstanceService'

import ExperimentalForm from '../components/ExperimentalRunForm.vue'

export default {
  name: 'run-detail',
  components: {
    Product,
    ProductionRun,
    ExperimentalForm
  },
  data() {
    return {
      product: {},
      run: {}
    }
  },
  created() {
    this.getRun();
  },
  computed: {
    canCancelRun() {
      if (this.run.status === 'In Progress' || this.run.status === 'Pending') {
        return true;
      }
      return false;
    },
    canAcceptRun() {
      if (this.run.status === 'Pending') {
        return true;
      }
      return false;
    },
    canCompleteRun() {
      if (this.run.status === 'In Progress') {
        return true;
      }
      return false;
    }
  },
  methods: {
    getRun() {
      ProductionRunService.get(this.$route.params.id).then((response) => {
        this.run = response.data;
        ProductService.get(this.run.productCode).then((response) => {
          this.product = response.data;
        });
      });
    },
    cancelRun() {
      ProductionRunService.updateStatus(this.$route.params.id, 'Canceled').then(() => { this.getRun(); });
    },
    acceptRun() {
      ProductionRunService.updateStatus(this.$route.params.id, 'In Progress').then(() => { this.getRun(); });
      InstanceService.createInstances(this.run);
    },
    completeRun() {
      ProductionRunService.updateStatus(this.$route.params.id, 'Completed').then(() => { this.getRun(); });
    }
  }
}
</script>

<style>
.run-detail-container {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.run-detail-container .info {
  display: flex;
  justify-content: center;
  gap: 16px;
}

.run-detail-container .actions {
  display: flex;
  justify-content: center;
  gap: 16px;
}
</style>