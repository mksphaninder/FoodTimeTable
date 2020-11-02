# SpringBoot Project
- The application runs on the port:8080
- Add the following dependency for successful Postgres DB connection

    ```XML
  <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
  ```
- application.properties
```properties
## DB details
spring.datasource.url = jdbc:postgresql://localhost:5432/food-timetable
spring.datasource.username = root
spring.datasource.password = rootbeer
spring.datasource.driver-class-name=org.postgresql.Driver
#
#spring.jpa.database-platform = org.hibernate.dialect.PostgreSQL94Dialect
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL95Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto = create-drop
spring.jpa.hibernate.naming.implicit-strategy = org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl
spring.jpa.properties.hibernate.format_sql=true

# Logging
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=ERROR

enableLoggingRequestDetails=true

```
  
  ## Food-timetable schema
  ### Tables
  - Food_items
  - Food_type
  - items_schedule
  
  ### Relations
- food_item maps item_schedule 
```Java
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodItem")
      List<ItemSchedule> itemSchedule;
  ```
- food_type maps item_schedule
```Java
 @OneToMany(fetch = FetchType.LAZY, mappedBy = "foodType")
    private List<ItemSchedule> itemSchedules;
```