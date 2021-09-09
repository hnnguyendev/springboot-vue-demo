import { HTTP } from '../http-common';

class PhaseDataService {

    // Call the REST API with the GET method
    retrieveAllPhases() {
        return HTTP.get(`/phases`);
    }

    deletePhase(id) {
        return HTTP.delete(`/phase/${id}`);
    }

    retrievePhase(id) {
        return HTTP.get(`/phase/${id}`);
    }

    updatePhase(id, phase) {
        return HTTP.put(`/phase/${id}`, phase);
    }

    addPhase(phase) {
        return HTTP.post(`/phase/`, phase);
    }



}

// creating an instance of PhaseDataService and making it available for other components
export default new PhaseDataService();