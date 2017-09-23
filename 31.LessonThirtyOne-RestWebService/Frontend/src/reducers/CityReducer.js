import { FETCHING_CITIES, FETCHING_CITIES_SUCCESS, FETCHING_CITIES_FAILURE } from "../constants.js";

export const CityReducer = (state = {}, action) => {
    switch (action.type) {
        case FETCHING_CITIES:
            return { ...state, data: [], isFetching: true };
        case FETCHING_CITIES_SUCCESS:
            return { ...state, data: action.data, error: false, isFetching: false };
        case FETCHING_CITIES_FAILURE:
            return { ...state, data: [], error: true, isFetching: false };
        default:
            return { ...state };
    }
};