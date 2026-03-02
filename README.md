[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/zmr38O-b)
# 2do Parcial de Objetos II - Com 2 y 4

## Consideraciones Iniciales

- El código entregado debe compilar obligatoriamente. **Un parcial entregado cuyo código no compila queda desaprobado automáticamente**.

- Se realizará un control exhaustivo, incluyendo distintas herramientas de análisis estático de código para identificar posibles copias entre las soluciones entregadas.

- La solución debe aplicar patrones de diseño apropiados para la problemática planteada. **El uso inadecuado de patrones, descalifica el examen automáticamente**

- El código entregado debe tener los test suficientes que garantice el correcto funcionamiento de la solucion que propone el alumno (*esperado 75% +*)

- No se aceptan entregas fuera de plazo ni que no estén correctamente subidas al repositorio del classroom de la materia

- Las entregas que tengan un solo commit o no reflejen el progreso del proceso de solución, seran desaprobadas. **Se recomienda fuertemente realizar commits/push periodicamente y asegurarse de que impactaron correctamente en el repositorio remoto**.

## 🌐 Introducción y conexto

La industria automotriz moderna incorpora cada vez más sistemas inteligentes que permiten ejecutar misiones preprogramadas, supervisar su desempeño y revertir acciones en caso de fallas.  
En este parcial, se modelará un sistema de **autos inteligentes** capaces de ejecutar y deshacer misiones, informar su estado a estaciones de control, y reaccionar ante situaciones de riesgo.

---

# 🚦 RoboCars

La empresa **RoboCars** desarrolla autos que pueden recibir **misiones de conducción**.  
Cada auto mantiene un historial de lo que va haciendo para poder revertir cualquier acción si es necesario.

---

## 🚗 Autos Inteligentes

Cada auto posee:

- Patente
- Cantidad de bateria 
- Velocidad actual

Un auto **no puede existir** si su bateria inicial es negativa.  
Si esto ocurre, debe **fallar** la creación del mismo.

La velocidad **jamás puede ser negativa**.

Los autos deben permitir consultar su estado en todo momento.

---

## 🧭 Misiones de Conducción

Un auto puede recibir distintas **misiones**, por ejemplo:

- Acelerar
- Frenar
- Desacelerar
- Retroceder
- Cargar toda la bateria

### Descripción de misiones

| Misión | Descripción | Efecto sobre el auto | Reglas |
|--------|--------------|----------------------|---------|
| **Acelerar** | Incrementa la velocidad en 10 km/h | 10 km/h | Si supera 120, se notifica exceso de velocidad |
| **Desacelerar** | Disminuye la velocidad en 10 km/h | 10 km/h | No puede dejar la velocidad en negativa |
| **Frenar** | Detiene el auto completamente | 0 km/h | No tiene restricciones |
| **Retroceder** | Retrocede a baja velocidad | 5 km/h (modo reversa simulado) | Solo si la velocidad actual = 0 |
| **CargarBateriaAlMaximo** | Restaura la batería a 100 % | batería = 100 | No depende del estado actual |


### Reglas importantes

- Cada misión debe poder aplicarse sobre el auto **y deshacerse** para volver al estado anterior.
- Deshacer una misión, no restaura la bateria consumida.
- El auto debe registrar **todas las misiones ejecutadas**.
- Cada mision consume 1 porciento de bateria.


## Aplicación

Desde ella se debe enviar la lista de misiones que debe ejecutar el auto y deshacer la última instrucción en caso de ser necesario


## 📡 Supervisión Externa

Cada auto puede ser seguido por **una estación de control** que recibe avisos cuando:

- La velocidad del auto **supera los 120 km/h**
- Ocurre algún evento de conducción relevante

La estación debe mantener **un historial** de todos los avisos recibidos.

Deben poder existir **múltiples estaciones de control** siguiendo a un mismo auto.  
También se debe poder **dejar de seguir** un auto en cualquier momento.

## 🔁 Seguridad y Reversión

Los autos deben poder **deshacer la última misión** aplicada.  
Esto no solo afecta su estado, sino también las notificaciones derivadas.


## 🧪 Calidad y Pruebas

Se debe contar con **al menos 75% de cobertura** a nivel de lógica del sistema.  
Las pruebas deben incluir:

- Creación de autos válida y no válida
- Casos donde misiones deban **fallar**
- Efectos esperados de cada misión
- Que una misión **realmente se revierta**
- Avisos a la(s) estación(es) de control cuando corresponde


## ☑️ Comportamientos esperados (resumen)

- El auto recibe misiones → cambia estado → registra lo que hizo
- Si se produce un caso inválido → el sistema debe **fallar de forma controlada**
- Si la misión lo amerita → se envía un aviso a quienes monitorean
- Se puede dejar sin efecto la última misión realizada

---

> **La implementación debe contemplar la posibilidad de agregar nuevas misiones y nuevos tipos de supervisores sin modificar el comportamiento central del auto.**
