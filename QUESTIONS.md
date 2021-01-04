# PARTE TEORICA

### Arquitecturas de UI: MVP, MVVM y MVI

#### MVVM

##### ¿En qué consiste esta arquitectura?
Model-View-ViewModel es un patrón de arquitectura que porucre separar y distinguir los roles de cada capa de manera clara. Hay 3 capas:
- View: Las vistas muestran la interfaz y informa a las otras capas sobre las acciones de los usuarios.
- ViewModel: Expone la información a la vista.
- Model: recibe la información del datasource y la expone a los ViewModels.

##### ¿Cuáles son sus ventajas?
Controllers y Presenters suelen ser difíciles de testear por su estrecha relación con la capa de Vistas. En cambio, haciendo uso de ViewModels para la manipulación de datos permite que el testeo sea más facil, al no tener referencias a las Vistas en el ViewModel.
Además, en otro patrones que usan Controladores, es habitual el problema de "fat controllers", que provoca que la clase de los controladores sea muy larga y difícil de mantener. En cambio, con el patron MVVM se soluciona este problema al introducir el ViewModel, que reduce el riesgo de tener mucho codigo en otras capas.

##### ¿Qué inconvenientes tiene?
El principal inconveniente de este patrón es que puede ser muy complejo para aplicaciones cuya interface es simple. Al añadir tanto nivel de abstacción puede hacer la lógica mucho más complicada.

#### MVP

##### ¿En qué consiste esta arquitectura?
Escribe tu respuesta aquí

##### ¿Cuáles son sus ventajas?
Escribe tu respuesta aquí

##### ¿Qué inconvenientes tiene?
Escribe aquí tu respuesta

#### MVI

##### ¿En qué consiste esta arquitectura?
Escribe tu respuesta aquí

##### ¿Cuáles son sus ventajas?
Escribe tu respuesta aquí

##### ¿Qué inconvenientes tiene?
Escribe aquí tu respuesta

---

### Testing

#### ¿Qué tipo de tests se deberían incluir en cada parte de la pirámide de test? Pon ejemplos de librerías de testing para cada una de las partes. 
Escribe aquí tu respuesta

#### ¿Por qué los desarrolladores deben centrarse sobre todo en los Unido Tests?
Escribe aquí tu respuesta

---

### Inyección de dependencias

#### Explica en qué consiste y por qué nos ayuda a mejorar nuestro código.
Escribe aquí tu respuesta

#### Explica cómo se hace para aplicar inyección de dependencias de forma manual a un proyecto (sin utilizar librerías externas).
Escribe aquí tu respuesta