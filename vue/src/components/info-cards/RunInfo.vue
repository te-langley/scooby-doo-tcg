<template>
  <div class="card">
    <h1>Production Run</h1>
    <h2>Run Code: {{ run.runCode }}</h2>
    <div>Product Code:{{ run.productCode }}</div>
    <div>Date: {{ run.productionDate }}</div>
    <div>Volume: {{ run.volume }}</div>
    <div>Status: {{ run.status }}</div>
    <div>Notes: {{ run.notes }}</div>
  </div>
</template>

<script>
export default {
  name: 'run-ui',
  props: {
    run: Object
  },
}
</script>

<style>
</style>