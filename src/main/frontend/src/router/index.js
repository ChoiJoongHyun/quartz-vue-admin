import Vue from 'vue';
import Router from 'vue-router';

import DefaultRouterView from './DefaultRouterView';
import DashboardView from '../views/DashboardView';
import CronTriggerView from '../views/CronTriggerView';
import SimpleTriggerView from '../views/SimpleTriggerView';

Vue.use(Router);

const router = new Router({
  routes : [
    {
      path: "/dashboard",
      name: "DashboardView",
      component: DashboardView,
      meta: {
        title: "DashBoard",
        icon: "el-icon-s-data"
      }
    }
    ,
    {
      path: "/",
      name: "CronTriggerDefaultRouterView",
      component: DefaultRouterView,
      meta: {
        title: "Trigger",
        icon: "el-icon-s-data"
      },
      children: [
        {
          path: "/cron/triggers",
          name: "CronTriggerView",
          component: CronTriggerView,
          meta: {
            title: "CronTrigger"
          }
        }
        ,
        {
          path: "/simple/triggers",
          name: "SimpleTriggerView",
          component: SimpleTriggerView,
          meta: {
            title: "SimpleTrigger"
          }
        }
      ]
    }
    ,
    {
      path: "/dashboard",
      name: "DashboardView",
      component: DashboardView,
      meta: {
        title: "DashBoard",
        icon: "el-icon-s-data"
      }
    }
    ,
    {
      path: "/**",
      redirect: '/dashboard'
    }
  ]
});
export default router;
