<template>
  <div class="container">
    <h1>All Phases</h1>
    <div class="container">
      <div>
        <add-phase-modal
          ref="addPhaseModal"
          @success="addSuccess"
          @success-toastr="addSuccesstoastr"
        ></add-phase-modal>
      </div>
      <div>
        <update-phase-modal
          ref="updatePhaseModal"
          @success="addSuccess"
          @success-toastr="updateSuccesstoastr"
        ></update-phase-modal>
      </div>
      <div>
        <delete-modal ref="deleteModal" @success="addSuccess" @success-toastr="deleteSuccesstoastr"></delete-modal>
      </div>
      <div class="row">
        <button class="btn btn-success" v-on:click="showAddModal()">Add</button>
      </div>
      <table class="table table-striped">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="phase in phases" v-bind:key="phase.id">
            <th>{{ phase.id }}</th>
            <td>{{ phase.name }}</td>
            <td>{{ phase.description }}</td>
            <td>
              <b-button class="btn btn-success" v-on:click="showUpdateModal(phase.id)">Update</b-button>
            </td>
            <td>
              <b-button class="btn btn-warning" v-on:click="showDeleteModal(phase.id)">Delete</b-button>
            </td>
          </tr>
        </tbody>
      </table>
      <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="my-table"
      ></b-pagination>
    </div>
  </div>
</template>

<script>
import PhaseDataService from "../services/PhaseDataService";
import AddPhaseModal from "../components/AddPhaseModal";
import UpdatePhaseModal from "../components/UpdatePhaseModal";
import DeleteModal from "../components/DeleteModal";

export default {
  name: "PhasesList",

  data() {
    return {
      phases: [],
    };
  },

  components: {
    addPhaseModal: AddPhaseModal,
    updatePhaseModal: UpdatePhaseModal,
    deleteModal: DeleteModal,
  },

  methods: {
    refreshPhases() {
      // This would make the call to the REST API. We can define how to process the response in the then method
      PhaseDataService.retrieveAllPhases().then((response) => {
        this.phases = response.data;
      });
    },
    showAddModal() {
      this.$refs.addPhaseModal.showModal();
      this.$refs.addPhaseModal.booleanAttribute = false;
    },
    showUpdateModal(id) {
      console.log(id);
      this.$refs.updatePhaseModal.showModal(id);
      this.$refs.updatePhaseModal.booleanAttribute = false;
    },
    showDeleteModal(id) {
      this.$refs.deleteModal.showModal(id);
    },
    addSuccess() {
      this.refreshPhases();
    },
    addSuccesstoastr() {
      this.$bvToast.toast("Phase Added Successfully.", {
        title: "Success Alert",
        variant: "success",
        solid: true,
      });
    },
    updateSuccesstoastr() {
      this.$bvToast.toast("Phase Updated Successfully.", {
        title: "Success Alert",
        variant: "success",
        solid: true,
      });
    },
    deleteSuccesstoastr() {
      this.$bvToast.toast("Phase Deleted Successfully.", {
        title: "Success Alert",
        variant: "success",
        solid: true,
      });
    },
  },

  // Vue defines a component lifecycle created will be called as soon as the component is mounted.
  // calling refreshPhases as soon as a component is mounted.
  created() {
    this.refreshPhases();
  },
};
</script>

<style scoped>
</style>