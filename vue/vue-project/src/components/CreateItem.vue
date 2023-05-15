<template>
    <div>
      <form @submit.prevent="createItem">
        <label for="name">Item Name:</label>
        <input type="text" id="name" v-model="name">
  
        <label for="brand">Item Brand:</label>
        <input type="text" id="brand" v-model="brand">
  
        <button type="submit">Create Item</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        name: '',
        brand: '',
      }
    },
    methods: {
        async createItem() {
  try {
    const response = await fetch('http://localhost:8080/items', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        name: this.name,
        brand: this.brand,
      }),
    });

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();
    console.log(data);  
  } catch (error) {
    console.error('Error:', error);
  }
},
    },
  }
  </script>