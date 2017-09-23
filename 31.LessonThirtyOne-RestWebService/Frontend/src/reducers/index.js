import { combineReducers } from "redux";
import { CityReducer } from "./CityReducer";
import { CountryReducer } from "./CountryReducer";

export const rootReducer = combineReducers({
    citiesState: CityReducer,
    countriesState: CountryReducer
});