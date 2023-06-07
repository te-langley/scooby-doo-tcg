<template>
  <div class="new-production-run-container">
    <div class="new-production-run-header">Add New Production Run</div>
    <form>
      <!-- Id -->
      <!-- TODO: Display next ID? -->

      <!-- Product Code -->
      <label>
        <span>Product Code <span class="required">*</span></span>
        <select class="select-field" v-model="run.productCode">
          <option v-for="card in cards" :key="card.id" :value="card.id">
            {{ card.id }} ({{ card.name }})
          </option>
        </select>
      </label>

      <!-- Date -->
      <label>
        <span>Date <span class="required">*</span></span>
        <input type="date" class="input-field" v-model="run.productionDate" />
      </label>

      <!-- Quantity -->
      <label>
        <span>Quantity <span class="required">*</span></span>
        <input type="number" class="input-field" v-model="run.quantity" />
      </label>

      <!-- Status -->
      <label>
        <span>Status <span class="required">*</span></span>
        <input type="text" class="input-field" v-model="run.status" />
      </label>

      <!-- Notes -->
      <label>
        <span>Notes <span class="required">*</span></span>
        <textarea
          cols="30"
          rows="2"
          class="textarea-field"
          v-model="run.notes"
        ></textarea>
      </label>

      <!-- Submit -->
      <label>
        <button type="submit" v-on:click="submitNewProductionRun()">
          Submit
        </button>
      </label>
    </form>
  </div>
</template>

<script>
import cardService from '../services/CardService.js'
import productionRunService from '../services/ProductionRunService.js'
export default {
  data() {
    return {
      cards: [],
      run: {
        productCode: '',
        productionDate: '',
        quantity: '',
        status: '',
        notes: ''
      }
    }
  },
  created() {
    cardService.list().then((response) => {
      this.cards = response.data;
    })
  },
  methods: {
    submitNewProductionRun() {
      productionRunService.post(this.run).then((response) => {
        if (response.status == 200) {
          this.$router.push({ name: 'product-manager' });
        }
      })
    }
  }

}
</script>

<style>
.new-production-run-container {
  max-width: 500px;
  padding: 20px 12px 10px 20px;
  border: 2px solid var(--kingston-mansion-lawn);
  border-radius: 10px;
  background-color: var(--kingston-mansion-purple);
  color: var(--kingston-mansion-black);
}

.new-production-run-header {
  font-size: 1.5em;
  font-style: italic;
  border-bottom: 2px solid var(--kingston-mansion-lawn);
  margin-bottom: 20px;
  padding-bottom: 3px;
}

.new-production-run-container label {
  display: block;
  margin: 0px 0px 15px 0px;
}

.new-production-run-container label > span {
  width: 150px;
  float: left;
  padding-top: 8px;
  padding-right: 5px;
}

.new-production-run-container span.required {
  color: red;
}

.new-production-run-container .input-field,
.new-production-run-container .select-field,
.new-production-run-container .textarea-field {
  width: 48%;
  box-sizing: border-box;
  border: 1px solid #c2c2c2;
  border-radius: 3px;
  padding: 8px;
  outline: none;
}

.new-production-run-container .input-field:focus,
.new-production-run-container .select-field:focus {
  border: 1px solid #0c0;
}

.new-production-run-container button[type="submit"] {
  border: none;
  padding: 8px 15px 8px 15px;
  background: var(--kingston-mansion-moon);
  color: var(--kingston-mansion-sky);
  border-radius: 3px;
}

.new-production-run-container button[type="submit"]:hover {
  background: var(--kingston-mansion-sky);
  color: var(--kingston-mansion-moon);
}
</style>