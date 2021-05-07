import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/views/Index'
import Ask from '@/views/Ask'
import QuestionItem from '../components/QuestionItem'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Index',
            component: Index
        }, {
            path: '/ask',
            name: 'Ask',
            component: Ask
        }, {
            path: '/question',
            name: 'Question',
            component: QuestionItem
        }
    ]
})
