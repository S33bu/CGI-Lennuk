import { createRouter, createWebHistory } from 'vue-router';
import HelloWorld from '../components/HelloWorld.vue';
import SeatPurchase from '../components/SeatPurchase.vue';

const routes = [
    {
      path: '/',
      name: 'Home',
      component: HelloWorld,
    },
    {
      path: '/SeatPurchase',
      name: 'SeatPurchase',
      component: SeatPurchase
    }
  ];
  
  const router = createRouter({
    history: createWebHistory(),
    routes
  });
  
  export default router;