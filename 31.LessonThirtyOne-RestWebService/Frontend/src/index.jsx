import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import AppComponent from "./components/AppComponent";
import { store } from "./store/store";

ReactDOM.render(
    <Provider store={store}>
        <AppComponent />
    </Provider>, document.getElementById("app"));
