<template>
  <div class="container">
    <b-modal ref="my-modal" id="modal-lg" size="lg" hide-footer title="Update Phase">
      <form @submit="checkForm">
        <div v-if="booleanAttribute">
          <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errors">{{ error }}</div>
        </div>
        <b-row class="form-group">
          <label class="col-md-2 col-form-label form-control-label">Id</label>
          <b-col md="10">
            <input type="text" class="form-control" v-model="phaseItem.id" disabled />
          </b-col>
        </b-row>
        <b-row class="form-group">
          <label class="col-md-2 col-form-label form-control-label">Name</label>
          <b-col md="10">
            <input type="text" class="form-control" v-model="phaseItem.name" />
          </b-col>
        </b-row>
        <b-row class="form-group">
          <label class="col-md-2 col-form-label form-control-label">Description</label>
          <b-col md="10">
            <input type="text" class="form-control" v-model="phaseItem.description" />
          </b-col>
        </b-row>
      </form>
      <b-button class="mt-3" variant="outline-success" block v-on:click="updatePhase()">Save</b-button>
      <b-button class="mt-2" variant="outline-warning" block v-on:click="hideModal()">Cancel</b-button>
    </b-modal>
  </div>
</template>

<script>
import PhaseDataService from "../services/PhaseDataService";

export default {
  name: "UpdatePhaseModal",

  data() {
    return {
      phaseItem: { id: "", name: "", description: "" },
      errors: [],
      booleanAttribute: false,
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
    updatePhase() {
      if (this.checkForm()) {
        PhaseDataService.updatePhase(this.phaseItem.id, {
        id: this.phaseItem.id,
        name: this.phaseItem.name,
        description: this.phaseItem.description,
      }).then(() => {
        this.hideModal();
        this.$emit("success");
        this.$emit("success-toastr");
      });
      }
    },
    checkForm() {
      if (this.phaseItem.name && this.phaseItem.description) {
        return true;
      }

      this.errors = [];
      this.booleanAttribute = true;

      if (!this.phaseItem.name) {
        this.errors.push('Name required.');
      }
      if (!this.phaseItem.description) {
        this.errors.push('Description required.');
      }
    },
  },
};
</script>

<style scoped>
</style>