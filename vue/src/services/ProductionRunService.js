import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000/"
});

export default {
    list() {
        return http.get('/production-runs');
    },
    get(id) {
        return http.get(`/production-runs/${id}`)
    },
    getForProduct(id) {
        return http.get(`/production-runs/product/${id}`)
    },
    post(run) {
        return http.post('/production-runs', run)
    },
    updateStatus(id, status) {
        return http.put(`/production-runs/${id}`, status, { headers: { 'Content-Type': 'text/plain' } })
    }
}