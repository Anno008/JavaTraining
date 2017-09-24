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

export const getByName = (name) => {
    return Api.apiCall({
            url: `${apiUrl}/cities/${name}`
        });
};

export const create = (city) => {
    return Api.apiCall({
        url: `${apiUrl}/cities`,
        method: "POST",
        body: JSON.stringify(city)
    });
};

export const update = (city) => {
    return Api.apiCall({
        url: `${apiUrl}/cities/${city.id}`,
        method: "PUT",
        body: JSON.stringify(city)
    });
};

export const deleteCity = (cityId) => {
    return Api.apiCall({
        url: `${apiUrl}/cities/${cityId}`,
        method: "DELETE"
    });
};