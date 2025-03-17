import axios from 'axios';

const API_URL = "http://localhost:8080/api"; // Your Spring Boot backend URL

export const getCars = async () => {
    return axios.get(`${API_URL}/cars`);
};

export const addCar = async (car) => {
    return axios.post(`${API_URL}/cars`, car);
};

