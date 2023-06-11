<template>
  <div class="manage-products">
      <new-card v-on:update-cards="refreshCards" />
      <card-table :cards="cards" />
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>