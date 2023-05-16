
<template>
  <div>
    <h3>
      <div class="copy bold">
        <h6>Serial</h6>
        <h6>Exemplaar</h6>
        <h6>Item</h6>
        <h6>Brand</h6>
        <h6>Beschikbaar</h6>
        <h6>Reserveer</h6>
        <h6 v-if="role == 'admin'">Delete</h6>
      </div>
      <div class="copy" v-for="copy in copies" :key="copy.id">
        <h6>{{ copy.serial }}</h6>
        <h6>{{ copy.name }}</h6>
        <h6>{{ copy.item.name }}</h6>
        <h6>{{ copy.item.brand }}</h6>
        <h6 v-if="copy.status == true">
          <font-awesome-icon icon="fa-solid fa-xmark" class="red" />
        </h6>
        <h6 v-if="copy.status == false">
          <font-awesome-icon icon="fa-solid fa-check" class="green" />
        </h6>
        <h6 v-if="copy.status == false">
          <button class="loan-btn" @click="reserve(copy.id)">Reserveer</button>
        </h6>
        <h6 v-if="copy.status == true">
          <button class="loan-btn" @click="reserve(copy.id)" disabled>Reserveer</button>
        </h6>
        <h6 v-if="role == 'admin'"><button class="loan-btn btn-red" @click="deleteItem(copy.id)"><font-awesome-icon icon="fa-solid fa-trash" /></button></h6>
      </div>
    </h3>
  </div>
</template>

<script>
export default {
  props: ['reserveItem'], 

  data() {
    return {
      copies: [],
      role: '',
      itemDelete: ''
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

            const desiredAccessToken = localStorage.getItem('authToken')

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
      const response = await fetch("http://localhost:8080/copy");
      const data = await response.json();
      this.copies = data;
    },
    reserve(key) {
      localStorage.setItem('itemId', key);
      this.reserveItem(); //
    },

    async deleteItem(id) {

        const deleteResp = await fetch(`http://localhost:8080/copy/${id}`, {
          method: 'DELETE',
        });

        // const deleteData = await deleteResp.json();
        this.getData()

      console.log(id)
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
h3 {
  font-size: 1.2rem;
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
