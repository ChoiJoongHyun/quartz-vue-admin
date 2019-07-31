import Vue from 'vue';
import Router from 'vue-router';

import DashboardView from '../views/DashboardView';
import CronTriggerView from '../views/CronTriggerView';
import SimpleTriggerView from '../views/SimpleTriggerView';
import JobView from '../views/JobView';
import InfoView from '../views/InfoView';

Vue.use(Router);

const router = new Router({
  routes : [
    {
      path: "/dashboard",
      name: "DashboardView",
      component: DashboardView,
      meta: {
        title: "DashBoard",
        icon: "el-icon-monitor"
      }
    }
    ,
    {
      path: "/jobs",
      name: "JobView",
      component: JobView,
      meta: {
        title: "Quartz JOB",
        icon: "el-icon-files"
      }
    }
    ,
    {
      path: "/cron/triggers",
      name: "CronTriggerView",
      component: CronTriggerView,
      meta: {
        title: "CronTrigger",
        icon: "el-icon-time"
      }
    }
    ,
    {
      path: "/simple/triggers",
      name: "SimpleTriggerView",
      component: SimpleTriggerView,
      meta: {
        title: "SimpleTrigger",
        icon: "el-icon-aim"
      }
    }
    ,
    {
      path: "/info",
      name: "InfoView",
      component: InfoView,
      meta: {
        title: "Info",
        icon: "el-icon-info"
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
