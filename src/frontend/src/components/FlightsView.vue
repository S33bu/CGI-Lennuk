<template>
  <div class="outer-container">
    <h1>Lennud</h1>
    <div class="container">

      <div class="filtrid">
      <label>Start:</label>
      <input type="text" v-model="startFilter" placeholder="    Sisesta alguspunkt" />

      <label>Sihtkoht:</label>
      <input type="text" v-model="sihtkohtFilter" placeholder="    Sisesta sihtkoht" />

      <label>Kestvus:</label>
      <input type="number" v-model="maxKestvus" placeholder="    Sisesta max kestvus" />

      <label>Max Hind:</label>
      <input type="number" v-model="maxHind" placeholder="    Sisesta max hind" />
    </div>

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
      <tr v-for="lend in FilteredLennud" :key="lend.start + lend.sihtkoht">
        <td>{{ lend.start }}</td>
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
  name: 'FlightsView',
  data() {
    return {
      lennud: [],
      maxHind: null,
      sihtkohtFilter: "",
      startFilter: "",
      maxKestvus: null,
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
  computed: {
    //Funktsioon, mis teeb vajalikud ülevaatused vastavalt filtrite nõuetele ning väljastab tabelisse ainult need, mis on sobilikud
    FilteredLennud() {
      return this.lennud.filter(lend => {
        const kasHindSobib = this.maxHind ? lend.hind <= this.maxHind : true;
        const kasSihtkohtSobib = this.sihtkohtFilter ? lend.sihtkoht.toLowerCase().includes(this.sihtkohtFilter.toLowerCase()) : true;
        const kasStartSobib = this.startFilter ? lend.start.toLowerCase().includes(this.startFilter.toLowerCase()) : true;
        const kasKestvusSobib = this.maxKestvus ? lend.lennuKestvus/60 <= this.maxKestvus : true;
        return kasHindSobib && kasSihtkohtSobib && kasStartSobib && kasKestvusSobib;
      });
    }
  },
  methods: {
    //Arvutab välja mitu vaba kohta lennus on
    vabadKohad(seats) {
      return seats.filter(seat => seat !== "X").length;
  }
 }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.outer-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-gap: 20px;
  padding: 20px;
}

.container {
  padding: 90px;
  background-color: #f0f0f0;
  display: grid;
  grid-template-columns: 1fr;
  grid-gap: 20px;
  padding: 20px;
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
  overflow-x: auto;
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

.filtrid {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-right: 10px;
  margin-top: 15px;
  margin-bottom: 15px;
  padding: 5px 10px;
  cursor: pointer;
  background-color: #ffffff;
  border-radius: 15px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

label {
  background-color: antiquewhite;
  border-radius: 15px;
  margin-right: 5px;
}

input {
  margin-right: 20px;
  background-color: #ffffff;
  border-radius: 15px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  
}

  
</style>
