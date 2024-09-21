# Parcial primer corte
![image](./assets/diagrama.png)

## Patrón de diseño seleccionado

El patrón de diseño seleccionado para implementar en este caso es Observer.
Observer es un patrón de diseño que sirve para actualizar información de una clase
que es vital para su funcionamiento, pero esta información se encuentra en otra clase.
Entonces, con Observer es posible que cada vez que se actualiza la clase con la información
esta llame a las clases que necesitan estos datos que se actualizaron.

En este caso es Agent es quien necesita la informacion de los productos que estan en 
ProductAgentServiceImpl.

## Documentación

### Peticiones a la API. La url globlas es localhost:8080/product

### La api ofrece 4 path:

### getAllProduct
#### Path: es la global
#### Método http GET
getAllProduct sirve para obtener todos los productos que han sido guardados en 
la aplicación

Ejemplo de la petición:

![image](./assets/getAllProducts.png)

### createProduct
### Path: /create
### Método http POST
### Body recibe {"name":"string", "price":float, "quantity":integer, "category":"string"} que es el producto a añadir.

Ejemplo de la petición:

![image](./assets/postcreate.png)

### updateProduct
### Path: /update
### Método http PUT
### Recibe dos parametros en el path name y quantity, el name es el producto a modificar su cantidad de stock.

Ejemplo de la petición:

![image](./assets/update.png)

### deleteProduct
### Path: /delete
### Método http DELETE
### Recibe una variable en el path la cual es el nombre del producto a eliminar.

Ejemplo de la petición:

![image](./assets/delete.png)
