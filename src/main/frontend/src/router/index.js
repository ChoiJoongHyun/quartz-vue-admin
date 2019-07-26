import Vue from 'vue';
import Router from 'vue-router';

import DashboardView from '../views/DashboardView';
import CronTriggerView from '../views/CronTriggerView';
import SimpleTriggerView from '../views/SimpleTriggerView';
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
      path: "/cron/triggers",
      name: "CronTriggerView",
      component: CronTriggerView,
      meta: {
        title: "CronTrigger",
        icon: "el-icon-s-data"
      }
    }
    ,
    {
      path: "/simple/triggers",
      name: "SimpleTriggerView",
      component: SimpleTriggerView,
      meta: {
        title: "SimpleTrigger",
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
