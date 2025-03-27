<template>
  <div class="outer-container">
    <h1>Lennud</h1>
    <div class="container">
    <table>
      <thead>
          <tr>
            <th>Start</th>
            <th>Sihtkoht</th>
            <th>Väljumisaeg</th>
            <th>Kestvus</th>
            <th>Hind</th>
            <th>Vabu Kohte</th>
          </tr>
          </thead>
          <tbody>
      <tr v-for="lend in lennud" :key="lend.start + lend.sihtkoht">
        <td><v-th sortKey>{{ lend.start }}</v-th></td>
        <td>{{ lend.sihtkoht }}</td>
        <td>{{ lend.väljumisAeg }}</td>
        <td>{{ lend.lennuKestvus / 60 }} H</td>
        <td>{{ lend.hind }} $</td>
        <td>{{ vabadKohad(lend.istekohad) }}</td>
        <router-link :to="{ name: 'SeatPurchase', params: {kohad : JSON.stringify(lend.istekohad), hind: (lend.hind)} }">
              <button>Osta Pilet</button>
            </router-link>
      </tr>
    </tbody>
    </table>
  </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      lennud: [],
    }
  },
  mounted() {
    fetch("/api/lennud/lend")
    .then((response) => response.json())
    .then((data) => {
      console.log(data)
      this.lennud = data;
    })
  },
  methods: {
    vabadKohad(seats) {
      return seats.filter(seat => seat !== "X").length;
  }
 }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.container {
  padding: 90px;
  background-color: #f0f0f0;
  
}

h1 {
  justify-content: center;
  display: flex;
  padding: 15px;
  text-align: center;
  background-color: antiquewhite;
  border-radius: 15px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  font-size: 1.2em;
}

table {
  border-spacing: 15px;
  margin: auto;
  background-color: #ffffff;
  border-radius: 15px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

td {
  padding: 15px;
  margin: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 15px;
}

th {
  background-color: antiquewhite;
  padding: 25px;
  margin: 10px;
  text-align: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 15px;
}

button {
  margin-right: 10px;
  margin-top: 5px;
  padding: 5px 10px;
  cursor: pointer;
  background-color: antiquewhite;
  border-radius: 15px;
}

button:hover {
  background-color: gainsboro;
  transition: background-color 0.3s ease;
}

  
</style>
