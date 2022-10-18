## User
* ### How To Run
  * To first start the User microservice run the [Server](https://github.com/mhdzaid/server) as well as the [Gateway](https://github.com/mhdzaid/gateway) so that the Eureka Discovery service can register it.
  * Run the `PostgreSQL` docker-compose file using the command
  ```
  docker-compose -f util/postgres.yml up -d

    ```
  * You would also need to start up the [Location-Reader](https://github.com/mhdzaid/location-reader) microservice as well.
