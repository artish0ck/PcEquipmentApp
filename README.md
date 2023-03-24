A web application that allows you to request computer equipment.

Front end: application type SPA (single page application) with Angular framework;
Back end:  Spring Boot framework with REST interface
DB: PostgreSQL
Additional:  automatic DB migration (Flyway) and automated tests for backend.

To check this app - clone code from this Git repository. Create postgres database with a name "equipment". If your db user and password are not "postgres" change information in file application.properties accordingly.

After this is done, launch equip-app and equip-ui. 

For test data - use SqlTestData.sql file