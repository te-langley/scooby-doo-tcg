<template>
  <div class="run-detail-container">
    <div class="info">
      <card :card="card" />
      <production-run :run="run" />
    </div>
    <div class="actions">
      <button v-if="canCancelRun" @click="cancelRun">Cancel</button>
      <button v-if="canAcceptRun" @click="acceptRun">Accept</button>
      <button v-if="canCompleteRun" @click="completeRun">Complete</button>
    </div>
  </div>
</template>

<script>
import Card from '../components/info-cards/ProductInfo.vue'
import CardService from '../services/CardService'

import ProductionRun from '../components/info-cards/RunInfo.vue'
import ProductionRunService from '../services/ProductionRunService'

import InstanceService from '../services/InstanceService'

export default {
  name: 'run-detail',
  components: {
    Card,
    ProductionRun,
  },
  data() {
    return {
      card: {},
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
        CardService.get(this.run.productCode).then((response) => {
          this.card = response.data;
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