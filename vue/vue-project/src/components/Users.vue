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
  methods: {
    async getData() {
      try {
        const token = localStorage.getItem('authToken');
        const response = await fetch('http://localhost:8080/users', {
          method: 'GET',
          headers: {
            'Authorization': token,
          },
        });

        if (!response.ok) {
          throw new Error('Failed to fetch users');
        }

        const data = await response.json();
        this.users = data;
      } catch (error) {
        console.error('Er is een fout opgetreden bij het ophalen van gebruikers:', error);
      }
    }
  },
  mounted() {
    this.getData();
  }
}
</script>

<style scoped>
h3 {
  font-size: 1.2rem;
}
</style>

  
  