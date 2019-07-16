import Vue from 'vue';
import Router from 'vue-router';

import DashboardView from '../views/DashboardView';
import CronTriggerView from '../views/CronTriggerView';

Vue.use(Router);

const router = new Router({
  routes : [
    {
      path: "/dashboard",
      name: "Dashboard",
      component: DashboardView
    }
    ,
    {
      path: "/triggers/cron",
      name: "Cron Trigger",
      component: CronTriggerView
    }
    ,
    {
      path: "/**",
      redirect: '/dashboard'
    }
  ]
});
export default router;
