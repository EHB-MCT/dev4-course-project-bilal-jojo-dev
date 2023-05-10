import { createRouter, createWebHistory } from 'vue-router';
import ItemsView from '../views/ItemsView.vue';
import UsersView from '../views/UsersView.vue'; // Importeer UsersView

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/items', 
    },
    {
      path: '/items',
      name: 'items',
      component: ItemsView
    },
    {
      path: '/users',
      name: 'users',
      component: UsersView 
    }
  ]
});

export default router;

