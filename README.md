# Setup project
- Install java, maven, and docker in your machine
- Run: `docker compose up -d` to start Postgres and Redis
- Run: `mvn spring-boot:run -Dspring-boot.run.main-class=com.vantutran2k1.todoapp.migration.ToDoAppMigration` to migrate database
- Run: `mvn spring-boot:run -Dspring-boot.run.main-class=com.vantutran2k1.todoapp.api.ToDoAppApplication` to start the web server

# Database design
<img width="738" alt="image" src="https://github.com/user-attachments/assets/d453ea4f-bc91-41e7-8b0c-b180a8cb5982" />

