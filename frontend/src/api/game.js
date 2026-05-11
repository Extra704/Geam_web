import request from "./request";

export function getGames() {
  return request.get("/games");
}

export function getGameDetail(id) {
  return request.get(`/games/${id}`);
}

export function submitScore(data) {
  return request.post("/scores", data);
}
