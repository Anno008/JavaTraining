import React from "react";
import CitiesComponent from "./CitiesComponent";
import CountriesComponent from "./CountriesComponent";
import { fetchCities } from "../actions/CityActions";
import { fetchCountries } from "../actions/CountryActions";

import "bulma/css/bulma.css";
import "../css/app.css";
import { BrowserRouter, Route, Link } from "react-router-dom";

class AppComponent extends React.Component {
    constructor() {
        super();
    }

    render() {
        return (
            <div>
                <div className="nav"></div>
                <div className="content">
                    <BrowserRouter>
                        <div className="container content">
                            <div className="links">
                                <Link to="/cities">Cities</Link>
                                <Link to="/countries">Countries</Link>                                
                            </div>
                            <Route path="/cities" component={CitiesComponent} />
                            <Route path="/countries" component={CountriesComponent} />
                        </div>
                    </BrowserRouter>
                </div>

            </div>
        );
    }
}

export default AppComponent;