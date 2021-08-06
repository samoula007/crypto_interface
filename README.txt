This app gets data from currencies and twitter and displays them in a local browser
Refer to "final_Product_v1.png" for the rendered app

Before running the app, go in relative path src\main\js and type in console: "npm install @material-ui/core"
To run it on "http://localhost:8080/", go in the root directory and type in console: "./mvnw spring-boot:run"
Requires: Maven, java, Spring library, Recharts, Material-Ui

You have to wait few seconds before launching localhost, because the data won't show up instantly on "http://localhost:8080/api/dataGetses".
If you launch it too fast, the frontend won't be able to read the 'undefined' data. If you get this error, just wait a few seconds and refresh.
