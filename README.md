Демонстрационный проект тестирования сервиса "reqresApi". Сваязка Java/Maven/Restassured/Junit/jackson
Цель - демонстрация общей структуры проекта автотестов на примере нескольких тестов.

В проекте реализованы:
  - pojo классы для определения модели данных запросов и ответов
  - тесты на поверку значений в ответе сервиса
  - тесты на валидацию json схемы
  - файл app.conf для хранения ендпоинтов и других значений, а так же класс AppProvider для работы с ними
  - реализованы спецификации и методы отправки запросов для отделения реализации и логики автотеста.
 
