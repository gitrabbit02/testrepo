import Vue from 'vue'
import Router from 'vue-router'
import SiteList from './components/SiteList'
import AddSite from './components/AddSite'
import EditSite from './components/EditSite'

Vue.use(Router)

export default new Router({
    mode:'history',
    base:process.env.BASE_URLl,
    routes:[
        {path:'/',component:SiteList},
        {path:'/sites/add',component:AddSite},
        {path:'/sites/edit/:id',component:EditSite},
    ]
})