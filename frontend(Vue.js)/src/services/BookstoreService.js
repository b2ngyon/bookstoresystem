import axios from 'axios'

const BOOKSTORE_API_BASE_URL ='http://localhost:8080/api/v1';

class BookServices{
    getBookList()
    {
        const getBook = '/book/getBookList';
        console.log(BOOKSTORE_API_BASE_URL+getBook);
        return axios.get(BOOKSTORE_API_BASE_URL+getBook);
    }

  addBook(bookModel)
  {
    const addBookPath ='/book/addBook';
    return axios.post(BOOKSTORE_API_BASE_URL+addBookPath,bookModel);
  }

  addUser(userModel)
  {
    const addUserPath = '/user/addUser';
    return axios.post(BOOKSTORE_API_BASE_URL+addUserPath,userModel);
  }
    
}

export default new BookServices()