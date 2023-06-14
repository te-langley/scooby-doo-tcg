<template>
  <nav class="product-manager-nav">
    <ul>
      <li>
        <a
          :class="{ active: selectedDiv === 'products' }"
          @click="show('products')"
        >
          Products
        </a>
      </li>
      <li>
        <a
          :class="{ active: selectedDiv === 'runs' }"
          @click="show('runs')"
        >
          Runs
        </a>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'admin-nav',
  data() {
    return {
      selectedDiv: 'products'
    }
  },
  methods: {
      show(div) {
          this.selectedDiv = div;
          this.$emit('div-selected', this.selectedDiv);
      }
  }
}
</script>

<style>
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
  background-color: #04aa6d;
}
</style>