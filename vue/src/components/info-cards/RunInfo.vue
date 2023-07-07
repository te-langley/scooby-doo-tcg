<template>
  <div class="dl-card">
    <dl>
      <dt>Production Run</dt>
      <!-- <dd>{{ run.runCode }}</dd> -->
      <dt>Run ID</dt>
      <dd>{{ run.runCode }}</dd>
      <dt>Date</dt>
      <dd>{{ run.productionDate }}</dd>
      <dt>Volume</dt>
      <dd>{{ run.volume }}</dd>
      <dt>Status</dt>
      <dd>{{ run.status }}</dd>
      <dt class="dt-short">Notes</dt>
      <dd class="dd-long">{{ run.notes }}</dd>
    </dl>    
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
.dl-card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 350px;
  padding: 15px;
  background: #8e6345;
  background-clip: padding-box;
  box-shadow: inset 0 0 0 10px #adfb44;
}

dl {
  display: block;
  margin: 0;
}

dt {
  float: left;
  width: 50%;
  margin-bottom: 0.2em;
  font-weight: bold;
  border-bottom: 1px solid;
}

dd {
  float: right;
  width: 50%;
  margin-left: 0px;
  margin-bottom: 0.2em;
  border-bottom: 1px solid;
  text-align: right;
}

dt:first-child {
  float: left;
  width: unset;
  margin-bottom: 0.4em;
  font-size: 1.8em;
  border-bottom: unset;
}

dt:first-child + dd {
  float: right;
  width: unset;
  margin-bottom: 0.4em;
  font-size: 1.8em;
  font-weight: bold;
  border-bottom: unset;
}

dt.dt-short {
    width: 35%;
}

dd.dd-long {
  float: left;
  width: 65%;
  border-bottom: unset;
}
</style>