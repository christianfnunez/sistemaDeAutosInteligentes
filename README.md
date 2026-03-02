# 🚗 RoboCars - Sistema de Autos Inteligentes en Java

Proyecto académico desarrollado en Java aplicando patrones de diseño y principios SOLID para modelar un sistema de autos inteligentes capaces de ejecutar y revertir misiones de conducción, con supervisión externa desacoplada.

---

## 📌 Descripción General

RoboCars modela autos que pueden:

- Ejecutar misiones de conducción
- Registrar historial de acciones
- Revertir la última misión ejecutada (undo)
- Notificar eventos relevantes a estaciones de control externas
- Permitir múltiples supervisores desacoplados

El sistema fue diseñado priorizando extensibilidad, bajo acoplamiento y separación de responsabilidades.

---

## 🧠 Patrones de Diseño Aplicados

### 🔹 Command Pattern
Cada misión (Acelerar, Frenar, Retroceder, etc.) se encapsula como un objeto comando.

Permite:
- Ejecutar acciones
- Deshacer acciones
- Mantener historial de operaciones
- Extender el sistema agregando nuevas misiones sin modificar el núcleo

### 🔹 Observer Pattern
Las estaciones de control se suscriben a los autos para recibir notificaciones.

Permite:
- Múltiples estaciones siguiendo un mismo auto
- Desacoplamiento entre auto y supervisores
- Agregar nuevos tipos de supervisores sin modificar la clase principal

---

## 🏗 Principios de Diseño Aplicados

- Programación Orientada a Objetos
- Open/Closed Principle
- Single Responsibility Principle
- Encapsulamiento
- Separación de responsabilidades
- Arquitectura extensible

---

## 🚦 Reglas del Dominio Modeladas

- Un auto no puede crearse con batería negativa
- La velocidad nunca puede ser negativa
- Cada misión consume batería
- Las misiones pueden revertirse
- Las notificaciones se envían cuando:
  - Se supera el límite de velocidad
  - Ocurre un evento relevante

---

## 🔁 Soporte de Reversión (Undo)

El sistema mantiene historial de misiones ejecutadas permitiendo:

- Deshacer la última misión aplicada
- Restaurar el estado anterior del auto
- Mantener coherencia del historial
- Conservar el consumo de batería

---

## 🧪 Testing y Calidad

- Cobertura de tests ≥ 95%
- Validación de casos inválidos
- Tests de ejecución y reversión de misiones
- Verificación de notificaciones a estaciones
- Manejo controlado de errores y excepciones

---

## 🛠 Tecnologías Utilizadas

- Java
- JUnit
- Git

---

## 📂 Estructura General

- Entidades de dominio (Auto, Misiones)
- Comandos concretos
- Sistema de observadores
- Tests unitarios

---

## 🚀 Posibles Extensiones

El diseño permite agregar fácilmente:

- Nuevas misiones
- Nuevos tipos de supervisores
- Nuevas reglas de negocio

Sin modificar el comportamiento central del sistema.

---

## 👤 Autor

Christian Nuñez  
Estudiante de Licenciatura en Informática  
Buenos Aires, Argentina  

GitHub: https://github.com/christianfnunez
