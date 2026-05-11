import request from "./request";

export function getGlobalRanking() {
  return request.get("/rankings/global");
}
