# test-citibanamex
Prueba tecnica para el proceso con citibanamex

## Dependencias

_Java 8 o posteriores_
Maven 3.6.3 o posteriores

## Ejecucion de tests
```
mvn test
```
## Compilacion
```
mvn clean package
```

## Ejecucion

_Puede ejecutar el proyecto de dos formas:_
Utilizando maven para arrancar el proyecto:

```
mvn spring-boot:run
```
Ejecutando el jar generado en la compilacion:

```
cd target
java -jar test-citibanamex.jar
```
## Definicion y prueba del API

### headers 

devuelve las cabeceras enviadas en la peticion
HTTP request
```
GET localhost:8080/headers
```
![image](https://user-images.githubusercontent.com/16471614/120703267-b3692a00-c47a-11eb-99fc-958c2fa795b6.png)

si deseamos que nos traiga una o varias cabeceras ene especifico, enviamos los nombres dentro del URI
HTTP request
```
GET localhost:8080/headers/{names}
```

![image](https://user-images.githubusercontent.com/16471614/120703981-9f71f800-c47b-11eb-9b35-5d87b83f58e0.png)

### numbers

elimina los numeros duplicados de la lista recibida

HTTP request
```
GET localhost:8080/numbers/no-duplicates/{numbers}
```

![image](https://user-images.githubusercontent.com/16471614/120705158-165bc080-c47d-11eb-8d04-c2a2c418a5e2.png)


