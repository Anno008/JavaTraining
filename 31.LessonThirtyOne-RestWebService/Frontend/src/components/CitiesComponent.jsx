import React from "react";
import { connect } from "react-redux";
import CityComponent from "./CityComponent";
import "bulma/css/bulma.css";
import "../css/cities.css";
import { fetchCitiesByName } from "../actions/CityActions";

const CitiesComponent = (props) => {
    return (
        <div className="container">
               <input className="input" type="text" placeholder="City name"
                onChange={(e) => props.fetchCitiesByName(e.target.value)} />
            {props.citiesState.data ? props.citiesState.data.map(c =>
                <div className="column is-half float" key={c.id}>
                    <CityComponent city={c} />
                </div>
            ) : ""}
        </div>
    );
};

const mapStateToProps = (state) => ({
    citiesState: state.citiesState,
});

const mapDispatchToProps = (dispatch) => ({
    fetchCitiesByName: (name) => dispatch(fetchCitiesByName(name)),
});

export default connect(mapStateToProps, mapDispatchToProps)(CitiesComponent);