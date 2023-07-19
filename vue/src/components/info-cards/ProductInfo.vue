<template>
  <div class="card">
    <h1>{{ product.name }}</h1>
    <h2>{{ product.occupation }}</h2>
    <h3>{{ product.species }}</h3>
    <div class="image">
      <img :src="imgPath" />
    </div>
    <div class="catchphrase">"{{ product.catchphrase }}"</div>
  </div>
</template>

<script>

export default {
  name: 'product',
  props: {
    product: Object
  },
  computed: {
    imgPath() {
      let imgFile = ''
      try {
        imgFile = require(`../../assets/images/${this.product.image}`)
      } catch {
        imgFile = require('../../assets/images/placeholder.png')
      }
      return imgFile
    }
  }
}
</script>

<style>


.catchphrase {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>