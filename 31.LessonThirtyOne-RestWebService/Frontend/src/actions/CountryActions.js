import * as countriesApi from "../Api/CountriesApi";
import * as action from "../constants";

const getData = () => ({ type: action.FETCHING_COUNTRIES, isFetching: true });
const getDataSuccess = (cities) => ({ type: action.FETCHING_COUNTRIES_SUCCESS, data: cities, isFetching: false });
const getDataFailure = () => ({ type: action.FETCHING_COUNTRIES_FAILURE, isFetching: false });

export const fetchCountries = () => {
    return (dispatch) => {
        dispatch(getData());
        return countriesApi.getAll().
            then(result =>
                dispatch(getDataSuccess(result))).
            catch(_ => dispatch(getDataFailure()));
    };
};
