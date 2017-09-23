import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import AppComponent from "./components/AppComponent";
import { store } from "./store/store";
import {fetchCities} from "./actions/CityActions";

ReactDOM.render(
    <Provider store={store}>
        <AppComponent />
    </Provider>, document.getElementById("app"));

store.dispatch(fetchCities());