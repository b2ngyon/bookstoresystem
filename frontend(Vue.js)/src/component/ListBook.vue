<template>
    <center>
    <h1>Test Book Store</h1>
    <h3>List of Book</h3>
      
    <div v-for="bookstore in bookstoreList" v-bind:key="bookstore.bookId">
      <div v-show="!isHidden">
        <input type="text" hidden name={{bookstore.bookId}} id="bookId">
        <p>Book Title: {{bookstore.bookTitle}}</p>
        <p>Book Type: {{bookstore.bookType}}</p>
        <p>Author: {{bookstore.author}}</p>
        <p>Publish Date: {{bookstore.publishDate}}</p>
      </div>
      <div v-show="isHidden && currentBookKey == bookstore.bookId">
        <input type="text" hidden name={{bookstore.bookId}} id="bookId">
        <label>Book Name: </label><input type="text" v-model="model.book.bookTitle"  name="bookName"/><br><br>
        <label>Book Description: </label><input type="text" v-model="model.book.description" name="bookDescp" /><br><br>
        <label>Book Type: </label><input type="text" v-model="model.book.bookType" name="bookType" /><br><br>
        <label>Book Author: </label><input type="text"  v-model="model.book.author" name="bookAuthor" /><br><br>
        <p>Publish Date: {{bookstore.publishDate}}</p>  </div>
      <button @click="changeToEditMode(bookstore.bookId)" v-show="!isHidden">Edit</button>
      <button @click="updateBook" v-show="isHidden">update</button>
      <button @click="deleteBook(bookstore.bookId)">delete</button>
      <br><br>
    </div>
  </center>

  <editDrawer ref="editDrawer"></editDrawer>
  
  </template>
  
  <script>
  import BookstoreService from '../services/BookstoreService';
  import editDrawer from '../component/editDrawer.vue';

  export default{
    name:'BookStore',
    components: {
      editDrawer,
    },
    data(){
      return{
        bookstoreList :[],
        isHidden:false,
        model:{
            book:
            {
                bookTitle:'',
                description:'',
                author:'',
                bookType:'',
                publishDate:''
            }
        },
        currentBookKey: null,
      }
      
    },
    methods: {
      getBook()
      {
        BookstoreService.getBookList().then((response) => {
          this.bookstoreList = response.data;
        });
      },
      updateBook()
      {

      },
      changeToEditMode(id){
        this.$refs.editDrawer.open();
        // alert(id);
        this.currentBookKey = id;
        this.isHidden = true;
      }
    },
    created(){
      this.getBook()
    }

}
  </script>
  