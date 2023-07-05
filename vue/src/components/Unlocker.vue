<template>
  <div class="unlocker">
    <div class="unlocker-header">Unlock a Card</div>
    <div class="unlocker-success" v-show="success">Success!</div>
    <div class="unlocker-error" v-show="error">
      Invalid serial, please try again.
    </div>
    <form v-on:submit.prevent="getInstance()">
      <label>
        <input type="text" v-model="serial" />
      </label>
      <!-- Submit -->
      <label>
        <button type="submit">Submit</button>
      </label>
    </form>
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
  background-color: black;
  color: white;
  width: max-content;
  padding: 8px;
  border-radius: 8px;
}

.unlocker input {
  text-transform: uppercase;
}
</style>