# SpringHibernateOMS
A Spring Boot application that implements a REST API for an online Order Management System.

The API allows the following operations:
•	Search Products by name, category and/or description
o	GET …/products?name=…&category=…&description=…
•	Create Order
o	POST …/{username}/orders
•	Retrieve Order
o	GET …/{username}/orders/{id}
•	Update Order
o	PUT …/{username}/orders/{id}

The API persist data using Hibernate framework.

Example domain model:
USER
•	username
•	full name
•	address
PRODUCT
•	code
•	name
•	description
•	category (one of AUTO, HOME, IT)
•	quantity
ORDER
•	id
•	username
•	creation_date
ORDER_PRODUCT
•	order_id
•	product_code
•	quantity

•	The API allows JSON payloads


The API is be testable via Postman
•	Order–Product have @ManyToMany
•	Product–Category have @ManyToOne; 
 
Search Products contains Request Params for filter.
