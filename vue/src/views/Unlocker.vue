<template>
  <div class="unlocker">
    <div class="unlocker-header">Unlock a Card</div>
    <div class="unlocker-error" v-show="error">
      Invalid serial, please try again.
    </div>
    <div class="unlocker-form">
      <form v-on:submit.prevent="getInstance()">
        <label>
          <input type="text" v-model="serial" placeholder="Serial Number" />
        </label>
        <!-- Submit -->
        <label>
          <button type="submit">Submit</button>
        </label>
      </form>
    </div>
  </div>
</template>

<script>
import InstanceService from '../services/InstanceService'

export default {
  name: 'unlocker',
  data() {
    return {
      error: false,
      success: false,
      serial: ''
    }
  },
  methods: {
    getInstance() {
      InstanceService.getInstance(this.serial).then((response) => {
        if (response.status == 200) {
          this.error = false;
          this.success = true;
          this.$router.push({ name: 'instance', params: { serial: this.serial } });
        }
      }).catch((error) => {
        if (error.response.status == 404) {
          this.error = true;
          this.success = false;
        }
      });
    }
  }

}
</script>

<style>
.unlocker {
  width: 100%;
  height: 100%;
  background-color: rgb(92, 82, 109, 0.5);
  /* display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center; */

  color: white;
  padding: 8px;
  border-radius: 8px;
}

.unlocker-header {
  width: fit-content;
  margin: 0 auto 1em;
  font-size: 1.5em;
}

.unlocker-error {
  width: fit-content;
  margin: auto;
  color: red;
}

.unlocker-form {
  width: fit-content;
  margin: auto;
}

.unlocker-form input {
  text-transform: uppercase;
  background-color: var(--kingston-mansion-purple);
  color: white;
  height: 32px;
  border: none;
  border-top-left-radius: 16px;
  border-bottom-left-radius: 16px;
  text-align: center;
}
.unlocker-form input:focus {
  outline: none;
}

.unlocker-form input::placeholder {
  text-transform: none;
}

.unlocker-form button {
  background-color: var(--kingston-mansion-black);
  height: 32px;
  border: none;
  border-top-right-radius: 16px;
  border-bottom-right-radius: 16px;
  color: white;
  padding: 0 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  cursor: pointer;
}
</style>