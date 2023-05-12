
<template>
  <div id="app">
    <nav>
      <ul>
        <li v-if="isLoggedIn">
          <router-link to="/items">Items</router-link>
        </li>
        <li v-if="isLoggedIn">
          <router-link to="/users">Users</router-link>
        </li>
        <li v-if="!isLoggedIn">
          <router-link to="/login">Login</router-link>
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
    }
  },
  methods: {
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
}

nav li a {
  text-decoration: none;
  color: white;
}
</style>

