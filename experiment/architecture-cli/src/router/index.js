import Vue from 'vue'
import Router from 'vue-router'

import Architecture from '@/components/Architecture.vue';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: "/",
      redirect: "/architecture",
    },
    {
      path: "/architecture",
      name: "Architecture",
      component: Architecture,
    },
  ],
});
