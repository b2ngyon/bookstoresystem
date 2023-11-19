<template>
<h1>Register Form</h1>

<label>Username: </label>
<input type="text" name="username" >
<br>
<label>First Name: </label>
<input type="text" name="fname" >
<br>
<label>Last Name: </label>
<input type="text" name="lname" >
<br>
<label>Password: </label>
<input type="password" name="password" >
<br>
<label>Address: </label>
<input type="textarea" name="address" >
<br>
<label>Date of birth: </label>
<input type="date" name="dob" >
<br>

<button @click="registerUser">Register</button>
<button @click="resetValue">Reset</button>
</template>


<script>
 import BookstoreService from '../services/BookstoreService'

export default {
    name:'registerUser',
    data(){
        return{
            model:{
                user:
                {
                    userName:'',
                    password:'',
                    firstName:'',
                    lastName:'',
                    address:'',
                    dob:''
                    
                }
            }
        }
    },

    methods:{
        registerUser()
        {
            BookstoreService.addUser(this.model.user).then(response =>{

                console.log(response);
                alert(response.data);

                this.model.user =
            {
                userName:'',
                    password:'',
                    firstName:'',
                    lastName:'',
                    address:'',
                    dob:''
                    
            }
            })
        },

        resetValue()
        {
            this.model.user =
            {
                userName:'',
                    password:'',
                    firstName:'',
                    lastName:'',
                    address:'',
                    dob:''
                    
            }

            
        }
    }
}

</script>