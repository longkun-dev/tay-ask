import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/views/Index'
import Ask from '@/views/Ask'
import AllQuestions from '@/views/AllQuestion'
import Tags from '@/views/Tags'
import Login from '@/views/Login.vue'
import User from '@/views/Users.vue'

Vue.use(Router)

const originalPush = Router.prototype.push

Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

export default new Router({
    routes: [
        {
            path: '/',
            name: '/',
            component: Index
        }, {
            path: '/ask',
            name: 'ask',
            component: Ask
        }, {
            path: '/allQuestions',
            name: 'allQuestions',
            component: AllQuestions
        }, {
            path: '/tags',
            name: 'tags',
            component: Tags
        }, {
            path: '/login',
            name: 'login',
            component: Login
        }, {
            path: '/users',
            name: 'users',
            component: User
        }
    ]
})
