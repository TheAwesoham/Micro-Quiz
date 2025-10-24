# 🧩 MicroQuiz 

**MicroQuiz** is a modular quiz platform built using **Spring Boot microservices**, designed to demonstrate a fully distributed system with **service discovery, load balancing, and Feign-based inter-service communication**. The application supports creating quizzes, adding questions with multiple options, submitting answers, and tracking user results.

---

## 🚀 Tech Stack

- **Backend Framework:** Spring Boot
- **API Gateway:** Spring Cloud Gateway
- **Inter-service Communication:** Spring Cloud OpenFeign
- **Service Discovery:** Netflix Eureka 
- **Load Balancing:** Spring Cloud LoadBalancer  
- **Database:** MySQL  
- **API Type:** RESTful APIs

---

## ⚙️ Features

- **Distributed Microservices Architecture**  
  Each service is independent and scalable, using **Spring Cloud Netflix Eureka** for service discovery.

- **API Gateway**  
  Routes requests to the correct microservice and implements **load balancing** using **Spring Cloud LoadBalancer**.

- **Question Service**  
  - Manage questions with **multiple choice options** and correct answers.  
  - Fetch questions by quiz using REST endpoints.  

- **Quiz Service**  
  - Create and manage quizzes.  
  - Fetch quiz questions from Question Service via **Feign Client**.  
  - Submit answers, calculate scores, and send results to Result Service.  

- **Result Service**  
  - Stores and retrieves quiz results per user or per quiz.  
  - Tracks scores and submission timestamps.  

- **Load Balancing & Feign Clients**  
  - Requests routed via API Gateway are load-balanced across multiple instances.  
  - Feign clients enable easy inter-service communication.  

- **Database**  
  - Each service connects to its own **MySQL database**.

---

## 🛠 Microservices & Ports

| Service Name      | Port | Description |
|-------------------|------|-------------|
| Eureka Server     | 8761 | Service registry for discovery & load balancing |
| API Gateway       | 8080 | Entry point for all requests |
| Question Service  | 8081 | Manage quiz questions and options |
| Quiz Service      | 8082 | Manage quizzes and submit answers |
| Result Service    | 8083 | Store and retrieve user quiz results |
