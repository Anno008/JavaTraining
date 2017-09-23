import { FETCHING_COUNTRIES, FETCHING_COUNTRIES_SUCCESS, FETCHING_COUNTRIES_FAILURE } from "../constants.js";

export const CountryReducer = (state = {}, action) => {
    switch (action.type) {
        case FETCHING_COUNTRIES:
            return { ...state, data: [], isFetching: true };
        case FETCHING_COUNTRIES_SUCCESS:
            return { ...state, data: action.data, error: false, isFetching: false };
        case FETCHING_COUNTRIES_FAILURE:
            return { ...state, data: [], error: true, isFetching: false };
        default:
            return { ...state };
    }
};