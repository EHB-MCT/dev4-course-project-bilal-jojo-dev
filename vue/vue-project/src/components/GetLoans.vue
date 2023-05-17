
<template>
    <div >
        <div class="copy bold">
          <h6>ID</h6>
          <h6>Persoon</h6>
          <h6>Email</h6>
          <h6>Item</h6>
          <h6>Begin Date</h6>
          <h6>End Date</h6>
        </div>
        <div class="copy" v-for="loan in loans" :key="loan.id">
          <h6>{{ loan.id }}</h6>
          <h6>{{ loan.userId.firstName }} {{ loan.userId.lastName }}</h6>
          <h6>{{ loan.userId.email }}</h6>
          <h6>{{ loan.itemId.serial }}, {{ loan.itemId.name }}, {{ loan.itemId.item.name }}</h6>
          <h6>{{ loan.date }}</h6>
          <h6>{{ loan.expirationDate }}</h6>
        </div>
    </div>
  </template>
  
  <script>
  export default {
    props: ['reserveItem'], 
  
    data() {
      return {
        loans: [],
        role: '',
        itemDelete: '',
        startDate: '',
        endDate: ''
      };
    },
    methods: {
  
  
      async isAdmin() {
  
        const userResponse = await fetch('http://localhost:8080/users', {
              headers: {
              "Content-Type": "application/json",
              'Authorization': localStorage.getItem('authToken')
              }
              });
  
              //The code takes in a response object from an API call, sorts the data by user ID, and checks if the user with the highest ID exists in the data.
              const userData = await userResponse.json();
              console.log('User data:', userData);
              //If the data is not an array or has no elements, the code logs an error message and returns undefined.
  
              const desiredAccessToken = localStorage.getItem('authToken');
  
              for (const user of userData) {
                  if (user.accessToken === desiredAccessToken) {
                      console.log(`User is ${user.id}`);
                      this.role = user.role
                      console.log(this.role)
                      localStorage.setItem('role', this.role)
                      break;
                  }
                  // console.log(`users: ${user.id}`)
              }
  
      },
  
      async getData() {
        const response = await fetch("http://localhost:8080/loans");
        const data = await response.json();
        this.loans = data;
      }
    },
    mounted() {
      this.getData();
      this.isAdmin();
      console.log(localStorage)
    }
  };
  </script>
  
  <style scoped>
  h6 {
    font-size: 0.8rem;
  }
  
  i {
    color: blue;
  }
  
  .red {
    color: red;
  }
  
  .green {
    color: green;
  }
  
  .copy {
    display: flex;
    flex-direction: row;
    width: 100%;
    /* border: 1px solid #111; */
    margin-bottom: 12px;
    padding: 12px 18px;
  }
  
  .copy:first-child {
    margin-top: 24px;
  }
  
  .copy * {
    flex: 1 1 0;
  }
  
  button.loan-btn:disabled {
    background-color: white;
    color: red;
    border: 1px solid red;
    opacity: 0.3;
  }
  
  .loan-btn {
    background-color: white;
    color: green;
    border: 1px solid green;
    padding: 4px 16px;
    transition: .2s ease-in-out;
  }
  
  .loan-btn:hover {
    background-color: green;
    color: white;
    transition: 0.2s ease-in-out;
  }
  
  .bold h6 {
    font-weight: 800 !important;
  }
  
  .btn-red {
    background-color: rgb(231, 27, 27);
    color: #eee;
    border: 1px solid rgb(231, 27, 27);
  }
  
  .btn-red:hover {
    background-color: rgb(231, 27, 27);
  }
  </style>
  