<template>
    <div class="loan" v-if="role == 'admin'">
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