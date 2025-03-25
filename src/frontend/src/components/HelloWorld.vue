<template>
  <div>
    <h1>Lennud</h1>
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
        <td>{{ lend.start }}</td>
        <td>{{ lend.sihtkoht }}</td>
        <td>{{ lend.väljumisAeg }}</td>
        <td>{{ lend.lennuKestvus / 60 }} H</td>
        <td>{{ lend.hind }}</td>
        <td>{{ vabadKohad(lend.istekohad) }}</td>
        <button>Ostma</button>
      </tr>
    </tbody>
    </table>
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

</style>
