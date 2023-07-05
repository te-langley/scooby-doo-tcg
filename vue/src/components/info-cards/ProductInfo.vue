<template>
  <div class="card">
    <h1>{{ card.name }}</h1>
    <h2>{{ card.occupation }}</h2>
    <h3>{{ card.species }}</h3>
    <div class="image">
      <img :src="imgPath" />
    </div>
    <div class="catchphrase">"{{ card.catchphrase }}"</div>
  </div>
</template>

<script>

export default {
  name: 'card',
  props: {
    card: Object
  },
  computed: {
    imgPath() {
      let imgFile = ''
      try {
        imgFile = require(`../../assets/images/${this.card.image}`)
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