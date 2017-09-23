import * as Api from "./Api";
import { apiUrl } from "../constants";

export const getAll = () => {
    return Api.apiCall({
            url: `${apiUrl}/cities`
        });
};

export const get = (countryId) => {
    return Api.apiCall(
        {
            url: `${apiUrl}/countries/${countryId}`
        }
    );
};