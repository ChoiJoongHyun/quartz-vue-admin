import Vue from 'vue';
import Router from 'vue-router';

import DefaultRouterView from './DefaultRouterView';
import DashboardView from '../views/DashboardView';
import AllTriggerView from '../views/AllTriggerView';
import CronTriggerView from '../views/CronTriggerView';
import SimpleTriggerView from '../views/SimpleTriggerView';
import BlobTriggerView from '../views/BlobTriggerView';
import SimpropTriggerView from '../views/SimpropTriggerView';
import JobView from '../views/JobView';

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
      path: "/jobs",
      name: "JobView",
      component: JobView,
      meta: {
        title: "Quartz JOB",
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
          path: "/triggers",
          name: "AllTriggerView",
          component: AllTriggerView,
          meta: {
            title: "AllTrigger"
          }
        }
        ,
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
        /*,
        {
          path: "/simprop/triggers",
          name: "SimpropTriggerView",
          component: SimpropTriggerView,
          meta: {
            title: "SimpropTrigger"
          }
        }
        ,
        {
          path: "/blob/triggers",
          name: "BlobTriggerView",
          component: BlobTriggerView,
          meta: {
            title: "BlobTrigger"
          }
        }*/
      ]
    }
    /*,
    {
      path: "/dashboard",
      name: "DashboardView",
      component: DashboardView,
      meta: {
        title: "DashBoard",
        icon: "el-icon-s-data"
      }
    }*/
    ,
    {
      path: "/**",
      redirect: '/dashboard'
    }
  ]
});
export default router;
