<template>
  <nav class="product-manager-nav">
    <ul>
      <li>
        <a :class="{ active: showCards }" @click="showCards = !showCards">
          Products
        </a>
      </li>
      <li>
        <a :class="{ active: !showCards }" @click="showCards = !showCards">
          Runs
        </a>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {

}
</script>

<style>
</style>