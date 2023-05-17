<template>
    <div class="loan login">
        <h2>Loan</h2>
        <form @submit.prevent="reservation">
            <div>
                <label for="startDate">Start Date</label>
                <input type="date" id="startDate" v-model="startDate">
                <label for="endDate"> End Date</label>
                <input type="date" id="endDate" v-model="endDate">
            </div>
            <button type="submit">Reserve</button>
            <p v-if="errorMessage">{{ errorMessage }}</p>
            <h1 v-if="role == 'admin'">This is an admin</h1>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            startDate: '',
            endDate: '',
            errorMessage: '',
            accesstoken: localStorage.getItem('authToken'),
            ItemId: localStorage.getItem('itemId'),
            userId: '',
            role: localStorage.getItem('role')
        };
    },
    methods: {
        async reservation() {

            const userResponse = await fetch('http://localhost:8080/users', {
            headers: {
            "Content-Type": "application/json",
            'Authorization':  this.accesstoken
            }
            });

            //The code takes in a response object from an API call, sorts the data by user ID, and checks if the user with the highest ID exists in the data.
            const userData = await userResponse.json();
            console.log('User data:', userData);
            //If the data is not an array or has no elements, the code logs an error message and returns undefined.

            const desiredAccessToken = this.accesstoken

            for (const user of userData) {
                if (user.accessToken === desiredAccessToken) {
                    console.log(`User is ${user.id}`);
                    this.userId = user.id
                    this.role = user.role
                    console.log(this.role)
                    break;
                }
                // console.log(`users: ${user.id}`)
            }
            
            //To represent data that will be sent in an HTTP request, on behalf of a user identified by userId
            const formData = {
            userId: this.userId,
            itemId: this.ItemId,
            startDate: this.startDate,
            endDate: this.endDate
            // token: this.token
            }


            await fetch('http://localhost:8080/loans', {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": this.accesstoken
                },
                body: JSON.stringify(formData)
            });

            console.log('Reserving from start date:', this.startDate);
            console.log(this.accesstoken);
            console.log(localStorage.getItem('itemId'));
            this.$router.push('/items');
        },


        // reserve() {
        //     console.log('Reserving from start date:', this.startDate);
        //     console.log(this.accesstoken);
        //     console.log(localStorage.getItem('itemId'))
        //     this.reservation();
        // }
    },
    mounted() {
        
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


</style>