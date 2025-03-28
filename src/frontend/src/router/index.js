import { createRouter, createWebHistory } from 'vue-router';
import FlightsView from '../components/FlightsView.vue';
import SeatPurchase from '../components/SeatPurchase.vue';

const routes = [
    {
      path: '/',
      name: 'Home',
      component: FlightsView,
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