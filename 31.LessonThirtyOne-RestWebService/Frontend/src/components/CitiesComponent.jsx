import React from "react";
import { connect } from "react-redux";
import CityComponent from "./CityComponent";
import "bulma/css/bulma.css";
import "../css/cities.css";

const CitiesComponent = (props) => {
    return (
        <div className="container">
            {props.citiesState.data ? props.citiesState.data.map(c =>
                <div className="column is-half float">
                        <CityComponent city={c} key={c.id} />
                </div>
            ) : ""}
        </div>
    );
};

const mapStateToProps = (state) => ({
    citiesState: state.citiesState,
});

const mapDispatchToProps = (dispatch) => ({
});

export default connect(mapStateToProps, mapDispatchToProps)(CitiesComponent);