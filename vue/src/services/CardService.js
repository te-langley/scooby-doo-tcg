import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000/"
});

export default {
    list() {
        return http.get('/api/scooby-cards');
    },
    get(id) {
        return http.get(`/api/scooby-cards/${id}`);
    },
    post(card) {
        return http.post('/api/scooby-cards', card)
    }
}