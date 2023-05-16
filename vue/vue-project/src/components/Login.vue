<template>
  <div class="login">
    <h2>Login</h2>
    <form @submit.prevent="login">
      <div>
        <label for="mail">Mail:</label>
        <input type="text" id="mail" v-model="mail">
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password">
      </div>
      <button type="submit">Login</button>
      <p v-if="errorMessage">{{ errorMessage }}</p>
      <router-link to="/register"><button>Register account</button></router-link>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      mail: '',
      password: '',
      errorMessage: '',
      authToken: ''
  }},
  methods: {
    async login() {
      try {
        const response = await fetch('http://localhost:8080/users/login', {
          method: 'POST',
          headers: {
            'Authorization': this.authToken,
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            email: this.mail,
            password: this.password,
          }),
        });

        if (!response.ok) {
          throw new Error('Inloggen mislukt');
        }

        const data = await response.text();

        this.authToken = data;
        console.log(data)
        localStorage.setItem('authToken', this.authToken);
        console.log(localStorage)

        this.$router.push('/items');
      } catch (error) {
        this.errorMessage = 'Er is een fout opgetreden bij het inloggen. Controleer uw e-mail en wachtwoord en probeer het opnieuw.';
        console.error('Er is een fout opgetreden bij het inloggen:', error);
      }
    }
  },
  mounted() {
    this.authToken = localStorage.getItem('authToken');
    console.log('Access token: ' , this.authToken)
  }
}
</script>

<style scoped>
.login {
  width: 100%;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #00BCD4;
  background-color: #E0F7FA;
  border-radius: 10px;
}

.login h2 {
  text-align: center;
  color: #00BCD4;
}

.login .input-field {
  position: relative;
  margin: 20px 0;
}

.login .input-field label {
  position: absolute;
  top: -20px;
  left: 0;
  color: #00BCD4;
}

.login input {
  width: 100%;
  padding: 10px;
  box-sizing: border-box;
  border-radius: 5px;
  border: 1px solid #00BCD4;
}

.login input:focus {
  outline: none;
  border-color: #0097A7;
}

.login button {
  display: block;
  width: 100%;
  padding: 10px;
  margin-top: 30px;
  background-color: #00BCD4;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.login button:hover {
  background-color: #0097A7;
}

.login p {
  color: #F44336;
  text-align: center;
  margin-top: 20px;
}

</style>
  