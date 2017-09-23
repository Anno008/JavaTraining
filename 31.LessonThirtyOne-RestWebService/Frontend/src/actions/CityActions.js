import { getAll, get } from "../Api/CitiesApi";
import * as action from "../constants";

const getData = () => ({ type: action.FETCHING_CITIES, isFetching: true });
const getDataSuccess = (cities) => ({ type: action.FETCHING_CITIES_SUCCESS, data: cities, isFetching: false });
const getDataFailure = () => ({ type: action.FETCHING_CITIES_FAILURE, isFetching: false });

export const fetchCities = () => {
    return (dispatch) => {
        dispatch(getData());
        return getAll()
            .then(result => dispatch(getDataSuccess(result)))
            .catch(_ => dispatch(getDataFailure()));
    };
};
