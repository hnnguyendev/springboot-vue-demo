<template>
  <div class="container">
    <b-modal ref="my-modal" id="modal-lg" size="lg" hide-footer title="Add New Phase">
      <form @submit="checkForm">
        <div v-if="booleanAttribute">
          <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errors">{{ error }}</div>
        </div>
        <b-row class="form-group">
          <label class="col-md-2 col-form-label form-control-label">Name</label>
          <b-col md="10">
            <input type="text" class="form-control" v-model="name" />
          </b-col>
        </b-row>
        <b-row class="form-group">
          <label class="col-md-2 col-form-label form-control-label">Description</label>
          <b-col md="10">
            <input type="text" class="form-control" v-model="description" />
          </b-col>
        </b-row>
      </form>
      <b-button class="mt-3" variant="outline-success" block v-on:click="createPhase()">Save</b-button>
      <b-button class="mt-2" variant="outline-warning" block v-on:click="hideModal()">Cancel</b-button>
    </b-modal>
  </div>
</template>

<script>
import PhaseDataService from "../services/PhaseDataService";

export default {
  name: "AddPhaseModal",

  data() {
    return {
      name: "",
      description: "",
      errors: [],
      booleanAttribute: false,
    };
  },

  methods: {
    showModal() {
      this.$refs["my-modal"].show();
    },
    hideModal() {
      this.$refs["my-modal"].hide();
      this.name = "";
      this.description = "";
    },
    createPhase() {
      if(this.checkForm()){
        PhaseDataService.addPhase({
        name: this.name,
        description: this.description,
      }).then(() => {
        this.hideModal();
        this.$emit("success");
        this.$emit("success-toastr");
      });
      }
    },
    checkForm() {
      if (this.name && this.description) {
        return true;
      }

      this.errors = [];
      this.booleanAttribute = true;

      if (!this.name) {
        this.errors.push('Name required.');
      }
      if (!this.description) {
        this.errors.push('Description required.');
      }
    },
  },
};
</script>

<style scoped>
</style>