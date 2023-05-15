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
            errorMessage: '',
            accesstoken: localStorage.getItem('authToken'),
            copy: JSON.parse(localStorage.getItem('itemId'))
        }
    },
    methods: {
        async reserve() {
            
            console.log('Reserving item:', this.copy, 'from start date:', this.startDate);

            const userId = localStorage.getItem('userId'); 

            const startDate = new Date(this.startDate);
            const endDate = new Date();
            endDate.setDate(startDate.getDate() + 14); 
            const loanData = {
                itemId: this.copy.id, 
                userId: userId,
                startDate: startDate.toISOString().split('T')[0], 
                endDate: endDate.toISOString().split('T')[0], 
            };

            try {
                const response = await fetch('http://localhost:8080/loans', {
                    method: 'POST',
                    headers: {
                        'Authorization': `Bearer ${this.accesstoken}`,
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(loanData)
                });

                if (!response.ok) {
                    throw new Error('Reservering mislukt');
                }

                console.log(await response.json());
            } catch (error) {
                this.errorMessage = 'Er is een fout opgetreden bij de reservering: ' + error.message;
                console.log('Er is een fout opgetreden bij de reservering:', error);
            }
        }

    }
}
</script>
<style scoped>
.loan {
    width: 300px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    background-color: #f9f9f9;
}

.loan input {
    width: 100%;
    margin: 5px 0;
}

.loan button {
    margin-top: 10px;
}
</style>
  
  