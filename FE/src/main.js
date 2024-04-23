import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:8080",
});
instance.interceptors.response.use((config) => {
  return config.data;
});

export default instance;
