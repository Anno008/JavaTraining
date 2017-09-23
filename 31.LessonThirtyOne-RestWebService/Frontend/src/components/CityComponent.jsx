import React from "react";
import { connect } from "react-redux";
import "bulma/css/bulma.css";

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
                    <a href="#" className="card-footer-item">Delete</a>
                </footer>
            </div>
        </div>
    );
};


export default CityComponent;