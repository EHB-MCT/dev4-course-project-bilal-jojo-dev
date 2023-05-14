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
      </div>
      <div class="copy" v-for="copy in copies" :key="copy.id">
        <h6>{{ copy.serial }}</h6>
        <h6>{{ copy.name }}</h6>
        <h6>{{ copy.item.name }}</h6>
        <h6>{{ copy.item.brand }}</h6>
        <h6 v-if="copy.status == true">
          <button class="loan-btn" :disabled="true">Reserveer</button>
        </h6>
        <h6 v-if="copy.status == false">
          <button class="loan-btn" @click="reserve(copy)">Reserveer</button>
        </h6>
      </div>
    </h3>
  </div>
</template>

<script>
export default {
  props: ['reserveItem'], 

  data() {
    return {
      copies: []
    };
  },
  methods: {
    async getData() {
      const response = await fetch("http://localhost:8080/copy");
      const data = await response.json();
      this.copies = data;
    },
    reserve(copy) {
      this.reserveItem(copy); //
    }
  },
  mounted() {
    this.getData();
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
</style>
