import {createRouter,createWebHashHistory} from 'vue-router'
import AddBook from '../component/AddBook.vue'
import ListBook from '../component/ListBook.vue'

const routes = [
    {path:'/addBook',component:AddBook},
    {path:'/listBook',component:ListBook},
]

const router = createRouter({
   
    history: createWebHashHistory(),
    routes,
  })

  export default router