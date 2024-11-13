import { createRouter, createWebHashHistory } from 'vue-router'

import pk from '../views/pk/PkIndexView'
import ranklist from '../views/ranklist/RankIndexView'
import error from '../views/error/NotFound'
import record from '../views/record/RecordIndexView'
import userbot from '../views/user/bot/UserBotIndexView'

const routes = [
  {
    path: '/',
    name: 'home',
    redirect: '/pk/'
  },
  {
    path: '/pk/',
    name: 'pk_index',
    component: pk
  },
  {
    path: '/ranklist/',
    name: 'ranklist_index',
    component: ranklist
  },
  {
    path: '/record/',
    name: 'record_index',
    component: record
  },
  {
    path: '/userbot/',
    name: 'userbot_index',
    component: userbot
  },
  {
    path: '/404/',
    name: '404',
    component: error
  },
  {
    path: '/:catchAll(.*)',
    redirect: '/404/'
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
