import { getAll, get } from "../Api/CountriesApi";
import * as action from "../constants";

const getData = () => ({ type: action.FETCHING_COUNTRIES, isFetching: true });
const getDataSuccess = (countries) => ({ type: action.FETCHING_COUNTRIES_SUCCESS, data: countries, isFetching: false });
const getDataFailure = () => ({ type: action.FETCHING_COUNTRIES_FAILURE, error: true, isFetching: false });

export const fetchCountries = () => {
    return (dispatch) => {
        dispatch(getData());
        return getAll()
            .then(result => dispatch(getDataSuccess(result)))
            .catch(_ => dispatch(getDataFailure()));
    };
};
