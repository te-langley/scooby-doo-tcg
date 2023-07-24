<template>
  <div class="instance-card">
    <dl>
      <dt>Instance</dt>
      <dd> {{instance.serial}} </dd>

      <dt>Product Code</dt>
      <dd>{{ instance.productCode }}</dd>

      <dt>Run ID</dt>
      <dd>{{ instance.productionRun }}</dd>

      <dt>Sequence</dt>
      <dd>{{ instance.sequence }}</dd>

      <dt>Claimed</dt>
      <dd>{{ instance.claimed }}</dd>
    </dl>
  </div>
</template>

<script>
export default {
  name: 'instance-ui',
  props: {
    instance: Object
  },
}
</script>

<style>
.instance-card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 350px;
  padding: 15px;
  background: #8e6345;
  background-clip: padding-box;
  box-shadow: inset 0 0 0 10px #adfb44;
}

.instance-card dl {
  display: block;
  margin: 0;
}

.instance-card dt {
  float: left;
  width: 50%;
  margin-bottom: 0.2em;
  font-weight: bold;
  border-bottom: 1px solid;
}

.instance-card dd {
  float: right;
  width: 50%;
  margin-left: 0px;
  margin-bottom: 0.2em;
  border-bottom: 1px solid;
  text-align: right;
}

.instance-card dt:first-child {
  float: left;
  width: unset;
  margin-bottom: 0.4em;
  font-size: 1.8em;
  border-bottom: unset;
}

.instance-card dt:first-child + dd {
  float: right;
  width: unset;
  margin-bottom: 0.4em;
  font-size: 1.8em;
  font-weight: bold;
  border-bottom: unset;
}

.instance-card dt.dt-short {
    width: 35%;
}

.instance-card dd.dd-long {
  float: left;
  width: 65%;
  border-bottom: unset;
}
</style>