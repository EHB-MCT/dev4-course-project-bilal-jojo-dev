<template>
    <div>
      <form @submit.prevent="createItem">
        <label for="name">Item Name:</label>
        <input type="text" id="name" v-model="name">

        <label for="brand">Item Brand:</label>
        <input type="text" id="brand" v-model="brand">

        <button type="submit">Create Item</button>
      </form>

      <form @submit.prevent="createCopy">
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
      } catch (error) {
        console.error('Error:', error);
      }
    },
  },
};
</script>