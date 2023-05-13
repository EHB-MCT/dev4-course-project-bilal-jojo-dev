<template>
    <div class="loan">
      <h2>Loan</h2>
      <form @submit.prevent="reserve">
        <div>
          <label for="startDate">Start Date:</label>
          <input type="date" id="startDate" v-model="startDate">
        </div>
        <button type="submit">Reserve</button>
        <p v-if="errorMessage">{{ errorMessage }}</p>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        startDate: '',
        errorMessage: ''
      }
    },
    methods: {
      reserve() {
        console.log('Reserving from start date:', this.startDate);
      }
    }
  }
  </script>
  
  
  