import React from "react";
import "bulma/css/bulma.css";
import { store } from "../store/store";
import { deleteCityAction } from "../actions/CityActions";

const CityComponent = (props) => {
    return (
        <div className="card">
            <header className="card-header">
                <p className="card-header-title"></p>
                <a href="#" className="card-header-icon" aria-label="more options">
                    <span className="icon">
                        <i className="fa fa-angle-down" aria-hidden="true"></i>
                    </span>
                </a>
            </header>
            <div className="card-content">
                <div className="content">
                    {props.city.name}, {props.city.country.name}

                </div>
                <footer className="card-footer">
                    <a href="#" className="card-footer-item">Save</a>
                    <a href="#" className="card-footer-item">Edit</a>
                    <a href="#" className="card-footer-item" onClick={() => {
                        const res = confirm(`Are you sure you want to delete the city: ${props.city.name}?`);
                        if (res) {
                            store.dispatch(deleteCityAction(props.city.id));
                        }
                    }}>Delete</a>
                </footer>
            </div>
        </div >
    );
};


export default CityComponent;