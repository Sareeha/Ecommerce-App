# Ecommerce App
This ecommerce app is powered by Java Spring Boot and features 7 entities to operate a functional ecommerce backed server. This project was coded to the design of the ERD below.

Entity Relationship Diagram
---------------------------
![alt text](/readme/erd.png)


Implementing the Ecommerce App
----------------------------

After implementing the 7 entities and its corresponding controller, service and repository layer, the dataloader class is used to initialize base data. From here we can cross examine its relationship.

The master entity is the customer because it has no dependency. However all the other entities relies on customer.

![alt text](/readme/cust.png)
![alt text](/readme/custerd.png)

Once the customer entity has been initialized we can start creating the database using the following hierachy

Customer --> Address --> Seller --> Product --> Order -->Cart -->Cart Item 

The rule of thumb is to create the master first (the entity that has least dependency) and slowly work our way down to the entity which has the most dependency.


![alt text](/readme/addsellprodord.png)
![alt text](/readme/cartNcartItem.png)

At this stage the database is loaded and operational.

The dataloader class calls the service controller to create and assign the 'slave' entity to its 'master' entity. By using this method I was able to test if my service and repo layers are functional. It this case we have proven the back-end server is operational.


Testing the controller layer
---------------------------

Now we begin testing the most important aspect of the back-end which is the respond to REST request with the correct data.

Here I will demonstrate adding more cart items into an existing cart an order.

This is akin to a shopper adding in more items to the cart prior to checkout and payment.

I will use order id #4 which is currently empty to demonstrate this.

GET Order id 4

![alt text](/readme/image.png)

POST Cart Item , Product id 11 to Order id 4

![alt text](/readme/image-1.png)

POST Cart Item, Product id 12 to Order id 4

![alt text](/readme/image-2.png)

POST Cart Item, Product id 13 to Order id 4

![alt text](/readme/image-3.png)

Now that we have added many cart items into our order 4, let us examine if the database indeed reflects the correct value and items.

Get Order id 4 again

![alt text](/readme/image-4.png)

![alt text](/readme/image-5.png)

We can observe that the correct products, quantity and total price is correctly reflected in my Get Order. Here is the data.
```

{
  "orderId": 4,
  "orderDate": "2024-02-10T12:13:48.416+00:00",
  "orderedItems": [
    {
      "id": 11,
      "product": {
        "id": 11,
        "name": "Ipad 9",
        "quantity": 1,
        "description": "Technological Product from Apple",
        "category": "ELECTRONICS",
        "status": "ACTIVE",
        "price": 1000.99,
        "manufacturer": "Apple Inc"
      },
      "cartItemQuantity": 2
    },
    {
      "id": 12,
      "product": {
        "id": 12,
        "name": "Apple Pen 5",
        "quantity": 2,
        "description": "Technological stylus from Apple",
        "category": "ELECTRONICS",
        "status": "ACTIVE",
        "price": 200.99,
        "manufacturer": "Apple Inc"
      },
      "cartItemQuantity": 100
    },
    {
      "id": 13,
      "product": {
        "id": 13,
        "name": "Sumsung Galaxy watch 5",
        "quantity": 1,
        "description": "Technological Product from Samsung",
        "category": "ELECTRONICS",
        "status": "ACTIVE",
        "price": 599.0,
        "manufacturer": "Samsung Electronics"
      },
      "cartItemQuantity": 30
    }
  ],
  "orderStatus": "PENDING",
  "total": 40070.979999999996
}

```
Lets check the database to see if this is correct.

![alt text](/readme/image-6.png)

As we can see the database entry is correct as well. The add cart exercise works succesfully.

We can also get many other information. At random let us do as follows.

Get all customers.

The list below is rather long. It is because I implemented the eager fetching which retrives the data of all the customers, the addresses they have, the order list , cart and cart item which is tied to them. 

![alt text](/readme/image-7.png)

```
[
  {
    "id": 1,
    "firstName": "Catherine",
    "lastName": "Tiong",
    "email": "catt@gmail.com",
    "contactNo": "12345678",
    "yearOfBirth": 1990,
    "customerCart": {
      "id": 1,
      "cartTotal": 20900.0,
      "cartItems": [
        {
          "id": 1,
          "product": {
            "id": 1,
            "name": "Macbook",
            "quantity": 1,
            "description": "Apple product",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 1900.0,
            "manufacturer": "Ping Guo Inc"
          },
          "cartItemQuantity": 11
        }
      ]
    },
    "orderList": [
      {
        "orderId": 1,
        "orderDate": "2024-02-10T12:13:48.394+00:00",
        "orderedItems": [
          {
            "id": 1,
            "product": {
              "id": 1,
              "name": "Macbook",
              "quantity": 1,
              "description": "Apple product",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 1900.0,
              "manufacturer": "Ping Guo Inc"
            },
            "cartItemQuantity": 11
          },
          {
            "id": 2,
            "product": {
              "id": 2,
              "name": "Macbook Pro",
              "quantity": 1,
              "description": "Apple product",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 3700.0,
              "manufacturer": "Ping Guo Inc"
            },
            "cartItemQuantity": 22
          },
          {
            "id": 3,
            "product": {
              "id": 3,
              "name": "Samsung Fold",
              "quantity": 1,
              "description": "Android Folding Phone",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 2200.0,
              "manufacturer": "Somesong"
            },
            "cartItemQuantity": 33
          },
          {
            "id": 4,
            "product": {
              "id": 4,
              "name": "Iphone 15 Max",
              "quantity": 1,
              "description": "Apple Phone",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 2300.0,
              "manufacturer": "Ping Guo Inc"
            },
            "cartItemQuantity": 44
          }
        ],
        "orderStatus": "PENDING",
        "total": 276100.0
      },
      {
        "orderId": 2,
        "orderDate": "2024-02-10T12:13:48.406+00:00",
        "orderedItems": [
          {
            "id": 5,
            "product": {
              "id": 5,
              "name": "Google Pixel",
              "quantity": 1,
              "description": "Android Phone",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 1800.0,
              "manufacturer": "Googol"
            },
            "cartItemQuantity": 55
          },
          {
            "id": 6,
            "product": {
              "id": 6,
              "name": "Ipad",
              "quantity": 1,
              "description": "Technological Product from Apple",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 900.99,
              "manufacturer": "Apple Inc"
            },
            "cartItemQuantity": 66
          },
          {
            "id": 7,
            "product": {
              "id": 7,
              "name": "Apple Pen",
              "quantity": 2,
              "description": "Technological stylus from Apple",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 98.99,
              "manufacturer": "Apple Inc"
            },
            "cartItemQuantity": 77
          }
        ],
        "orderStatus": "PENDING",
        "total": 166087.57
      },
      {
        "orderId": 3,
        "orderDate": "2024-02-10T12:13:48.412+00:00",
        "orderedItems": [
          {
            "id": 8,
            "product": {
              "id": 8,
              "name": "Sumsung Galaxy watch",
              "quantity": 1,
              "description": "Technological Product from Samsung",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 499.0,
              "manufacturer": "Samsung Electronics"
            },
            "cartItemQuantity": 88
          },
          {
            "id": 9,
            "product": {
              "id": 9,
              "name": "Ideapad Slim 5",
              "quantity": 1,
              "description": "Laptop",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 1200.0,
              "manufacturer": "Lenovo"
            },
            "cartItemQuantity": 99
          },
          {
            "id": 10,
            "product": {
              "id": 10,
              "name": "Surface Pro",
              "quantity": 1,
              "description": "Tablet PC",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 1600.0,
              "manufacturer": "MiloSoft"
            },
            "cartItemQuantity": 100
          }
        ],
        "orderStatus": "PENDING",
        "total": 322712.0
      }
    ],
    "addressList": [
      {
        "id": 1,
        "blockNumber": "15",
        "streetName": "Jalan Tukang",
        "buildingName": "Smith Place",
        "city": "SG",
        "state": "SG",
        "postalCode": "670455",
        "order": {
          "orderId": 1,
          "orderDate": "2024-02-10T12:13:48.394+00:00",
          "orderedItems": [
            {
              "id": 1,
              "product": {
                "id": 1,
                "name": "Macbook",
                "quantity": 1,
                "description": "Apple product",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 1900.0,
                "manufacturer": "Ping Guo Inc"
              },
              "cartItemQuantity": 11
            },
            {
              "id": 2,
              "product": {
                "id": 2,
                "name": "Macbook Pro",
                "quantity": 1,
                "description": "Apple product",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 3700.0,
                "manufacturer": "Ping Guo Inc"
              },
              "cartItemQuantity": 22
            },
            {
              "id": 3,
              "product": {
                "id": 3,
                "name": "Samsung Fold",
                "quantity": 1,
                "description": "Android Folding Phone",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 2200.0,
                "manufacturer": "Somesong"
              },
              "cartItemQuantity": 33
            },
            {
              "id": 4,
              "product": {
                "id": 4,
                "name": "Iphone 15 Max",
                "quantity": 1,
                "description": "Apple Phone",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 2300.0,
                "manufacturer": "Ping Guo Inc"
              },
              "cartItemQuantity": 44
            }
          ],
          "orderStatus": "PENDING",
          "total": 276100.0
        }
      },
      {
        "id": 2,
        "blockNumber": "20",
        "streetName": "Jalan Bakar",
        "buildingName": "Burns",
        "city": "SG",
        "state": "SG",
        "postalCode": "670456",
        "order": {
          "orderId": 2,
          "orderDate": "2024-02-10T12:13:48.406+00:00",
          "orderedItems": [
            {
              "id": 5,
              "product": {
                "id": 5,
                "name": "Google Pixel",
                "quantity": 1,
                "description": "Android Phone",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 1800.0,
                "manufacturer": "Googol"
              },
              "cartItemQuantity": 55
            },
            {
              "id": 6,
              "product": {
                "id": 6,
                "name": "Ipad",
                "quantity": 1,
                "description": "Technological Product from Apple",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 900.99,
                "manufacturer": "Apple Inc"
              },
              "cartItemQuantity": 66
            },
            {
              "id": 7,
              "product": {
                "id": 7,
                "name": "Apple Pen",
                "quantity": 2,
                "description": "Technological stylus from Apple",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 98.99,
                "manufacturer": "Apple Inc"
              },
              "cartItemQuantity": 77
            }
          ],
          "orderStatus": "PENDING",
          "total": 166087.57
        }
      },
      {
        "id": 3,
        "blockNumber": "25",
        "streetName": "Jalan Tunang",
        "buildingName": "Engaged Building",
        "city": "SG",
        "state": "SG",
        "postalCode": "670456",
        "order": {
          "orderId": 3,
          "orderDate": "2024-02-10T12:13:48.412+00:00",
          "orderedItems": [
            {
              "id": 8,
              "product": {
                "id": 8,
                "name": "Sumsung Galaxy watch",
                "quantity": 1,
                "description": "Technological Product from Samsung",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 499.0,
                "manufacturer": "Samsung Electronics"
              },
              "cartItemQuantity": 88
            },
            {
              "id": 9,
              "product": {
                "id": 9,
                "name": "Ideapad Slim 5",
                "quantity": 1,
                "description": "Laptop",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 1200.0,
                "manufacturer": "Lenovo"
              },
              "cartItemQuantity": 99
            },
            {
              "id": 10,
              "product": {
                "id": 10,
                "name": "Surface Pro",
                "quantity": 1,
                "description": "Tablet PC",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 1600.0,
                "manufacturer": "MiloSoft"
              },
              "cartItemQuantity": 100
            }
          ],
          "orderStatus": "PENDING",
          "total": 322712.0
        }
      }
    ]
  },
  {
    "id": 2,
    "firstName": "Siti",
    "lastName": "Aminah K",
    "email": "sitiamk@gmail.com",
    "contactNo": "12345678",
    "yearOfBirth": 1991,
    "customerCart": {
      "id": 2,
      "cartTotal": 81400.0,
      "cartItems": [
        {
          "id": 2,
          "product": {
            "id": 2,
            "name": "Macbook Pro",
            "quantity": 1,
            "description": "Apple product",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 3700.0,
            "manufacturer": "Ping Guo Inc"
          },
          "cartItemQuantity": 22
        }
      ]
    },
    "orderList": [
      {
        "orderId": 5,
        "orderDate": "2024-02-10T12:13:48.421+00:00",
        "orderedItems": [],
        "orderStatus": "PENDING",
        "total": 0.0
      },
      {
        "orderId": 4,
        "orderDate": "2024-02-10T12:13:48.416+00:00",
        "orderedItems": [
          {
            "id": 11,
            "product": {
              "id": 11,
              "name": "Ipad 9",
              "quantity": 1,
              "description": "Technological Product from Apple",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 1000.99,
              "manufacturer": "Apple Inc"
            },
            "cartItemQuantity": 2
          },
          {
            "id": 12,
            "product": {
              "id": 12,
              "name": "Apple Pen 5",
              "quantity": 2,
              "description": "Technological stylus from Apple",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 200.99,
              "manufacturer": "Apple Inc"
            },
            "cartItemQuantity": 100
          },
          {
            "id": 13,
            "product": {
              "id": 13,
              "name": "Sumsung Galaxy watch 5",
              "quantity": 1,
              "description": "Technological Product from Samsung",
              "category": "ELECTRONICS",
              "status": "ACTIVE",
              "price": 599.0,
              "manufacturer": "Samsung Electronics"
            },
            "cartItemQuantity": 30
          }
        ],
        "orderStatus": "PENDING",
        "total": 40070.979999999996
      }
    ],
    "addressList": [
      {
        "id": 4,
        "blockNumber": "30",
        "streetName": "Kampung Java",
        "buildingName": "Java Village",
        "city": "SG",
        "state": "SG",
        "postalCode": "670457",
        "order": {
          "orderId": 4,
          "orderDate": "2024-02-10T12:13:48.416+00:00",
          "orderedItems": [
            {
              "id": 11,
              "product": {
                "id": 11,
                "name": "Ipad 9",
                "quantity": 1,
                "description": "Technological Product from Apple",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 1000.99,
                "manufacturer": "Apple Inc"
              },
              "cartItemQuantity": 2
            },
            {
              "id": 12,
              "product": {
                "id": 12,
                "name": "Apple Pen 5",
                "quantity": 2,
                "description": "Technological stylus from Apple",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 200.99,
                "manufacturer": "Apple Inc"
              },
              "cartItemQuantity": 100
            },
            {
              "id": 13,
              "product": {
                "id": 13,
                "name": "Sumsung Galaxy watch 5",
                "quantity": 1,
                "description": "Technological Product from Samsung",
                "category": "ELECTRONICS",
                "status": "ACTIVE",
                "price": 599.0,
                "manufacturer": "Samsung Electronics"
              },
              "cartItemQuantity": 30
            }
          ],
          "orderStatus": "PENDING",
          "total": 40070.979999999996
        }
      },
      {
        "id": 5,
        "blockNumber": "35",
        "streetName": "Jalan Satay",
        "buildingName": "Satay Street",
        "city": "SG",
        "state": "SG",
        "postalCode": "670458",
        "order": {
          "orderId": 5,
          "orderDate": "2024-02-10T12:13:48.421+00:00",
          "orderedItems": [],
          "orderStatus": "PENDING",
          "total": 0.0
        }
      }
    ]
  },
  {
    "id": 3,
    "firstName": "Sariha",
    "lastName": "Sareeha",
    "email": "sariha@gmail.com",
    "contactNo": "12345678",
    "yearOfBirth": 1992,
    "customerCart": {
      "id": 3,
      "cartTotal": 72600.0,
      "cartItems": [
        {
          "id": 3,
          "product": {
            "id": 3,
            "name": "Samsung Fold",
            "quantity": 1,
            "description": "Android Folding Phone",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 2200.0,
            "manufacturer": "Somesong"
          },
          "cartItemQuantity": 33
        }
      ]
    },
    "orderList": [
      {
        "orderId": 6,
        "orderDate": "2024-02-10T12:13:48.425+00:00",
        "orderedItems": [],
        "orderStatus": "PENDING",
        "total": 0.0
      },
      {
        "orderId": 7,
        "orderDate": "2024-02-10T12:13:48.430+00:00",
        "orderedItems": [],
        "orderStatus": "PENDING",
        "total": 0.0
      }
    ],
    "addressList": [
      {
        "id": 6,
        "blockNumber": "40",
        "streetName": "Kay Poh Road",
        "buildingName": "Busy Body Inc",
        "city": "SG",
        "state": "SG",
        "postalCode": "670459",
        "order": {
          "orderId": 6,
          "orderDate": "2024-02-10T12:13:48.425+00:00",
          "orderedItems": [],
          "orderStatus": "PENDING",
          "total": 0.0
        }
      },
      {
        "id": 7,
        "blockNumber": "45",
        "streetName": "Lorong Lew Lian",
        "buildingName": "Durian Hub",
        "city": "SG",
        "state": "SG",
        "postalCode": "670460",
        "order": {
          "orderId": 7,
          "orderDate": "2024-02-10T12:13:48.430+00:00",
          "orderedItems": [],
          "orderStatus": "PENDING",
          "total": 0.0
        }
      }
    ]
  },
  {
    "id": 4,
    "firstName": "Sara",
    "lastName": "Saranya",
    "email": "sara@gmail.com",
    "contactNo": "12345678",
    "yearOfBirth": 1993,
    "customerCart": {
      "id": 4,
      "cartTotal": 101200.0,
      "cartItems": [
        {
          "id": 4,
          "product": {
            "id": 4,
            "name": "Iphone 15 Max",
            "quantity": 1,
            "description": "Apple Phone",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 2300.0,
            "manufacturer": "Ping Guo Inc"
          },
          "cartItemQuantity": 44
        }
      ]
    },
    "orderList": [
      {
        "orderId": 8,
        "orderDate": "2024-02-10T12:13:48.433+00:00",
        "orderedItems": [],
        "orderStatus": "PENDING",
        "total": 0.0
      },
      {
        "orderId": 9,
        "orderDate": "2024-02-10T12:13:48.437+00:00",
        "orderedItems": [],
        "orderStatus": "PENDING",
        "total": 0.0
      }
    ],
    "addressList": [
      {
        "id": 8,
        "blockNumber": "50",
        "streetName": "Rotan Lane",
        "buildingName": "Discipline Place",
        "city": "SG",
        "state": "SG",
        "postalCode": "670461",
        "order": {
          "orderId": 8,
          "orderDate": "2024-02-10T12:13:48.433+00:00",
          "orderedItems": [],
          "orderStatus": "PENDING",
          "total": 0.0
        }
      },
      {
        "id": 9,
        "blockNumber": "55",
        "streetName": "Pending Road",
        "buildingName": "Wait Long Long",
        "city": "SG",
        "state": "SG",
        "postalCode": "670462",
        "order": {
          "orderId": 9,
          "orderDate": "2024-02-10T12:13:48.437+00:00",
          "orderedItems": [],
          "orderStatus": "PENDING",
          "total": 0.0
        }
      }
    ]
  },
  {
    "id": 5,
    "firstName": "ZJ",
    "lastName": "Lee",
    "email": "zjlee@gmail.com",
    "contactNo": "12345678",
    "yearOfBirth": 1994,
    "customerCart": {
      "id": 5,
      "cartTotal": 99000.0,
      "cartItems": [
        {
          "id": 5,
          "product": {
            "id": 5,
            "name": "Google Pixel",
            "quantity": 1,
            "description": "Android Phone",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 1800.0,
            "manufacturer": "Googol"
          },
          "cartItemQuantity": 55
        }
      ]
    },
    "orderList": [
      {
        "orderId": 10,
        "orderDate": "2024-02-10T12:13:48.440+00:00",
        "orderedItems": [],
        "orderStatus": "PENDING",
        "total": 0.0
      }
    ],
    "addressList": [
      {
        "id": 10,
        "blockNumber": "55",
        "streetName": "Jalan Malu Malu",
        "buildingName": "Shy",
        "city": "SG",
        "state": "SG",
        "postalCode": "670462",
        "order": {
          "orderId": 10,
          "orderDate": "2024-02-10T12:13:48.440+00:00",
          "orderedItems": [],
          "orderStatus": "PENDING",
          "total": 0.0
        }
      },
      {
        "id": 11,
        "blockNumber": "60",
        "streetName": "Jalan Langgar",
        "buildingName": "Crash Zone",
        "city": "SG",
        "state": "SG",
        "postalCode": "670463",
        "order": null
      }
    ]
  },
  {
    "id": 6,
    "firstName": "Sam",
    "lastName": "Altman",
    "email": "saltman@openai.com",
    "contactNo": "12345678",
    "yearOfBirth": 1995,
    "customerCart": {
      "id": 6,
      "cartTotal": 59465.34,
      "cartItems": [
        {
          "id": 6,
          "product": {
            "id": 6,
            "name": "Ipad",
            "quantity": 1,
            "description": "Technological Product from Apple",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 900.99,
            "manufacturer": "Apple Inc"
          },
          "cartItemQuantity": 66
        }
      ]
    },
    "orderList": [],
    "addressList": [
      {
        "id": 12,
        "blockNumber": "65",
        "streetName": "Jalan Pisang",
        "buildingName": "Banana",
        "city": "SG",
        "state": "SG",
        "postalCode": "670464",
        "order": null
      }
    ]
  },
  {
    "id": 7,
    "firstName": "Mark",
    "lastName": "Zuckerberg",
    "email": "zuck@fb.com",
    "contactNo": "12345678",
    "yearOfBirth": 1996,
    "customerCart": {
      "id": 7,
      "cartTotal": 7622.23,
      "cartItems": [
        {
          "id": 7,
          "product": {
            "id": 7,
            "name": "Apple Pen",
            "quantity": 2,
            "description": "Technological stylus from Apple",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 98.99,
            "manufacturer": "Apple Inc"
          },
          "cartItemQuantity": 77
        }
      ]
    },
    "orderList": [],
    "addressList": [
      {
        "id": 13,
        "blockNumber": "70",
        "streetName": "Kallang Pudding Road",
        "buildingName": "Pudding",
        "city": "SG",
        "state": "SG",
        "postalCode": "670464",
        "order": null
      }
    ]
  },
  {
    "id": 8,
    "firstName": "Linus",
    "lastName": "Torvald",
    "email": "lt@linux.com",
    "contactNo": "12345678",
    "yearOfBirth": 1997,
    "customerCart": {
      "id": 8,
      "cartTotal": 43912.0,
      "cartItems": [
        {
          "id": 8,
          "product": {
            "id": 8,
            "name": "Sumsung Galaxy watch",
            "quantity": 1,
            "description": "Technological Product from Samsung",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 499.0,
            "manufacturer": "Samsung Electronics"
          },
          "cartItemQuantity": 88
        }
      ]
    },
    "orderList": [],
    "addressList": [
      {
        "id": 14,
        "blockNumber": "75",
        "streetName": "Sandwich Road",
        "buildingName": "Delicious",
        "city": "SG",
        "state": "SG",
        "postalCode": "670465",
        "order": null
      }
    ]
  },
  {
    "id": 9,
    "firstName": "Elon",
    "lastName": "Musk",
    "email": "elonm@spacex.com",
    "contactNo": "12345678",
    "yearOfBirth": 1998,
    "customerCart": {
      "id": 9,
      "cartTotal": 118800.0,
      "cartItems": [
        {
          "id": 9,
          "product": {
            "id": 9,
            "name": "Ideapad Slim 5",
            "quantity": 1,
            "description": "Laptop",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 1200.0,
            "manufacturer": "Lenovo"
          },
          "cartItemQuantity": 99
        }
      ]
    },
    "orderList": [],
    "addressList": [
      {
        "id": 15,
        "blockNumber": "80",
        "streetName": "Cheow Keng Road",
        "buildingName": "Escape",
        "city": "SG",
        "state": "SG",
        "postalCode": "670466",
        "order": null
      }
    ]
  },
  {
    "id": 10,
    "firstName": "Andrew",
    "lastName": "Ng",
    "email": "andrewng@stanford.com",
    "contactNo": "12345678",
    "yearOfBirth": 1999,
    "customerCart": {
      "id": 10,
      "cartTotal": 160000.0,
      "cartItems": [
        {
          "id": 10,
          "product": {
            "id": 10,
            "name": "Surface Pro",
            "quantity": 1,
            "description": "Tablet PC",
            "category": "ELECTRONICS",
            "status": "ACTIVE",
            "price": 1600.0,
            "manufacturer": "MiloSoft"
          },
          "cartItemQuantity": 100
        }
      ]
    },
    "orderList": [],
    "addressList": [
      {
        "id": 16,
        "blockNumber": "85",
        "streetName": "Robinson Road",
        "buildingName": "Robbing son",
        "city": "SG",
        "state": "SG",
        "postalCode": "670467",
        "order": null
      }
    ]
  }
]
```
We can also create new customers to serve our purpose. Here we Post a new customer, and then GET the id.

![alt text](/readme/image-8.png)

Get customer id 11

![alt text](/readme/image-9.png)

Mr. Biden has not purchased any items or have an address set to him yet. Hence the rather empty data.

This works similarly with the other entities.  Please do fork this repo , clone it to your local repo and try it out yourself for the remaining entities.

Known Issues
-------------------

While this spring boot back end works as per design intent, it is worth noting the following:-

1) Once an entity has been assigned a 'master' entity, it is now linked, and it cannot be deleted (DELETE will fail). PUT may not work for assigned entity as well.

2) The relationship between Product and Cart Item is one to one for this ecommerce app. This is mainly to demonstrate the limitation of one to one relationship. So if we try to assign product 13 to another order, it will not work.

```
23:45:49.690 [http-nio-8080-exec-9] ERROR o.h.e.jdbc.spi.SqlExceptionHelper - ERROR: duplicate key value violates unique constraint "cart_item_product_id_key"
  Detail: Key (product_id)=(13) already exists.
23:45:49.697 [http-nio-8080-exec-9] ERROR s.n.e.e.service.CartItemServiceImpl - 🛒🔴 Error saving  sg.ntu.edu.ecommerceapp.entity.CartItem@3cdb09fa error org.springframework.dao.DataIntegrityViolationException: could not execute statement [ERROR: duplicate key value violates unique constraint "cart_item_product_id_key"
  Detail: Key (product_id)=(13) already exists.] [insert into cart_item (cart_id,cart_item_quantity,order_id,product_id) values (?,?,?,?)]; SQL [insert into cart_item (cart_id,cart_item_quantity,order_id,product_id) values (?,?,?,?)]; constraint [cart_item_product_id_key]

```
This back end server is still under development and I will be looking into closing out the remaining issues at hand


Special Thanks
---------------------

THe majority of the code here is my own. However I did not work alone on this. Ms. Siti Aminah implemented the Cart, Product and Seller class which I then integrated into my code. Ms. Catherine came out with the ERD which we used as a reference to code our back-end.

Both Ms. Catherine and Ms. Siti have their own versions of the Ecommerce App. 

The version presented here is my implementation.