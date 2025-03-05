
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import LostLostPhoneManager from "./components/listers/LostLostPhoneCards"
import LostLostPhoneDetail from "./components/listers/LostLostPhoneDetail"

import DestinationStationManager from "./components/listers/DestinationStationCards"
import DestinationStationDetail from "./components/listers/DestinationStationDetail"
import DestinationDestinationManager from "./components/listers/DestinationDestinationCards"
import DestinationDestinationDetail from "./components/listers/DestinationDestinationDetail"

import StationInfoListView from "./components/StationInfoListView"
import StationInfoListViewDetail from "./components/StationInfoListViewDetail"
import GpsInfoListView from "./components/GpsInfoListView"
import GpsInfoListViewDetail from "./components/GpsInfoListViewDetail"
import LostserviceInsuranceManager from "./components/listers/LostserviceInsuranceCards"
import LostserviceInsuranceDetail from "./components/listers/LostserviceInsuranceDetail"
import LostservicePhoneChangeManager from "./components/listers/LostservicePhoneChangeCards"
import LostservicePhoneChangeDetail from "./components/listers/LostservicePhoneChangeDetail"

import PhonePhoneManager from "./components/listers/PhonePhoneCards"
import PhonePhoneDetail from "./components/listers/PhonePhoneDetail"

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
                path: '/destinations/stations',
                name: 'DestinationStationManager',
                component: DestinationStationManager
            },
            {
                path: '/destinations/stations/:id',
                name: 'DestinationStationDetail',
                component: DestinationStationDetail
            },
            {
                path: '/destinations/destinations',
                name: 'DestinationDestinationManager',
                component: DestinationDestinationManager
            },
            {
                path: '/destinations/destinations/:id',
                name: 'DestinationDestinationDetail',
                component: DestinationDestinationDetail
            },

            {
                path: '/destinations/stationInfoLists',
                name: 'StationInfoListView',
                component: StationInfoListView
            },
            {
                path: '/destinations/stationInfoLists/:id',
                name: 'StationInfoListViewDetail',
                component: StationInfoListViewDetail
            },
            {
                path: '/destinations/gpsInfoLists',
                name: 'GpsInfoListView',
                component: GpsInfoListView
            },
            {
                path: '/destinations/gpsInfoLists/:id',
                name: 'GpsInfoListViewDetail',
                component: GpsInfoListViewDetail
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
