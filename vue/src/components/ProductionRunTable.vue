<template>
  <div class="production-run-table-container">
    <div class="production-run-table-header">
      Production Runs (Table Format)
    </div>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Product Code</th>
          <th>Date</th>
          <th>Quantity</th>
          <th>Status</th>
          <th>Notes</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="run in runs" :key="run.id">
          <td>{{ run.id }}</td>
          <td>{{ run.productCode }}</td>
          <td>{{ run.productionDate }}</td>
          <td>{{ run.quantity }}</td>
          <td>{{ run.status }}</td>
          <td>{{ run.notes }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

export default {
  name: 'production-run-table',
  props: {
      runs: Array
  }
}
</script>

<style>
.production-run-table-container {
  padding: 8px 16px;
  border: 2px solid var(--kingston-mansion-lawn);
  border-radius: 10px;
  background-color: var(--kingston-mansion-purple);
  color: var(--kingston-mansion-black);
  /* flex: 1 0 auto; */
}

.production-run-table-header {
  font-size: 1.5em;
  margin-bottom: 8px;
}

table,
th,
td {
  border-collapse: collapse;
  border: 1px solid;
  border-color: black;
}

th,
td {
  padding: 8px;
}

tr:nth-child(odd) {
  background-color: gray;
}
</style>