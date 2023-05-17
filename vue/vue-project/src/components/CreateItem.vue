<template>
    <div v-if="role == 'admin'" class="login">
      <form @submit.prevent="createItem">
        <h2></h2>
        <label for="name">Item Name:</label>
        <input type="text" id="name" v-model="name">

        <label for="brand">Item Brand:</label>
        <input type="text" id="brand" v-model="brand">

        <button type="submit">Create Item</button>
      </form>

      <form v-if="role == 'admin'" @submit.prevent="createCopy">
        <h2>Create a copy for an item</h2>
        <label for="copyName">Copy Name:</label>
        <input type="text" id="copyName" v-model="copyName">

        <label for="copyRemarks">Copy Remarks:</label>
        <input type="text" id="copyRemarks" v-model="copyRemarks">

        <label for="copyStatus">Copy Status:</label>
        <input type="checkbox" id="copyStatus" v-model="copyStatus">

        <label for="copySerial">Copy Serial:</label>
        <input type="number" id="copySerial" v-model="copySerial">

        <label for="itemId">Item ID:</label>
        <select id="itemId" v-model="itemId">
          <option v-for="item in items" :value="item.id" :key="item.id">
            {{ item.name }} - {{ item.brand }}
          </option>
        </select>

        <button type="submit">Create Copy</button>
      </form>
    </div>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      brand: '',
      copyName: '',
      copyRemarks: '',
      copyStatus: true,
      copySerial: 123,
      itemId: null,
      items: [],
      role: localStorage.getItem('role')
    };
  },
  async created() {
    try {
      const response = await fetch('http://localhost:8080/items', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      this.items = await response.json();
    } catch (error) {
      console.error('Error:', error);
    }
  },
  methods: {
    async createItem() {
      try {
        const response = await fetch('http://localhost:8080/items', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            name: this.name,
            brand: this.brand,
          }),
        });

        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        console.log(data);  
        this.$router.push('/CreateItem');
      } catch (error) {
        console.error('Error:', error);
      }
    },
    async createCopy() {
      try {
        const response = await fetch('http://localhost:8080/copy', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            name: this.copyName,
            remarks: this.copyRemarks,
            status: this.copyStatus,
            serial: this.copySerial,
            Item: this.itemId,
          }),
        });

        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        console.log(data);  
        this.$router.push('/items');
      } catch (error) {
        console.error('Error:', error);
      }
    },
  },
};
</script>

<style scoped>
.login {
  width: 100%;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #00BCD4;
  background-color: #E0F7FA;
  border-radius: 10px;
}

.login h2 {
  text-align: center;
  color: #00BCD4;
}

.login .input-field {
  position: relative;
  margin: 20px 0;
}

.login .input-field label {
  position: absolute;
  top: -20px;
  left: 0;
  color: #00BCD4;
}

.login input {
  width: 100%;
  padding: 10px;
  box-sizing: border-box;
  border-radius: 5px;
  border: 1px solid #00BCD4;
}

.login input:focus {
  outline: none;
  border-color: #0097A7;
}

.login button {
  display: block;
  width: 100%;
  padding: 10px;
  margin-top: 30px;
  background-color: #00BCD4;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.login button:hover {
  background-color: #0097A7;
}

.login p {
  color: #F44336;
  text-align: center;
  margin-top: 20px;
}

</style>
  