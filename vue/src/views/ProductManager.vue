<template>
  <div class="product-manager">
    <nav class="product-manager-nav">
      <ul>
        <li><a :class="{active:showCards}" @click="showCards = !showCards">Products</a></li>
        <li><a :class="{active:!showCards}" @click="showCards = !showCards">Runs</a></li>
      </ul>
    </nav>
    <!-- TODO: Toggle between operations divs. -->
    <div class="card-operations" v-if="showCards">
      <new-card v-on:update-cards="refreshCards" />
      <card-table :cards="cards" />
    </div>
    <div class="production-runs-operations" v-else>
      <new-production-run />
      <production-run-table :runs="$store.state.runs" />
    </div>
  </div>
</template>

<script>
import NewCard from '../components/NewCard.vue'
import CardTable from '../components/CardTable.vue'
import CardService from '../services/CardService.js'

import NewProductionRun from '../components/NewProductionRun.vue'
import ProductionRunTable from '../components/ProductionRunTable.vue'


export default {
  name: 'product-manager',
  components: {
    ProductionRunTable,
    NewCard,
    NewProductionRun,
    CardTable
  },
  data() {
    return {
      cards: [],
      showCards: true,
    }
  },
  created() {
    this.refreshCards();
    this.$store.dispatch('REFRESH_RUNS');
  },
  methods: {
    refreshCards() {
      CardService.list().then((response) => {
        this.cards = response.data;
      });
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

.card-operations {
  display: flex;
  align-items: flex-start;
  gap: 10px;
}

.production-runs-operations {
  display: flex;
  align-items: flex-start;
  gap: 10px;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}
</style>