<template>
    <div>
      <h1>Istekohad</h1>
      <table>
        <thead>
          <tr>
            <th>Seat</th>
          </tr>
        </thead>
        <tbody>
            <tr v-for="(pair, index) in paarisIstmed" :key="index">
          <td>{{ pair[0] }}</td>
          <td v-if="pair[1]">{{ pair[1] }}</td>
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
      }
    },
    mounted() {
      console.log(this.parsedIstekohad);
    },
    methods: {
        paarisIstmed() {
            const istmed =  this.parsedIstekohad;
            const paarisKohad =  [];
            for (let i = 0; i < istmed.length; i+2){
                const temp = [];
                temp.push(istmed[i], istmed[i+1]);
            }
            return paarisKohad;
        }
    }
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  
  </style>
  