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
        <div class="piletiteArv">
        <p>Vali kohtade arv</p>
        <br>
        <p><span class="resize" @click="eemaldaPilet">-</span>{{ piletiteArv }}<span class="resize" @click="lisaPilet">+</span></p>
        <br>
        <p class="makeButton" @click="soovitaKohti">Soovita meile kohti!</p>
        <div v-if="soovitatudKohad.length">
          <p>Soovitatud kohad:</p>
          <p v-for="(koht, index) in soovitatudKohad" :key="index">{{ koht }}</p>
        </div>
      </div>
      <hr>
      <br>
      <p>Spetsiifilsemad soovitused</p>
      <p class="makeButton" @click="aknaäärsedKohad">Akna ääres </p>
      <div v-if="aknapoolsedKohad.length">
          <p>Soovitatud kohad:</p>
          <p v-for="(koht, index) in aknapoolsedKohad" :key="index">{{ koht }}</p>
        </div>
        <br>
      <p class="makeButton" @click="väljapääsuKohad">Väljapääsu poole</p>
      <div v-if="väljapääsupoolsedKohad.length">
          <p>Soovitatud kohad:</p>
          <p v-for="(koht, index) in väljapääsupoolsedKohad" :key="index">{{ koht }}</p>
        </div>
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
            <span v-if="!valitudKohad.includes(koht[0])" 
            @click="handleClick(koht[0])" 
            :class="{'soovitatud-koht': soovitatudKohad.includes(koht[0]) || aknapoolsedKohad.includes(koht[0]) || väljapääsupoolsedKohad.includes(koht[0])}"
            >{{ koht[0] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[0])" >{{ koht[0] }}</span>

            <span v-if="!valitudKohad.includes(koht[1])"
             @click="handleClick(koht[1])" 
             :class="{'soovitatud-koht': soovitatudKohad.includes(koht[1]) || aknapoolsedKohad.includes(koht[1]) || väljapääsupoolsedKohad.includes(koht[1])}"
            >{{ koht[1] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[1])" >{{ koht[1] }}</span>

            <span v-if="!valitudKohad.includes(koht[2])"
             @click="handleClick(koht[2])"
             :class="{'soovitatud-koht': soovitatudKohad.includes(koht[2]) || aknapoolsedKohad.includes(koht[2]) || väljapääsupoolsedKohad.includes(koht[2])}"
             >{{ koht[2] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[2])" >{{ koht[2] }}</span>
          </td>
          <!--et tekiks n.ö vahekäik istmete vahele-->
          <td>
            <span v-if="!valitudKohad.includes(koht[3])"
             @click="handleClick(koht[3])"
             :class="{'soovitatud-koht': soovitatudKohad.includes(koht[3]) || aknapoolsedKohad.includes(koht[3]) || väljapääsupoolsedKohad.includes(koht[3])}"
             >{{ koht[3] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[3])" >{{ koht[3] }}</span>

            <span v-if="!valitudKohad.includes(koht[4])"
             @click="handleClick(koht[4])"
             :class="{'soovitatud-koht': soovitatudKohad.includes(koht[4]) || aknapoolsedKohad.includes(koht[4]) || väljapääsupoolsedKohad.includes(koht[4])}"
             >{{ koht[4] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[4])" >{{ koht[4] }}</span>

            <span v-if="!valitudKohad.includes(koht[5])"
             @click="handleClick(koht[5])"
             :class="{'soovitatud-koht': soovitatudKohad.includes(koht[5]) || aknapoolsedKohad.includes(koht[5]) || väljapääsupoolsedKohad.includes(koht[5])}"
             >{{ koht[5] }}</span>
            <span v-else class="võetud" @click="handleClick(koht[5])" >{{ koht[5] }}</span>
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
        piletiteArv: 0,
        soovitatudKohad: [],
        aknapoolsedKohad: [],
        väljapääsupoolsedKohad: [],
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
      //Funktsioon selleks, et mugavamalt üles ehitada istmekohtade visualiseerimist
      //Nimetus paarisistmed, sest tegin algselt 3+3 toolide asemel 2+2
      paarisIstmed() {
            const istmed =  this.parsedIstekohad;
            const paarisKohad =  [];
            for (let i = 0; i < istmed.length; i += 6) {
        paarisKohad.push([istmed[i] || 'X', istmed[i + 1] || 'X',
                            istmed[i + 2] || 'X', istmed[i + 3] || 'X',
                              istmed[i + 4] || 'X', istmed[i + 5] || 'X']);
      }
            console.log(paarisKohad)
            return paarisKohad;
        },
      
      },
    mounted() {
      console.log(this.parsedIstekohad);
    },
    methods: {
      //funktsioon, mille abil on näha valitud istmekohti
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
    //otsib välja sobilikud aknaäärsed istmed vastavalt valitud kohtade arvule
    //Täidab listi kõikide sobilike istmetega ning lõpus valib neist juhusliku
    aknaäärsedKohad(){
        const istmed = this.parsedIstekohad
        const aknaäärsed = []
        this.aknapoolsedKohad = []
        for (let i = 0; i < istmed.length; i+=6){
          if (istmed[i] != "X"){
            aknaäärsed.push(istmed[i])
          }
          if (istmed[i+5] != "X") {
            aknaäärsed.push(istmed[i+5])
          }
        }
        for (let i=1; i <= this.piletiteArv; i++){
          const randomElement = aknaäärsed[Math.floor(Math.random() * aknaäärsed.length)];
          this.aknapoolsedKohad.push(randomElement)
        }
        this.soovitatudKohad = [];
        this.väljapääsupoolsedKohad = [];
        },
        //otsib välja sobilikud väljapääsupoolsed istmed vastavalt valitud kohtade arvule
        //Täidab listi kõikide sobilike istmetega ning lõpus valib neist juhusliku
      väljapääsuKohad() {
        const istmed = this.parsedIstekohad
        const väljapääsuÄÄrsed = []
        this.väljapääsupoolsedKohad = []
        for (let i = 0; i < istmed.length; i+=6){
          if (istmed[i+2] != "X"){
            väljapääsuÄÄrsed.push(istmed[i+2])
          }
          if (istmed[i+3] != "X") {
            väljapääsuÄÄrsed.push(istmed[i+3])
          }
        }
          for (let i=1; i <= this.piletiteArv; i++){
          const randomElement = väljapääsuÄÄrsed[Math.floor(Math.random() * väljapääsuÄÄrsed.length)];
          this.väljapääsupoolsedKohad.push(randomElement)
        }
        this.soovitatudKohad = [];
        this.aknapoolsedKohad = [];
      },
      lisaPilet() {
        this.piletiteArv += 1;
      },
      eemaldaPilet () {
        if (this.piletiteArv != 0){
          this.piletiteArv -= 1;
        }
      },
      //Soovitab vastavalt valitud piletite arvule istmekohti 
      //Täidab listi kõikide sobilike järjestikuste istmetega ning lõpus valib neist juhusliku
      soovitaKohti(){
        const istmed = this.parsedIstekohad
        const sobivad_kohad = []
        for (let i=0; i < istmed.length; i++){
          const temp = []
          for (let j=0; j < this.piletiteArv; j++){
            temp.push(istmed[i+j])
          }
          if (temp.includes("X")){
            i+=1
          }else{
            sobivad_kohad.push(temp)
          }
        }
        if (sobivad_kohad.length > 0){
          const randomElement = sobivad_kohad[Math.floor(Math.random() * sobivad_kohad.length)];
          this.soovitatudKohad = randomElement
        } else{
          alert("Ei leia sobivaid järjestikuseid kohti nii paljudele :(")
        }
        this.aknapoolsedKohad = [];
        this.väljapääsupoolsedKohad = [];
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

.piletiteArv {
  justify-content: center;
  padding: 15px;
  margin: 10px;
  gap: 10px;
}


button {
  justify-content: center;
}

 p {
  margin: 5px;
  justify-content: center;
  display: flex;
  font-size: larger;
  font-weight: 600;
  
 }

li {
  padding: 5px;
  margin: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  background-color: #ffffff;
  border-radius: 15px;
  justify-content: center;
}

 h1 {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
  font-size: 2em;
  color: black;
  text-align: center;
  background-color: antiquewhite;
  padding: 15px;
  border-radius: 15px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  font-size: 1.2em;
  margin-top: 30px;
  margin-bottom: 30px;
}

table {
  border-collapse: separate;
  border-spacing: 20px 
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
    border: black;
    transition: 0.3s ease;
  }

  .resize {
    padding: 5px;
    background-color: #ffffff;
    transition: 0.3s ease;
    transform: translateY(-5px);
    margin-left: 10px;
    margin-right: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }

  .makeButton {
    background-color: #ffffff;
    transition: 0.3s ease;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 15px;
    padding: 10px;
  }

  .makeButton:hover {
    background-color: #f0f0f0;
    cursor: grab;
  }

  .soovitatud-koht {
  background-color: lightgreen;
  border: 2px solid green;
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
  position:fixed;
}

  nav:hover {
    background-color: #f0f0f0;
    transition: 0.3s ease;
  }

nav a {
  color: black;
  text-decoration: none;
  font-size: 1.2em;
}
  </style>
  