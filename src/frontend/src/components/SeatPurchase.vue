<template>
  <nav>
    <router-link to="/">Tagasi</router-link>
  </nav>
  <h1>Vali soovitud kohad</h1>
    <div class="container">
      <div class="lõppInfo">
      <p>Valitud kohad ja lõpphind: </p>
      <div class="valitudKohad">
      <p v-for="(iste) in this.valitudKohad" :key="iste">{{ iste }}</p>
      </div>
      <p> Maksta: {{ hind * this.valitudKohad.length }} $</p>
    </div>
      <div class="Soovitused">
      <p>Istme Soovitused</p>
      <p>Akna ääres</p>
      <p>Väljapääsu poole</p>
      <p>Paaristool</p>
    </div>
      <table>
        <thead>
          <tr>
            <th>Kohad</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(koht, index) in paarisIstmed" :key="index">
            <td>
            <span v-if="!valitudKohad.includes(koht[0])" @click="handleClick(koht[0])">{{ koht[0] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[0])" >{{ koht[0] }}</span>

            <span v-if="!valitudKohad.includes(koht[1])" @click="handleClick(koht[1])">{{ koht[1] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[1])" >{{ koht[1] }}</span>
          </td>
          <td>
            <span v-if="!valitudKohad.includes(koht[2])" @click="handleClick(koht[2])">{{ koht[2] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[2])" >{{ koht[2] }}</span>

            <span v-if="!valitudKohad.includes(koht[3])" @click="handleClick(koht[3])">{{ koht[3] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[3])" >{{ koht[3] }}</span>
          </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  export default {
    name: 'SeatPurchase',
    data() {
      return {
        istekohad: this.$route.params.kohad || '[]',
        hind: this.$route.params.hind,
        valitudKohad: [],
      }
    },
    computed: {
      parsedIstekohad() {
        try {
          return JSON.parse(this.istekohad);
        } catch (e) {
          console.error('Failed to parse istekohad:', e);
          return [];
        }
      },
    paarisIstmed() {
            const istmed =  this.parsedIstekohad;
            const paarisKohad =  [];
            for (let i = 0; i < istmed.length; i += 4) {
        paarisKohad.push([istmed[i] || 'X', istmed[i + 1] || 'X', istmed[i + 2] || 'X', istmed[i + 3] || 'X']);
      }
            console.log(paarisKohad)
            return paarisKohad;
        }
      },
    mounted() {
      console.log(this.parsedIstekohad);
    },
    methods: {
      handleClick(seat) {
      if (seat === 'X') {
        alert('Koht on juba broneeritud!');
      } else {
        const index = this.valitudKohad.indexOf(seat);
        if (index === -1) {
          this.valitudKohad.push(seat);
        } else {
          this.valitudKohad.splice(index, 1);
        }
      }
    },

    }
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  
  .container {
  display: flex;
  justify-content: space-evenly;
  align-items: flex-start;
  padding: 30px;
  background-color: #f0f0f0;
  border-radius: 10px;
  box-shadow: 2 8px 16px rgba(0, 0, 0, 0.1);
}
 
 .lõppInfo {
  display: flex;
  flex-direction: column;
  padding: 20px;
  background-color: antiquewhite;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.valitudKohad {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 10px;
}

.Soovitused {
  display: flex;
  flex-direction: column;
  padding: 20px;
  background-color: antiquewhite;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

 p {
  margin: 5px;
  justify-content: center;
  display: flex;
  font-size: larger;
  font-weight: 600;
  
 }

 h1 {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
  font-size: 2em;
  color: #ffffff;
}

table {
  border-collapse: separate;
  border-spacing: 10px; 
}

  td {
    padding: 10px;
    background-color: #ffffff;
    border-radius: 15px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }

  th {
    border-spacing: 15px;
    padding: 10px;
    background-color: antiquewhite;
    border-radius: 15px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }

  span {
  
  padding: 15px;
  width: 20px;
  height: 20px;
  background-color: #f0f0f0;
  display: inline-block;
  text-align: center;
  cursor: pointer;
  transition: background-color 0.3s ease;
  border-radius: 15px;
}
  
  .võetud {
    background-color: antiquewhite;
    transition: 0.3s ease;
  }

  span:hover {
    background-color: gainsboro;
  }

  tbody {
    display: inline;
    justify-content:center;
    margin: auto;
  }

  nav {
  padding: 15px;
  text-align: center;
  background-color: antiquewhite;
  border-radius: 15px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

nav a {
  color: black;
  text-decoration: none;
  font-size: 1.2em;
}
  </style>
  