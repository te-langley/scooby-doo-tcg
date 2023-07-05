import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000/"
});

export default {
    claim(serial) {
        return http.post('/collector', serial)
    },
    release(serial) {
        return http.delete('/collector', serial)
    }
}