<template>
  <div class="new-card-container">
    <div class="new-card-header">Add New Card to Catalog</div>
    <form v-on:submit.prevent="saveCard()">
      <!-- Id -->
      <!-- TODO: Should be able to manually select unused ID. -->

      <!-- Name -->
      <label>
        <span>Name <span class="required">*</span></span>
        <input type="text" class="input-field" v-model="card.name" />
      </label>

      <!-- Species -->
      <label>
        <span>Species <span class="required">*</span></span>
        <input type="text" class="input-field" v-model="card.species" />
      </label>

      <!-- Occupation -->
      <label>
        <span>Occupation <span class="required">*</span></span>
        <input type="text" class="input-field" v-model="card.occupation" />
      </label>

      <!-- Catchphrase -->
      <label>
        <span>Catchphrase <span class="required">*</span></span>
        <input type="text" class="input-field" v-model="card.catchphrase" />
      </label>

      <!-- Image -->
      <label>
        <span>Image <span class="required">*</span></span>
        <input class="file-field" type="file" />
      </label>

      <!-- Submit -->
      <label>
        <button type="submit">Submit</button>
      </label>
    </form>
  </div>
</template>

<script>
import cardService from "../services/CardService.js";
export default {
  name: "new-card",
  data() {
    return {
      card: {
        name: '',
        species: '',
        occupation: '',
        catchphrase: '',
        image: ''
      }
    }
  },
  methods: {
    saveCard() {
      cardService.post(this.card).then((response) => {
        if (response.status == 200) {
          location.reload();
        }
      })
    }
  }
}
</script>

<style>
.new-card-container {
  padding: 20px 12px 10px 20px;
  border: 2px solid var(--kingston-mansion-lawn);
  border-radius: 10px;
  background-color: var(--kingston-mansion-purple);
  color: var(--kingston-mansion-black);
  flex: 0 0 content;
}

.new-card-header {
  font-size: 1.5em;
  font-style: italic;
  border-bottom: 2px solid var(--kingston-mansion-lawn);
  margin-bottom: 20px;
  padding-bottom: 3px;
}

.new-card-container label {
  display: block;
  margin: 0px 0px 15px 0px;
}

.new-card-container label > span {
  width: 150px;
  float: left;
  padding-top: 8px;
  padding-right: 5px;
}

.new-card-container span.required {
  color: red;
}

.new-card-container input.input-field,
.new-card-container .file-field {
  width: 48%;
}

.new-card-container input.input-field {
  box-sizing: border-box;
  border: 1px solid #c2c2c2;
  border-radius: 3px;
  padding: 8px;
  outline: none;
}

.new-card-container .input-field:focus {
  border: 1px solid var(--mystery-machine-green);
}

.new-card-container button[type="submit"] {
  border: none;
  padding: 8px 15px 8px 15px;
  background: var(--kingston-mansion-moon);
  color: var(--kingston-mansion-sky);
  border-radius: 3px;
}

.new-card-container button[type="submit"]:hover {
  background: var(--kingston-mansion-sky);
  color: var(--kingston-mansion-moon);
}
</style>