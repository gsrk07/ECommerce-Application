## Overview
This capstone project is a functional e-commerce system designed to demonstrate the usage of modern SDLC concepts, including the Spring MVC architecture, robust database schema, modularised services, and third-party payment gateway integration. 
The platform includes essential features such as user authentication, products catalog management,  Cart and Checkout functionality, Orders management, and payment processing using Stripe Payment Gateway.

## Features
1. **User Management:**
    - User registration and login (authentication)
    - User Roles-based access control

2. **Product Management:**
    - Product catalog with categories and inventory management
    - Integration of images for products

3. **Shopping Cart:**
    - Add, modify and delete items from the cart
    - Display cart total and individual item prices

4. **Order Management:**
    - Order placement and summary
    - Integration with payment gateway (Stripe) for secure transactions

5. **Payment Processing:**
    - Stripe checkout session integration
    - Handling payment success and failure scenarios

6. **Database Design:**
    - Relational database schema optimized with foreign keys and indexing
    - Scalable and normalized schema for efficient data retrieval

7. **Error Handling:**
    - Custom exceptions for meaningful error messages
    - Graceful handling of runtime errors

## Technologies Used
1. **Backend:**
    - Java
    - Spring Boot (Controllers, Services, and Repositories)

2. **Database:**
    - MySQL with relational schema
    - Indexing and foreign key constraints

3. **Payment Gateway:**
    - Stripe for secure and seamless payment processing

4. **Frontend:**
    - Not explicitly implemented, but designed for future integration with frameworks like React or Angular

5. **Tools and Libraries:**
    - Lombok for reducing boilerplate code
    - Hibernate for ORM

## Folder Structure (Based on MVC Pattern)
```markdown
EcommerceShoppingApp
├── docs
│   ├── api-docs
│   ├── class-diagram
│   ├── shema-diagram
│   └── postman-collection
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── sriramcode
│   │   │           ├── EcommerceShoppingApp
│   │   │           │   ├── authorisation
│   │   │           │   │   ├── config
│   │   │           │   │   ├── controller
│   │   │           │   │   ├── dto
│   │   │           │   │   ├── jwt
│   │   │           │   │   ├── user
│   │   │           │   ├── commons
│   │   │           │   │   ├── dto
│   │   │           │   │   ├── exception
│   │   │           │   │   ├── models
│   │   │           │   ├── orders
│   │   │           │   │   ├── controller
│   │   │           │   │   ├── dto
│   │   │           │   │   ├── models
│   │   │           │   │   ├── repository
│   │   │           │   │   ├── service
│   │   │           │   ├── products
│   │   │           │   │   ├── controller
│   │   │           │   │   ├── controlleradvice
│   │   │           │   │   ├── dto
│   │   │           │   │   ├── exception
│   │   │           │   │   ├── models
│   │   │           │   │   ├── repository
│   │   │           │   │   ├── service
│   │   │           │   ├── ShoppingCartandCheckout
│   │   │           │   │   ├── controller
│   │   │           │   │   ├── dto
│   │   │           │   │   ├── exception
│   │   │           │   │   ├── models
│   │   │           │   │   ├── repository
│   │   │           │   │   ├── service
│   │   │           │   ├── user
│   │   │           │   │   ├── controller
│   │   │           │   │   ├── dto
│   │   │           │   │   ├── exception
│   │   │           │   │   ├── models
│   │   │           │   │   ├── repository
│   │   │           │   │   ├── service
│   │   │           └── ECommerceShoppingAppApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── templates
│   │           └── index.html
└── pom.xml
└── README.md
```
## Key Highlights
1. **Stripe Integration:** Implemented for secure and seamless payment processing.
2. **Scalability:** Database schema is normalized, ensuring efficient data handling as the application grows.
3. **Error Management:** Several Custom exceptions have been build to handle exceptions and improve user experience.
4. **Optimization Techniques:** Usage of caching and database indexing for better performance.

## Limitations
1. **Cost of Stripe:** Stripe's transaction fees may not be feasible for small-scale applications.
2. **Database Scalability:** For extremely high traffic, techniques like sharding or denormalization may need to be explored.
3. **Stale Data in Caching:** Proper cache invalidation strategies need to be implemented to avoid stale data issues.
4. **Monitoring and Logging:** Advanced tools like ELK Stack could further improve monitoring.

## Suggestions for Improvement
1. **Asynchronous Processing:** Implement message brokers like Kafka for order processing.
2. **Multi-Gateway Payments:** Add support for multiple payment gateways for user flexibility.
3. **Frontend Integration:** Build a responsive frontend using React or Angular to complete the platform.
4. **Advanced Monitoring:** Integrate APM tools like New Relic to monitor system health.

## Conclusion
This capstone project is a functional e-commerce system designed to demonstrate the usage of modern SDLC concepts, including the Spring MVC architecture, robust database schema, modularised services, and third-party payment gateway integration.
The platform includes essential features such as user authentication, products catalog management,  Cart and Checkout functionality, Orders management, and payment processing using Stripe Payment Gateway.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- Stripe account and API keys

### Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/onlineshop.git
    ```
2. Navigate to the project directory:
    ```sh
    cd onlineshop
    ```
3. Install the dependencies:
    ```sh
    mvn clean install
    ```

### Configuration
1. Update the `application.properties` file with your database and Stripe API configurations:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/onlineshop
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    STRIPE_SECRET_KEY=your_stripe_secret_key
    baseURL=http://localhost:8080/
    ```

### Running the Application
1. Start the application:
    ```sh
    mvn spring-boot:run
    ```
2. Access the application at `http://localhost:8080`.

## API Endpoints

### User Management
- `GET /api/users/{userId}/user` - Get user detail by userId
- `POST /api/users/add` - Add a new user
- `PUT /api/users/{userId}/update` - Update existing user details
- `DELETE /api/users/{userId}/delete` - Remove a user
- `POST /api/users/reset-password` - Reset users password

### Shopping Cart and Checkout
- `POST /api/v1/cartItems/item/add` - Add items to cart
- `POST /api/v1/checkout/create-session` - Create a checkout session


## License
This project is licensed under the MIT License.
