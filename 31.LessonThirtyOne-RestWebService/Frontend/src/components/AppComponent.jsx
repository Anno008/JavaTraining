import React from "react";
import CitiesComponent from "./CitiesComponent";
import { fetchCities } from "../actions/CityActions";
import "bulma/css/bulma.css";
import "../css/app.css";

class AppComponent extends React.Component {
    constructor() {
        super();
        fetchCities();
    }

    render() {
        return (
            <div>
                <div className="nav"></div>
                <div className="section">

                    <div className="container content">
                        <CitiesComponent />
                    </div>
                </div>
                
            </div>
        );
    }
}

export default AppComponent;