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
        imgFile = require(`../assets/images/${this.card.image}`)
      } catch {
        imgFile = require('../assets/images/placeholder.png')
      }
      return imgFile
    }
  }
}
</script>

<style>
.card {
  display: flex;
  flex-direction: column;
}

a {
  text-decoration: none;
  color: inherit;
}

.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 350px;

  padding: 15px;

  background: #8e6345;

  background-clip: padding-box;

  box-shadow: inset 0 0 0 10px #adfb44;
}

.card h1 {
  font-size: 24px;
  margin: 0;
}

h2 {
  font-size: 18px;
  font-weight: normal;
  margin: 0;
  color: lightgrey;
}

h3 {
  font-size: 12px;
  font-weight: normal;
  margin: 0;
}

.image {
  display: flex;
  justify-content: center;
  margin: 5px;
}

img {
  border: 2px solid #adfb44;
}

.catchphrase {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>