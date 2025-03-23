<template>
  <div>
    <h1>Flights</h1>
    <table>
      <li v-for="lend in lennud" :key="lend.start + lend.sihtkoht">
        <p><strong>From:</strong> {{ lend.start }}</p>
        <p><strong>To:</strong> {{ lend.sihtkoht }}</p>
        <p><strong>Date:</strong> {{ lend.väljumisAeg }}</p>
        <p><strong>Duration:</strong> {{ lend.lennuKestvus }} minutes</p>
        <p><strong>Price:</strong> ${{ lend.hind }}</p>
      </li>
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
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
