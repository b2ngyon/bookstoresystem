import {createRouter,createWebHashHistory} from 'vue-router'
import AddBook from '../component/AddBook.vue'
import ListBook from '../component/ListBook.vue'
import RegisterUser from '../component/RegisterUser.vue'

const routes = [
    {path:'/addBook',component:AddBook},
    {path:'/listBook',component:ListBook},
    {path:'/register',component:RegisterUser},
]

const router = createRouter({
   
    history: createWebHashHistory(),
    routes,
  })

  export default router