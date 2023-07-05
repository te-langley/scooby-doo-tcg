import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000/"
});

export default {
    createInstances(run) {
        return http.post('/instance', run);
    },
    getInstance(serial) {
        return http.get('/instance', { params: { serial } });
    },
    unlock(serial) {
        return http.put('/instance', serial);
    },
    release(serial) {
        return http.put('/instance', serial);
    },

}