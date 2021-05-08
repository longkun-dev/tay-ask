import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/views/Index'
import Ask from '@/views/Ask'
import AllQuestion from '@/views/AllQuestion'

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
            name: 'AllQuestion',
            component: AllQuestion
        }
    ]
})
