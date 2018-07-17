# demoAdvance
Demo entrevista advance

IDE sts-3.9.0 java 8
*** BD MySql 5.7--> Se debe crear el esquema entrevista_credito
VisualCode --> angular 5, primeng = 5.2.4

Script BD

INSERT INTO `entrevista_credito`.`persona`
(`id`,`apellidos`,`cargas_familiares`,`direccion_id`,`estado_civil_id`,`fecha_nacimiento`,`nombres`,`numero_identificacion`,`telefono_id`)
VALUES(1,'prueba',null,null,null,null,'pruebaAdmin',111111111,null);

INSERT INTO `entrevista_credito`.`usuario`
(`user_id`,`estado`,`password`,`persona_id`,`rol`,`username`)VALUES(5,true,'$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri',1,'A','admin');

INSERT INTO `entrevista_credito`.`catalogo` (`id`, `descripcion`, `estado`, `valor`) VALUES ('1', 'ESTADOCIVIL', true, 'ESTADOCIVIL');
INSERT INTO `entrevista_credito`.`catalogo` (`id`,`catalogo_padre_id`, `descripcion`, `estado`, `valor`) VALUES ('2','1','SOLTERO', true, 'SOLTERO');
INSERT INTO `entrevista_credito`.`catalogo` (`id`,`catalogo_padre_id`, `descripcion`, `estado`, `valor`) VALUES ('3','1','CASADO', true, 'CASADO');
INSERT INTO `entrevista_credito`.`catalogo` (`id`,`catalogo_padre_id`, `descripcion`, `estado`, `valor`) VALUES ('4','1','DIVORCIADO', true, 'DIVORCIADO');
INSERT INTO `entrevista_credito`.`catalogo` (`id`, `descripcion`, `estado`, `valor`) VALUES ('5', 'TIPODIRECCION', true, 'TIPODIRECCION');
INSERT INTO `entrevista_credito`.`catalogo` (`id`,`catalogo_padre_id`, `descripcion`, `estado`, `valor`) VALUES ('6','5','Tipo 1', true, 'Tipo 1');
INSERT INTO `entrevista_credito`.`catalogo` (`id`,`catalogo_padre_id`, `descripcion`, `estado`, `valor`) VALUES ('7','5','Tipo 2', true, 'Tipo 2');
INSERT INTO `entrevista_credito`.`catalogo` (`id`, `descripcion`, `estado`, `valor`) VALUES ('8', 'TIPODIRECCION', true, 'TIPOTELEFONO');
INSERT INTO `entrevista_credito`.`catalogo` (`id`,`catalogo_padre_id`, `descripcion`, `estado`, `valor`) VALUES ('9','8','Domicilio', true, 'Domicilio');
INSERT INTO `entrevista_credito`.`catalogo` (`id`,`catalogo_padre_id`, `descripcion`, `estado`, `valor`) VALUES ('10','8','Celular', true, 'Celular');

---------------------------
Para el backend 
Se lo debe abrir en sts-3.9.0
Para correr el backend primero (***)
1.-se debe importar las carpetas com.entrevista.demo.oda como Existing Maven Projects
y seleccionar los proyecto credito, seguridad.

2.- Se debe tomar en cuenta cambiar las credenciales de la base de datos en los archivos 
application.properties de cada proyecto este se ubica src/main/resource

3.- Para correr el backend se debe correr primero el modulo de seguridad como Run As--> Spring Boot App
luego el modulo de credito como Run As--> Spring Boot App

----------------------------
Para el frontend

Se lo puede abrir en VisualCode

Se debe abrir la carpeta entrevista_front
1.- en consola--> npm install
2.- npm start

se corre la app por el puerto 4200:

la primera pagina es http://localhost:4200/#/pages/login
para ingresar:

usuario: admin
password: password










