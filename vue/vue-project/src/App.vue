<template>
  <div id="app">
    <nav>
      <ul>
        <li>
          <router-link to="/items">Items</router-link>
        </li>
        <li>
          <router-link to="/users">Users</router-link>
        </li>
        <li>
          <router-link to="/login">Login</router-link>
        </li>
      </ul>
    </nav>
    <router-view></router-view>
  </div>
</template>

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

