# Test de Microservicios

Este programa es una prueba de microservicios para las entidades clientes, cuentas y movimientos.

## Creación de Base de Datos 

Para este programa se hizo uso de una base de datos en Docker. Sin embargo se puede crearla con el archivo BaseDatos.sql que se encuentra en la carpeta SQL. 
Ahi se puede ejecutar la primera parte del query para crear el usuario de conexion. Después de eso como indica los comentarios del archivo, no es necesario
crear las tablas en la base de datos, ya que el programa las genera automáticamente, pero se adjunta el SQL en caso que se quiera probar. Para el llenado
de la base de datos, basta con ejecutar los ejemplos del archivo TATA.postman_collection.json que se encuentran en la carpeta POSTMAN.

Se adjuntan capturas del proceso:
### Creación del usuario

![Creacion Conexion 1](https://github.com/user-attachments/assets/2eae61b2-17af-4acb-85d6-c891450f2b52)

### Conexión con el usuario de la base de datos creada

![Creacion Conexion 2](https://github.com/user-attachments/assets/e1cacb33-d5f1-4185-a9e5-8c2e51e55f23)

![Creacion Tablas 1](https://github.com/user-attachments/assets/1ce8e192-853b-4f4d-b7d5-65d7814b4230)

### Revisión de los datos de conexión en el programa
Ir al archivo application.properties del programa y revisar que coincidan los datos de conexión. Una vez verificado, iniciar el programa y revisar la base da datos 
y veremos las tablas creadas.

![Creacion Tablas 2](https://github.com/user-attachments/assets/b84af282-96f5-4518-8920-32183a7675e1)

![Creacion Tablas 3](https://github.com/user-attachments/assets/3f61fd43-5855-4e8c-9e98-8439383b5273)

![Creacion Tablas 4](https://github.com/user-attachments/assets/881b8488-79f2-4793-8b3a-423794260a0b)

![Creacion Tablas 5](https://github.com/user-attachments/assets/7e4f4966-b848-4a04-90f3-15c951e81270)

## Ejecución de Casos de Prueba

Para ello importar el archivo TATA.postman_collection.json que se encuentran en la carpeta POSTMAN y ejecutar cada uno de los ejemplos. Se adjuntan capturas de cada caso
probado.

![Entorno 1](https://github.com/user-attachments/assets/1487e0d8-e253-4969-98cc-fc8711f4de69)


### Clientes 

#### Creación de Clientes
![Cliente Create 1](https://github.com/user-attachments/assets/9f215a72-2267-4508-a43c-5feeed8b17e6)

![Cliente Create 2](https://github.com/user-attachments/assets/466af671-ec33-4c21-aeb4-81ac2be27f08)

![Cliente Create 3](https://github.com/user-attachments/assets/08bfa095-f66a-4bde-894f-fda100539c9d)

#### Actualización de Clientes

![Cliente Update](https://github.com/user-attachments/assets/760cee67-b7e6-4c61-b072-f0bee6d9a5bd)

#### Eliminación de Clientes

![Cliente Delete 1](https://github.com/user-attachments/assets/fb5eac07-8181-4ab7-adea-57fb63000cc4)

#### Obtención de Clientes

![Cliente GetAll 1](https://github.com/user-attachments/assets/71ba8a99-9ab4-44f1-9bee-29738a072e2a)

![Cliente GetAll 2](https://github.com/user-attachments/assets/9d9ffa2a-ae00-43df-b81c-3a44d135c78a)

![Cliente GetAll 3](https://github.com/user-attachments/assets/657f9799-bbe9-4f59-a778-290a654e208d)

#### Obtención de Cliente Especifico

![Cliente Get 1](https://github.com/user-attachments/assets/12f1ad64-28e2-4d86-b5f0-5fbeb09e0881)

![Cliente Get 2](https://github.com/user-attachments/assets/d2520e6b-0ba4-4b7a-97c9-ccf55f04a40a)


### Cuentas

#### Creación de Cuentas

![Cuenta Create 1](https://github.com/user-attachments/assets/de99f977-2320-4833-b1a0-5edd1f195cd0)

![Cuenta Create 2](https://github.com/user-attachments/assets/1d95b89d-97db-4d39-b2fe-e8454ab15e39)

![Cuenta Create 3](https://github.com/user-attachments/assets/6bf18572-68e6-43ed-bc45-8d11c9c39652)

![Cuenta Create 4](https://github.com/user-attachments/assets/a3046ce9-fc4c-4572-94ef-d65bb67af53d)

![Cuenta Create 5](https://github.com/user-attachments/assets/5a6a6d18-1729-41a9-905d-e12d8de5458d)

#### Actualización de Cuentas

![Cuenta Update](https://github.com/user-attachments/assets/6e389384-ac29-40d9-b80c-fda23b6c4caf)

#### Eliminación de Cuentas

![Cuenta Delete 1](https://github.com/user-attachments/assets/03da7c95-75d4-47f0-a15b-44b787b43c15)

#### Obtención de Cuentas

![Cuenta GetAll 1](https://github.com/user-attachments/assets/f673f7ac-fc09-4958-a2eb-c666fa7eee16)

![Cuenta GetAll 2](https://github.com/user-attachments/assets/89a02adc-fe46-444c-897d-a024a585ef43)

![Cuenta GetAll 3](https://github.com/user-attachments/assets/661bad1c-3856-44f1-a4c7-345b034789ba)

![Cuenta GetAll 4](https://github.com/user-attachments/assets/5028905f-a111-480b-b86a-26f7a0e27d7b)

![Cuenta GetAll 5](https://github.com/user-attachments/assets/325df081-550e-4cbe-aee0-c4d13104152e)

#### Obtención de Cuenta Especifica

![Cuenta Get 1](https://github.com/user-attachments/assets/a521e624-2cb4-4182-87ea-c111eb8b8c67)

![Cuenta Get 2](https://github.com/user-attachments/assets/f607e940-dcf8-48c8-95da-795aa7303693)


### Movimientos

#### Creación de Movimientos

![Movimiento Create 1](https://github.com/user-attachments/assets/2988f819-9d90-4732-ab98-56460d90a7c6)

![Movimiento Create 2](https://github.com/user-attachments/assets/718c5629-a131-432a-bf63-1a03142143ce)

![Movimiento Create 3](https://github.com/user-attachments/assets/431b5376-4414-4d71-854f-c06ae435ca13)

![Movimiento Create 4](https://github.com/user-attachments/assets/4e69c0e3-4da6-4670-a447-7cd4c3512ddd)

![Movimiento Create 5](https://github.com/user-attachments/assets/d12106f6-0e76-4438-b5c7-77ecc0e0a979)

![Movimiento Create 6](https://github.com/user-attachments/assets/465af153-605c-4236-8fa2-d159de504e88)

![Movimiento Create 7](https://github.com/user-attachments/assets/269c24b3-149d-45e7-b322-496b6e1d4c14)

#### Actualización de Movimientos

![Movimiento Update](https://github.com/user-attachments/assets/9fa1afbf-eb6b-417e-9f10-5dbe323df5a5)

#### Eliminación de Movimientos

![Movimientos Delete 1](https://github.com/user-attachments/assets/e8f4789d-d919-4a51-b72f-cfe62f9a255e)

#### Obtención de Movimientos

![Movimiento GetAll 1](https://github.com/user-attachments/assets/4f318530-0124-414d-9de4-408ace431670)

![Movimiento GetAll 2](https://github.com/user-attachments/assets/f0f556b2-5280-4344-b27e-e630920ad2d1)

![Movimiento GetAll 3](https://github.com/user-attachments/assets/55461108-2b2c-4ab1-8f34-c5cbdc7cbd4f)

![Movimiento GetAll 4](https://github.com/user-attachments/assets/8028ef1a-146d-4b7a-95c5-e48142d5a0b2)

#### Obtención de Movimiento Especifico

![Movimientos Get 1](https://github.com/user-attachments/assets/a8ee09f9-4005-46d9-a434-d84deb8fed66)

![Movimientos Get 2](https://github.com/user-attachments/assets/f17cb87c-7516-4160-9ade-0ac1619322c1)


### Reportes

![Reportes 1](https://github.com/user-attachments/assets/42297481-b12c-410e-8bc0-ced4ff1ddcc0)

![Reportes 2](https://github.com/user-attachments/assets/1bbcdfbd-1179-4cd5-bf65-f47e6f190923)

