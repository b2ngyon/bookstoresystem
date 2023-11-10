<template>
<center>
<h1>
    Add New Book
</h1>
    <p>Book Name: </p><input type="text" v-model="model.book.bookTitle"  name="bookName"/>
    <p>Book Description: </p><input type="text" v-model="model.book.description" name="bookDescp" />
    <p>Book Type: </p><input type="text" v-model="model.book.bookType" name="bookType" />
    <p>Book Author: </p><input type="text"  v-model="model.book.author" name="bookAuthor" />
    <p>Publish Date:</p><input type="date" v-model="model.book.publishDate" name="bookDate" />
<br/>
    <button type="button"  @click="addBook">Add</button>
</center>
</template>

<script>
  import BookstoreService from '../services/BookstoreService'

export default {
    name:'addBook',
    data(){
        return{
            model:{
                book:
                {
                    bookTitle:'',
                    description:'',
                    author:'',
                    bookType:'',
                    publishDate:'',
                    
                }
            }
        }
    },

    methods:{
        addBook()
        {
            BookstoreService.addBook(this.model.book).then(response =>{

                console.log(response);
                alert(response.data);

                this.model.book =
                {
                    bookTitle:'',
                    description:'',
                    author:'',
                    bookType:'',
                    publishDate:''
                }
            })
        }
    }
}

</script>