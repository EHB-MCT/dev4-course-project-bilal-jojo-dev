<template>
    <div class="items">
      <Items />
    </div>
  </template>
  
  <script setup>
  import Items from '../components/Items.vue'
  </script>
  
  <style scoped>
  .items {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
  </style>
