<template>
  <div>
    <Items :reserveItem="reserveItem" />
  </div>
</template>

<script>
import Items from '../components/Items.vue';

export default {
  components: {
    Items
  },
  methods: {
    reserveItem(copy) {
      this.$router.push({ name: 'loan' });
    }
  }
}
</script>



