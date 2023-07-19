import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import Admin from '../views/Admin.vue'
import Catalog from '../views/Catalog.vue'
import ProductDetail from '../views/ProductDetail.vue'
import ProductionRunDetail from '../views/ProductionRunDetail.vue'
import Instance from '../views/Instance.vue'
import Unlocker from '../views/Unlocker.vue'
import store from '../store/index'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/login",
            name: "login",
            component: Login,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/logout",
            name: "logout",
            component: Logout,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/register",
            name: "register",
            component: Register,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/catalog",
            name: "catalog",
            component: Catalog,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: '/product/:id',
            name: 'product',
            component: ProductDetail,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: '/run/:id',
            name: 'run',
            component: ProductionRunDetail,
            meta: {
                requiresAuth: true
            }
        },
        // TODO: The serial should not be part of the URL...
        {
            path: '/instance/:serial',
            name: 'instance',
            component: Instance,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/admin",
            name: "admin",
            component: Admin,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/unlock",
            name: "unlock",
            component:  Unlocker,
            meta: {
                requiresAuth: true
            }
        }
    ]
})

router.beforeEach((to, from, next) => {
    // Determine if the route requires Authentication
    const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

    // If it does and they are not logged in, send the user to "/login"
    if (requiresAuth && store.state.token === '') {
        next({
            path: '/login',
            query: { redirect: to.fullPath }
        })

    } else {
        // Else let them go to their next destination
        next();
    }
});

export default router;
