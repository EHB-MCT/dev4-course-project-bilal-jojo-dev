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
    }
  },
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
  padding: 20px 0 20px 0;
  background-color: #f9f9f9;
  box-sizing: border-box;
}

.login input {
  width: 100%;
  margin: 12px 0;
  padding: 12px 6px;
  font-size: 16px;
}

.login button {
  margin-top: 10px;
  border: none;
  background-color: cornflowerblue;
  color: #eee;
  padding: 12px 24px;
  font-size: 16px;
}
</style>
  