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
      token: '0e0764b3-d171-4868-a845-d031a73ddbeb'
    }
  },
  methods: {
    async login() {
      try {
        const response = await fetch('http://localhost:8080/users/login', {
          method: 'POST',
          headers: {
            'Authorization': this.token,
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

        localStorage.setItem('authToken', data);

        this.$router.push('/items');
      } catch (error) {
        this.errorMessage = 'Er is een fout opgetreden bij het inloggen. Controleer uw e-mail en wachtwoord en probeer het opnieuw.';
        console.error('Er is een fout opgetreden bij het inloggen:', error);
      }
    },
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
  