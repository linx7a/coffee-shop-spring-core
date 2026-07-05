# Coffee Shop

A console-based Java application built with pure Spring Framework (without Spring Boot) to practice and demonstrate core Spring concepts.

## About

This project was created as a learning exercise to understand how Spring works under the hood, without the auto-configuration magic of Spring Boot. Every bean, component scan, and AOP proxy is configured manually.

## Concepts Covered

- **IoC Container** — manual setup via `AnnotationConfigApplicationContext`
- **Dependency Injection** — constructor-based DI (`OrderService` depends on `Barista`)
- **Component Scanning** — `@ComponentScan` with `@Configuration`
- **AOP** — `@Aspect` with `@Around` advice for logging brew time and order summary
- **External Configuration** — `@Value` with `@PropertySource` and `application.properties`
- **SLF4J Logging** — replacing `System.out.println` with proper logging

## Tech Stack

- Java 18
- Spring Framework 7.0.8
- AspectJ Weaver 1.9.22
- SLF4J Simple 2.0.18
- JUnit 5 + Mockito 5 (unit tests)
- Maven

## How to Run

1. Clone the repository
2. Open in IntelliJ IDEA as a Maven project
3. Wait for dependencies to load
4. Run `Main.java`

## Project Structure
```
src/main/java/coffeeshop/
├── AppConfig.java        # Spring configuration
├── Main.java             # Entry point
├── Coffee.java           # Enum with menu items and pricing
├── Order.java            # Order model
├── Barista.java          # Service: prepares coffee
├── OrderService.java     # Service: processes orders
└── LoggingAspect.java    # AOP: logs brew time and order summary

src/test/java/coffeeshop/
├── OrderTest.java            # Unit tests for Order
└── OrderServiceTest.java     # Unit tests for OrderService (Mockito)
```
## Sample Output
```
Добро пожаловать в Fifth Cup!
CAPPUCCINO готовится...
Готов!
[main] INFO coffeeshop.LoggingAspect - Время: 502 мс
AMERICANO готовится...
Готов!
[main] INFO coffeeshop.LoggingAspect - Время: 507 мс
Ваш заказ готов. Итого: 690.00 руб.
[main] INFO coffeeshop.LoggingAspect - Время обработки заказа: 1518 мс
```