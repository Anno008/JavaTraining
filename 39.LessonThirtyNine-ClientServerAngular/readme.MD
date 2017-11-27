## Fullstack java application, rest api - angular frontend

## Backend setup
  
  * After cloning the project execute the provided sql script in the sql folder, after that update the application properties to target your local mysql db.
  * Start the application by going to the App class in eclipse and run as java application. The web server should be hosted on localhost:8080.
  * The exposed end points can also be viewed by going to the browser and typing http://localhost:8080/swagger-ui.html

## Frontend setup

  * Install the necessary packages by typing npm install.
  * Type ng build -w to do the following:
    * build the angular app, and publish it to the java webapp folder
    * the -w flag means watch, it will track changes of the angular app and re-build, and publish it again.