<template>
  <div class="container">
    <b-modal ref="my-modal" id="modal-lg" size="lg" hide-footer title="Delete">
      <h2>Are you sure you want to delete phase <span style="color:red;">{{phaseItem.id}}</span>? </h2>
      <b-button class="mt-3" variant="outline-danger" block v-on:click="deletePhase()">Delete</b-button>
      <b-button class="mt-2" variant="outline-warning" block v-on:click="hideModal()">Cancel</b-button>
    </b-modal>
  </div>
</template>

<script>
import PhaseDataService from "../services/PhaseDataService";

export default {
  name: "DeleteModal",

  data() {
    return {
      phaseItem: { id: "" },
    };
  },

  methods: {
    showModal(id) {
      PhaseDataService.retrievePhase(id).then((response) => {
        this.phaseItem = response.data;
      });
      this.$refs["my-modal"].show();
    },
    hideModal() {
      this.$refs["my-modal"].hide();
    },
    deletePhase() {
      PhaseDataService.deletePhase(this.phaseItem.id).then(() => {
        this.hideModal();
        this.$emit("success");
        this.$emit("success-toastr");
      });
    },
  },
};
</script>

<style scoped>
</style>