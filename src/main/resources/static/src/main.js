// The following line loads the standalone build of Vue instead of the runtime-only build,
// so you don't have to do: import Vue from 'vue/dist/vue'
// This is done with the browser options. For the config, see package.json
import Vue from 'vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'

import Login from './Login.vue'
import WorkingSpace from './WorkingPage.vue'
import ByNumberSearch from './component/nosearch/ByNumberSearch.vue'
import ByTimeSearch from './component/timesearch/ByTimeSearch.vue'
import VideoRecorder from './component/profile/VideoRecorder.vue'

Vue.use(VueRouter)
Vue.use(VueResource)


const routes = [{
    path: "/working",
    component: WorkingSpace,
    children:[
    	{
    		path:"by-number",
    		component:ByNumberSearch
    	},
    	{
    		path:"by-time",
    		component:ByTimeSearch
    	}
    ]

}, {
    path: '/',
    component: Login
}, {
	path:'/recording',
	component: VideoRecorder
}]

const router = new VueRouter({
    routes // short for routes: routes
})

window._ = require('lodash');

new Vue({ // eslint-disable-line no-new
    router
}).$mount('#app')
