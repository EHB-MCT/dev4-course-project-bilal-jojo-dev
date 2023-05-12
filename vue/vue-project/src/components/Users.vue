<template>
  <div>
    <h3>
      <ul>
        <li v-for="user in users" :key="user.id">
          {{ user.email }} - {{ user.password }}
        </li>
      </ul>
    </h3>
  </div>
</template>

<script>
    export default {
      data() {
      return {
        users: []
      }
    },

    mounted() {
  const authToken = localStorage.getItem('authToken');
  if (!authToken) {
    console.error('User is not authenticated');
    return;
  }

  fetch('http://localhost:8080/users', {
    headers: {
      'Authorization': authToken,
    }
  })
    .then(response => response.json())
    .then(data => {
      // Store response data in component's data object
      this.users = data;
      console.log(data);
    })
    .catch(error => {
      // Handle any errors that occur during the API request
      console.error(error);
    });
},


    updated() {
      // Check that users data is being properly stored in component's data object
      console.log(this.users);
    }
  }
  </script>

<style scoped>
h3 {
  font-size: 1.2rem;
}
</style>

  
  