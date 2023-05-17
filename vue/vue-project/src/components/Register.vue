<template>
    <div class="login">
        <h2>Register</h2>
        <form @submit.prevent="register">
            <div>
                <label for="firstName">First Name</label>
                <input type="text" id="firstName" v-model="firstName">
            </div>
            <div>
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" v-model="lastName">
            </div>
            <div>
                <label for="mail">Email</label>
                <input type="text" id="mail" v-model="email">
            </div>
            <div>
                <label for="password">Password</label>
                <input type="text" id="password" v-model="password">
            </div>
            <div>
                <label for="phoneNr">Phone Number</label>
                <input type="number" id="phoneNr" v-model="phoneNr">
            </div>
            <button type="submit">Login</button>
        </form>
    </div>
</template>

<script>

export default {
    data() {
        return {
            firstName: '',
            lastName: '',
            email: '',
            password: '',
            phoneNr: '',
            access_token: '',

            role: 'student'
        }},
        methods: {
            async register() {
                try {
                    await fetch('http://localhost:8080/users', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        }, 
                        body: JSON.stringify({
                            firstName: this.firstName,
                            lastName: this.lastName,
                            email: this.email,
                            password: this.password,
                            phoneNr: this.phoneNr,
                            role: this.role
                        }),
                    });
                    this.$router.push('/login');
                } catch (error) {
                this.errorMessage = 'Er is een fout opgetreden bij het registreren.';
                console.error('Er is een fout opgetreden bij het registreren:', error);
            }
            }
        },
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