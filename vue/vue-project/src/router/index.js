import { createRouter, createWebHistory } from 'vue-router';
import ItemsView from '../views/ItemsView.vue';
import UsersView from '../views/UsersView.vue';
import Login from '../components/Login.vue';
import LoanView from '../views/LoanView.vue';
import RegisterView from '../views/RegisterView.vue';
import CreateItemView from '../views/CreateItemView.vue';
import GetLoansView from '../views/GetLoansView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/login',
    },
    {
      path: '/login',
      name: 'login',
      component: Login
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
    },
    {
      path: '/loan',
      name: 'loan',
      component: LoanView
    }, 
    {
      path: '/register',
      name: 'register',
      component: RegisterView
    },
    {
      path: '/CreateItem',
      name: 'createItem',
      component: CreateItemView
    },
    {
      path: '/getLoans',
      name: 'getLoans',
      component: GetLoansView
    },
  ]
});

export default router;

