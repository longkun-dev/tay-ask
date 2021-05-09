import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/views/Index'
import Ask from '@/views/Ask'
import AllQuestions from '@/views/AllQuestion'
import Tags from '@/views/Tags'
import Login from '@/views/Login.vue'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Index',
            component: Index
        }, {
            path: '/index',
            name: 'Index',
            component: Index
        }, {
            path: '/ask',
            name: 'Ask',
            component: Ask
        }, {
            path: '/allQuestions',
            name: 'AllQuestions',
            component: AllQuestions
        }, {
            path: '/tags',
            name: 'Tags',
            component: Tags
        }, {
            path: '/login',
            name: 'Login',
            component: Login
        }
    ]
})
