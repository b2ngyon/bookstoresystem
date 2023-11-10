import axios from 'axios'

const BOOKSTORE_API_BASE_URL ='http://localhost:8080/api/v1/book';

class BookServices{
    getBookList()
    {
        const getBook = '/getBookList';
        console.log(BOOKSTORE_API_BASE_URL+getBook);
        return axios.get(BOOKSTORE_API_BASE_URL+getBook);
    }

  addBook(bookModel)
  {
    const addBookPath ='/addBook';
    return axios.post(BOOKSTORE_API_BASE_URL+addBookPath,bookModel);
  }

    
}

export default new BookServices()