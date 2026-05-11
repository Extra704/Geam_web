import axios from "axios";
import { getToken } from "../utils/auth";

const service = axios.create({
  baseURL: "/api",
  timeout: 10000
});

service.interceptors.request.use((config) => {
  const token = getToken();
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default service;
