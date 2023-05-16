<template>
  <head>
  </head>
  <div id="app">
    <nav>
      <ul>
        <li v-if="isLoggedIn">
          <router-link to="/items">Items</router-link>
        </li>
        <li v-if="isLoggedIn && role == 'admin'">
          <router-link to="/users">Users</router-link>
        </li>
        <li v-if="isLoggedIn && role == 'admin'">
          <router-link to="/loan">Loans</router-link>
        </li>
        <li v-if="!isLoggedIn">
          <router-link to="/login">Login</router-link>
        </li>
        <li v-if="isLoggedIn && role == 'admin'">
          <router-link to="/CreateItem">Add Item & Copy</router-link>
        </li>
        <li v-if="isLoggedIn" @click="logout">
          Logout
        </li>
      </ul>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isLoggedIn: !!localStorage.getItem('authToken'),
      role: localStorage.getItem('role')
    }
  },
  methods: {
    async isAdmin() {

const userResponse = await fetch('http://localhost:8080/users', {
      headers: {
      "Content-Type": "application/json",
      'Authorization': localStorage.getItem('authToken')
      }
      });

      //The code takes in a response object from an API call, sorts the data by user ID, and checks if the user with the highest ID exists in the data.
      const userData = await userResponse.json();
      // console.log('User data:', userData);
      //If the data is not an array or has no elements, the code logs an error message and returns undefined.

      const desiredAccessToken = localStorage.getItem('authToken')

      for (const user of userData) {
          if (user.accessToken === desiredAccessToken) {
              // console.log(`User is ${user.id}`);
              this.role = user.role
              console.log(this.role)
              localStorage.setItem('role', this.role)
              break;
          }
          // console.log(`users: ${user.id}`)
      }

},
    logout() {
      localStorage.removeItem('authToken');
      this.isLoggedIn = false;
      this.$router.push('/login');
    },
  },
  created() {
    this.$router.beforeEach((to, from, next) => {
      this.isLoggedIn = !!localStorage.getItem('authToken');
      next();
    });
  },
  mounted() {
    this.isAdmin();
  }
}
</script>

<style scoped>
nav {
  background-color: #333;
  padding: 1rem;
}

nav ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

nav li {
  display: inline;
  margin-right: 1rem;
  color: #eee;
}

nav li a {
  text-decoration: none;
  color: white;
}
</style>

