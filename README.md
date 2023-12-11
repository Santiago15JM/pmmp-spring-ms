# Back End services for PMMP project

## Overview

This repository contains the microservices for the project developed using Spring Boot.

## Project Structure

The project is organized into multiple microservices, each serving a specific functionality. Here is a brief overview of the microservices:

1. **User service:** Contains all the basic operations like login, signing up, and editing profile.
2. **Pet service:** Serves the pet functionalities such as registering pets, reporting diseases and vaccines.
3. **Statistics service:** This service handles the calculation of the public status summaries.
4. **Disease service:** This service contains a simple GraphQL endpoint which allows the retrieval of all the diseases that apply to a specific type of pet.
5. **Api gateway:** Simple api gateway to centralize the requests.

## Technologies Used

- Java
- Spring Boot
- GraphQL
- Docker

## Getting Started

Follow these instructions to set up and run the project locally on your machine.

### Prerequisites

- Java SDK 17
- Gradle
- Docker

### Running the project

1. Clone the repository:

```bash
git clone https://github.com/Santiago15JM/pmmp-spring-ms.git
```

2. You can either run each service directly from its main class, or build each dockerfile and run them in containers:

 - Build the service with gradle, then:
```bash
cd service_folder
docker build -t service-name .
```

4. Once you've built every docker image, you can run them all with the [docker compose](docker-compose.yml) file.

## Usage

You can test each endpoint with any api tool such as Postman, Rested, etc.

Happy coding!
