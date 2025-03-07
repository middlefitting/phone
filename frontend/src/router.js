
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import LostLostPhoneManager from "./components/listers/LostLostPhoneCards"
import LostLostPhoneDetail from "./components/listers/LostLostPhoneDetail"

import LostserviceInsuranceManager from "./components/listers/LostserviceInsuranceCards"
import LostserviceInsuranceDetail from "./components/listers/LostserviceInsuranceDetail"
import LostservicePhoneChangeManager from "./components/listers/LostservicePhoneChangeCards"
import LostservicePhoneChangeDetail from "./components/listers/LostservicePhoneChangeDetail"

import PhoneDestinationManager from "./components/listers/PhoneDestinationCards"
import PhoneDestinationDetail from "./components/listers/PhoneDestinationDetail"
import PhonePhoneManager from "./components/listers/PhonePhoneCards"
import PhonePhoneDetail from "./components/listers/PhonePhoneDetail"

import GpsInfoListView from "./components/GpsInfoListView"
import GpsInfoListViewDetail from "./components/GpsInfoListViewDetail"
import PhoneInfoListView from "./components/PhoneInfoListView"
import PhoneInfoListViewDetail from "./components/PhoneInfoListViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/losts/lostPhones',
                name: 'LostLostPhoneManager',
                component: LostLostPhoneManager
            },
            {
                path: '/losts/lostPhones/:id',
                name: 'LostLostPhoneDetail',
                component: LostLostPhoneDetail
            },

            {
                path: '/lostservices/insurances',
                name: 'LostserviceInsuranceManager',
                component: LostserviceInsuranceManager
            },
            {
                path: '/lostservices/insurances/:id',
                name: 'LostserviceInsuranceDetail',
                component: LostserviceInsuranceDetail
            },
            {
                path: '/lostservices/phoneChanges',
                name: 'LostservicePhoneChangeManager',
                component: LostservicePhoneChangeManager
            },
            {
                path: '/lostservices/phoneChanges/:id',
                name: 'LostservicePhoneChangeDetail',
                component: LostservicePhoneChangeDetail
            },

            {
                path: '/phones/destinations',
                name: 'PhoneDestinationManager',
                component: PhoneDestinationManager
            },
            {
                path: '/phones/destinations/:id',
                name: 'PhoneDestinationDetail',
                component: PhoneDestinationDetail
            },
            {
                path: '/phones/phones',
                name: 'PhonePhoneManager',
                component: PhonePhoneManager
            },
            {
                path: '/phones/phones/:id',
                name: 'PhonePhoneDetail',
                component: PhonePhoneDetail
            },

            {
                path: '/phones/gpsInfoLists',
                name: 'GpsInfoListView',
                component: GpsInfoListView
            },
            {
                path: '/phones/gpsInfoLists/:id',
                name: 'GpsInfoListViewDetail',
                component: GpsInfoListViewDetail
            },
            {
                path: '/phones/phoneInfoLists',
                name: 'PhoneInfoListView',
                component: PhoneInfoListView
            },
            {
                path: '/phones/phoneInfoLists/:id',
                name: 'PhoneInfoListViewDetail',
                component: PhoneInfoListViewDetail
            },


    ]
})
