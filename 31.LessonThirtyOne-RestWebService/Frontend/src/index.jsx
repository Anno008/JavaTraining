import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import AppComponent from "./components/AppComponent";
import { store } from "./store/store";
import { fetchCities } from "./actions/CityActions";
import { fetchCountries } from "./actions/CountryActions";


ReactDOM.render(
    <Provider store={store}>
        <AppComponent />
    </Provider>, document.getElementById("app"));

store.dispatch(fetchCities());
store.dispatch(fetchCountries());