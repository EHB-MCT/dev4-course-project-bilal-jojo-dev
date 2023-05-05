import { createRouter, createWebHistory } from 'vue-router';
import ItemsView from '../views/ItemsView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/items', // Hier voegen we een redirect toe van de root URL naar de /items route
    },
    {
      path: '/items',
      name: 'items',
      component: ItemsView
    }
  ]
});

export default router;
