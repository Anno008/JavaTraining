import * as Api from "./Api";
import { apiUrl } from "../constants";

export const getAll = () => {
    return Api.apiCall({
            url: `${apiUrl}/cities`
        });
};

export const get = (cityId) => {
    return Api.apiCall({
            url: `${apiUrl}/cities/${cityId}`
        });
};
