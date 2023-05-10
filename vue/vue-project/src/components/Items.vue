
<template>
  <div>
    <h3>
      <ul>
        <li v-for="item in items" :key="item.id">
          {{ item.name }} - {{ item.brand }}
        </li>
      </ul>
    </h3>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: []
    }
  },
  methods: {
    async getData() {
      const response = await fetch("http://localhost:8080/items");
      const data = await response.json();
      this.items = data;
    }
  },
  mounted() {
    this.getData();
  }
}
</script>

<style scoped>
h3 {
  font-size: 1.2rem;
}
</style>
