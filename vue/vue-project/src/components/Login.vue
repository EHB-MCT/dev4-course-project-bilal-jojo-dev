<template>
    <div class="login">
      <h2>Login</h2>
      <form @submit.prevent="submitForm">
        <div>
          <label for="mail">Mail:</label>
          <input type="text" id="mail" v-model="mail">
        </div>
        <div>
          <label for="password">Password:</label>
          <input type="password" id="password" v-model="password">
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        mail: '',
        password: '',
      }
    },
    methods: {
      submitForm() {
        console.log('Form submitted:', { mail: this.mail, password: this.password });
      }
    }
  }
  </script>
  
  <style scoped>
  .login {
    width: 300px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    background-color: #f9f9f9;
  }
  
  .login input {
    width: 100%;
    margin: 5px 0;
  }
  
  .login button {
    margin-top: 10px;
  }
  </style>
  