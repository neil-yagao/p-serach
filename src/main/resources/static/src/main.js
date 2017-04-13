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
import PrisonProfile from './component/profile/PrisonProfile.vue'
import PrisonMedicalInfo from './component/profile/PrisonMedicalInfo.vue'
import MasterDataMain from './component/master-data/MasterDataMain.vue'
import MasterDataMedical from './component/master-data/MasterDataMedical.vue'
import MasterDataInmate from './component/master-data/MasterDataInmate.vue'
import UploadFile from './component/master-data/UploadFile.vue'

require("xlsx")
window.jQuery =require("jquery")
require("bootstrap")


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
    	},{
    		path:"data-edit",
    		component: MasterDataMain,
    		children:[
    			{
    				path:"",
					component: UploadFile
    			},
    			{
					path:"medical",
					component:MasterDataMedical
    			},
    			{
					path:"inmate",
					component:MasterDataInmate
    			}
    		]
    	},
        {
            path:'detail/:id',
            component:PrisonProfile
        },{
            path:'add',
            component:PrisonMedicalInfo
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
