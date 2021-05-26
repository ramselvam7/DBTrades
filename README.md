# DBTrades

This is a sample assignment for persisting trade details.

Features and assumptions:

-The trade flow assignment is built using springboot framework.

-Once the application is started, it can be accesses through http://localhost:8008

-The trade details are entered by the user using a simple UI page.

-The application uses the same UI for both creating new trade and updating the existing trade details.

-The existing trade details are identified using the Trade ID value.

-The application uses embedded H2 database for storing the trade details.

-The persisted trade details can be accessed through the H2 database using the URL http://localhost:8008/h2-console

-If an existing trade with higher version is entered, then it will be updated successfully,

-If an existing trade with same version is entered, then it will be updated successfully.

-If a existing trade with lower version than the current version is entered, then it will be not be saved.

-If a new trade with with maturity date less than today's date is entered, the the trade details will not be created.

-If a new version of an already existing trade is persisted with maturity date less than today's date, then the maturity indicator will be set to "N". 

-This MVC application can be enhanced to a CRUD REST API using the appropriate web annotations.

