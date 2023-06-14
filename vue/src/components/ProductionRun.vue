<template>
  <div class="run-ui">
    <div class="run-ui-header">Production Run Info</div>
    <div class="run-ui-info">
      <span class="info-title">Run Code:</span> {{ run.runCode }}
    </div>
    <div class="run-ui-info">
      <span class="info-title">Product Code:</span> {{ run.productCode }}
    </div>
    <div class="run-ui-info">
      <span class="info-title">Date:</span> {{ run.productionDate }}
    </div>
    <div class="run-ui-info">
      <span class="info-title">Volume:</span> {{ run.volume }}
    </div>
    <div class="run-ui-info">
      <span class="info-title">Status:</span> {{ run.status }}
    </div>
    <div class="run-ui-info">
      <span class="info-title">Notes:</span> {{ run.notes }}
    </div>
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
.run-ui {
  background-color: white;
}

span.info-title {
    background-color: pink;
  width: 550px;
}
</style>