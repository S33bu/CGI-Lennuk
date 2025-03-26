<template>
  <nav>
    <router-link to="/">Tagasi</router-link>
  </nav>
  <h1>Vali soovitud kohad</h1>
  <p>Valitud kohad ja lõpphind: </p>
   <p> {{ hind }} $</p>
    <div class="container">
      <table>
        <thead>
          <tr>
            <th>Kohad</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(pair, index) in paarisIstmed" :key="index">
            <td>
            <span @click="handleClick(pair[0])">{{ pair[0] }}</span>
            <span @click="handleClick(pair[1])">{{ pair[1] }}</span>
          </td>
          <td>
            <span @click="handleClick(pair[2])">{{ pair[2] }}</span>
            <span @click="handleClick(pair[3])">{{ pair[3] }}</span>
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
      alert(`Koht ${seat} valitud!`);
    }
    }
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  
  .container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 80vh; /* Full viewport height */
 }

 p {
  display: flex;
  align-items: right;
  justify-content: right;
 }

 h1 {
  display: flex;
  align-items: center;
  justify-content: center;
 }

 table {
  border-collapse: collapse;
}

  td {
    padding: 10px;
  }

  span {
    padding: 10px;
    width: 20px;
    height: 20px;
    background-color: gray;
    justify-content: center;
    display: inline-block;
    text-align: center;
    cursor: pointer;
    transition: background-color 0.3s ease;
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
  background-color: #e0e0e0;
  justify-content: center;
  text-align: center;
  text-decoration: none;
}
  </style>
  