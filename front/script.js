import { NotFound } from './scripts/pages/404.page.js'
import { Login } from './scripts/pages/login.page.js'

const ROUTER = {
    "#404": {component: NotFound, private: undefined},
    "#login": {component: Login, private: false},
}

function redirectPage() {
    const route = ROUTER[window.location.hash] || ROUTER["#404"]
    
    const root = document.querySelector('#root')
    
    if(route.private !== undefined) {
        const privateNotLogged = route.private === true && !sessionStorage.getItem('@token')
    }
    if(privateNotLogged) {
        window.location.href = '/#login'
        return
    }

    const publicLogged = route.private === false && sessionStorage.getItem('@token')
    if(publicLogged) {
        window.location.href = '/#home'
        return
    }

    root.innerHTML = null
    root.appendChild(route.component())
}

window.addEventListener('load', () => {
    if(!window.location.hash) {
     window.location.href = '/#login'
    }

    redirectPage()
    window.addEventListener('hashchange', redirectPage)
})