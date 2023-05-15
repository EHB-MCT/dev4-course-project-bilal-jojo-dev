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
            errorMessage: ''
        }
    },
    methods: {
        reserve() {
            console.log('Reserving from start date:', this.startDate);
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
  
  