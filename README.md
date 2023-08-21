# QuizApplication - Microservices Quiz Application

Welcome to the QuizApplication repository! This microservices-based quiz application consists of two services: the Question Service and the Quiz Service. It enables users to perform various operations like creating, updating, deleting, and retrieving questions. Additionally, users can take quizzes, attempt questions, and receive scores through the Quiz Service. The application is built using Java and the Spring ecosystem, including Spring Boot, Spring MVC, Spring Data JPA, Eureka Server for service registry, Feign for microservice communication, and load balancing for optimized performance.

**Made by YASHWANT456** - [GitHub Profile](https://github.com/YASHWANT456)

## Table of Contents

- [Services](#services)
  - [Question Service](#question-service)
  - [Quiz Service](#quiz-service)
- [Service Registry](#service-registry)
- [API Gateway](#api-gateway)
- [Load Balancing](#load-balancing)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Contributing](#contributing)


## Services

### Question Service

The Question Service is responsible for handling CRUD (Create, Read, Update, Delete) operations related to questions. Users can create, update, delete, and retrieve questions using the provided APIs.

### Quiz Service

The Quiz Service allows users to take quizzes, attempt questions, and retrieve their scores. Users can submit their answers, and the service will calculate the score based on the answers provided.

## Service Registry

The Eureka Server is used for service registration and discovery. It enables microservices to locate and communicate with each other without hard-coded URLs. This dynamic discovery enhances the flexibility and scalability of the application.

## API Gateway

The API Gateway serves as a single entry point for external requests to the microservices. It provides a unified interface for clients to access the functionalities of both the Question Service and the Quiz Service. The API Gateway also handles authentication, rate limiting, and other cross-cutting concerns.

## Load Balancing

Load balancing is implemented to distribute incoming network traffic across multiple instances of a service. This ensures high availability and optimal resource utilization, ultimately improving the performance and reliability of the application.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Eureka Server (Service Registry)
- Feign (Declarative HTTP client)
- API Gateway
- Load Balancing

## Getting Started

To begin with the QuizApplication, follow these steps:

1. Clone this repository to your local machine.
2. Navigate to the root directory of each service (Question Service, Quiz Service, API Gateway) and follow their respective setup instructions.
3. Run the Eureka Server to enable service discovery.
4. Launch the Question Service, Quiz Service, and API Gateway.
5. Access the API Gateway endpoint to interact with the application.

Refer to the individual service directories for more detailed instructions on setting up each service.

## Contributing

Contributions are welcome! To contribute to the QuizApplication project:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and ensure thorough testing.
4. Commit your changes with clear commit messages.
5. Push your changes to your fork.
6. Create a pull request to the `main` branch of this repository.

**Made by YASHWANT456** - [GitHub Profile](https://github.com/YASHWANT456)
