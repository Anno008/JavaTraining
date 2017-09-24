import * as Api from "./Api";
import { apiUrl } from "../constants";

export const getAll = () => {
    return Api.apiCall({
            url: `${apiUrl}/countries`
        });
};

export const get = (countryId) => {
    return Api.apiCall({
            url: `${apiUrl}/countries/${countryId}`
        });
};


export const getByName = (name) => {
    return Api.apiCall({
            url: `${apiUrl}/countries?name=${name}`
        });
};

export const getByPopulation = (population, higher) => {
    return Api.apiCall({
            url: `${apiUrl}/countries?name=${name}&higherThan=${higher}`
        });
};

export const create = (country) => {
    return Api.apiCall({
        url: `${apiUrl}/countries`,
        method: "POST",
        body: JSON.stringify(country)
    });
};

export const update = (country) => {
    return Api.apiCall({
        url: `${apiUrl}/countries/${country.id}`,
        method: "PUT",
        body: JSON.stringify(country)
    });
};

export const deleteCity = (countryId) => {
    return Api.apiCall({
        url: `${apiUrl}/countries/${countryId}`,
        method: "DELETE"
    });
};