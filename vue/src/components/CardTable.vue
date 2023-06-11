<template>
  <div class="card-table-container">
    <div class="card-table-header">Card Catalog (Table Format)</div>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Card Name</th>
          <th>Occupation</th>
          <th>Species</th>
          <th>Catchphrase</th>
          <th>Image (Filename)</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="card in cards" :key="card.productCode">
          <td>{{ card.productCode }}</td>
          <td>{{ card.name }}</td>
          <td>{{ card.occupation }}</td>
          <td>{{ card.species }}</td>
          <td>{{ card.catchphrase }}</td>
          <td>{{ card.image }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'card-table',
  props: {
    cards: Array
  }
}
</script>

<style>
.card-table-container {
  padding: 8px 16px;
  border: 2px solid var(--kingston-mansion-lawn);
  border-radius: 10px;
  background-color: var(--kingston-mansion-purple);
  color: var(--kingston-mansion-black);
}

.card-table-header {
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