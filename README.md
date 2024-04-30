# account-service
Стек:  **Java 21, Spring Boot 3.1.11, Maven, PostgreSQL 15.0, REST,  JUnit, Liquibase, H2.**

### Запуск приложения

Чтобы запустить приложение необходимо
* Скачать или клонировать репозиторий

* Командой развернуть БД в Docker
```bash
docker run --name some-postgres -e POSTGRES_PASSWORD=pass -p 5432:5432 -d postgres
```

* Запустить проект
