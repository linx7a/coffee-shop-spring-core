# Coffee Shop

Консольное Java-приложение на чистом Spring Framework (без Spring Boot), созданное для практики и демонстрации основных возможностей Spring.

## О проекте

Проект создан как учебное упражнение, чтобы понять, как Spring работает «под капотом», без автоконфигурации Spring Boot. Каждый бин, сканирование компонентов и AOP-прокси настроены вручную.

## Что изучалось

- **IoC-контейнер** — ручная настройка через `AnnotationConfigApplicationContext`
- **Внедрение зависимостей (DI)** — через конструктор (`OrderService` зависит от `Barista`)
- **Сканирование компонентов** — `@ComponentScan` вместе с `@Configuration`
- **AOP** — `@Aspect` с советом `@Around` для логирования времени приготовления и итогов заказа
- **Внешняя конфигурация** — `@Value` с `@PropertySource` и `application.properties`
- **Логирование SLF4J** — замена `System.out.println` на полноценное логирование

## Технологии

- Java 18
- Spring Framework 7.0.8
- AspectJ Weaver 1.9.22
- SLF4J Simple 2.0.18
- JUnit 5 + Mockito 5 (юнит-тесты)
- Maven

## Как запустить

1. Склонируйте репозиторий
2. Откройте проект в IntelliJ IDEA как Maven-проект
3. Дождитесь загрузки зависимостей
4. Запустите `Main.java`

## Структура проекта

```
src/main/java/coffeeshop/
├── AppConfig.java        # конфигурация Spring
├── Main.java             # точка входа
├── Coffee.java           # enum с позициями меню и ценами
├── Order.java            # модель заказа
├── Barista.java          # сервис: готовит кофе
├── OrderService.java     # сервис: обрабатывает заказы
└── LoggingAspect.java    # AOP: логирует время приготовления и итоги заказа

src/test/java/coffeeshop/
├── OrderTest.java            # юнит-тесты для Order
└── OrderServiceTest.java     # юнит-тесты для OrderService (Mockito)
```

## Пример работы

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