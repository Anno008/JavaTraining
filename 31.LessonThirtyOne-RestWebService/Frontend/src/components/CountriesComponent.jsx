import React from "react";
import { connect } from "react-redux";
import CountryComponent from "./CountryComponent";
import "bulma/css/bulma.css";
import "../css/cities.css";
import { fetchCountriesByName } from "../actions/CountryActions";

const CountriesComponent = (props) => {
    return (
        <div className="container">
            <input className="input" type="text" placeholder="Country name"
                onChange={(e) => props.fetchCountriesByName(e.target.value)} />
            {props.countriesState.data ? props.countriesState.data.map(c =>
                <div className="column is-half float" key={c.id}>
                    <CountryComponent country={c} />
                </div>
            ) : ""}
        </div>
    );
};

const mapStateToProps = (state) => ({
    countriesState: state.countriesState,
});

const mapDispatchToProps = (dispatch) => ({
    fetchCountriesByName: (name) => dispatch(fetchCountriesByName(name)),
});

export default connect(mapStateToProps, mapDispatchToProps)(CountriesComponent);