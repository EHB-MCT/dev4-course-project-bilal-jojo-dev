<template>
    <div>
      <h3>
        <ul>
          <li v-for="user in users" :key="user.id">
            {{ user.firstName }} - {{ user.email }}
          </li>
        </ul>
      </h3>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        users: []
      }
    },
    methods: {
      async getData() {
        const response = await fetch("http://localhost:8080/users");
        const data = await response.json();
        this.users = data;
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
  
  