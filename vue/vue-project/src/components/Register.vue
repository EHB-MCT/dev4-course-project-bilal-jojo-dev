<template>
    <div class="login">
        <h2>Register</h2>
        <form>
            <div>
                <label for="firstName"></label>
                <input type="text" id="firstName" v-model="firstName">
            </div>
            <div>
                <label for="lastName"></label>
                <input type="text" id="lastName" v-model="lastName">
            </div>
            <div>
                <label for="mail"></label>
                <input type="text" id="mail" v-model="mail">
            </div>
            <div>
                <label for="password"></label>
                <input type="text" id="password" v-model="password">
            </div>
            <div>
                <label for="phoneNr"></label>
                <input type="number" id="phoneNr" v-model="phoneNr">
            </div>
        </form>
    </div>
</template>

<script>

export default {
    data() {
        return {
            firstName: '',
            lastName: '',
            mail: '',
            password: '',
            phoneNr: '',
            role: 'student'
        }},
        methods: {
            async register() {
                try {
                    const response = await fetch('http://localhost:8080/users', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        }, 
                        body: JSON.stringify({
                            firstName: this.firstName,
                            lastName: this.lastName,
                            mail: this.mail,
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