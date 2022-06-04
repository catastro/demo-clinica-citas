


INSERT INTO doctor (nombre,numeroColegiatura,dni,edad,especialidad)
VALUES ( 'Luis Alfaro', '0001234','12345678',53,'Medicina Interna');
INSERT INTO doctor (nombre,numeroColegiatura,dni,edad,especialidad)
VALUES ('Carlos Ramos', '0001265','34512398',44,'Medicina Interna');


INSERT INTO paciente (nombre,dni,edad) VALUES ('Alex','11111111',23);
INSERT INTO paciente (nombre,dni,edad) VALUES ('Pedro','66666666',23);

INSERT INTO cita (fechahora,doctor_id,paciente_id, estado) VALUES ('2020-01-30T11:00',1,1, 'programado');
INSERT INTO cita (fechahora,doctor_id,paciente_id, estado) VALUES ('2020-01-30T11:00',1,1, 'atendido');


INSERT INTO receta (fechahora,doctor_id,paciente_id,cita_id) VALUES ('2020-01-30T11:00',1,1,1);

INSERT INTO recetadetalle (producto,cantidad,indicaciones,receta_id) VALUES ('paracetamol',1,'cada 8 horas',1);


