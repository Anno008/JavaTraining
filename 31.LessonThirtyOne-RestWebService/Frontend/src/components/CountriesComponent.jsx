import React from "react";
import { connect } from "react-redux";
import CountryComponent from "./CountryComponent";
import "bulma/css/bulma.css";
import "../css/cities.css";

const CountriesComponent = (props) => {
    return (
        <div className="container">
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
});

export default connect(mapStateToProps, mapDispatchToProps)(CountriesComponent);