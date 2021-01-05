# PARTE TEORICA

### Arquitecturas de UI: MVP, MVVM y MVI

#### MVVM

##### ¿En qué consiste esta arquitectura?
Model-View-ViewModel es un patrón de arquitectura que porcura separar y distinguir los roles de cada capa de manera clara. Hay 3 capas:
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
Model-View-Presenter es un patrón de arquitectura que permite mejorar la separación de tareas y los tests unitarios. Consiste en tres capas:
- Model: Es la capa de datos, responsable para la lógica de negocio. Recibiendo, guardando y cambiando los datos.
- View: Muestra la interefaz y escucha las acciones de los usuarios. Oculta o muestra las vistas i trata la navegación de las pantallas. En Android extiende de Activity o Fragment.
- Presenter: Interacciona tanto con el Modelo y la Vista, y trata la lógica de presentación. Es la clase que une el Modelo y las Vistas.

Si además se hace uso de Interfaces para el Presenter y las View, se evita el acoplamiento entre el Presenter y la View, haciendo que el Presenter trate con la ViewInterface en vez de directamente la Activity.

##### ¿Cuáles son sus ventajas?
Esta arquitectura permire una buena separación de capas y permite realizar tests-unitarios para la capa de Model y Presenter.


##### ¿Qué inconvenientes tiene?
Hay que tener en cuenta lo que pasa con el Presenter una vez se destruye la Activity. Ya que si no se trata, puede causar errores si se hace referencia a la Activity destuida. I en el caso de destruir el Presenter junto a la Activity, hay que tener en cuenta que no haya referencias al Presenter en otra clase que siga activa en memoria.


#### MVI

##### ¿En qué consiste esta arquitectura?
Model-View-Intent es un nuevo patrón de arquitectura para Android. Los roles de los componentes de esta arquitectura són los siguientes:
- Model: Representa un estado. Los modelos deben ser inmutables para asegurar una direccionalidad del flujo de datos entre ellos y las otras capas de la arquitectura.
- Intent: Representa una intención o deseo de realizar una acción por el usuario. Para cada acción de un usuario, un Intent será recibido por la View, el Presenter lo observará y se traducirá a un nuevo estado del Model.
- View: Són representados por las Interfaces como en el patrón MVP. Se implementa con Activities o Fragments.

##### ¿Cuáles son sus ventajas?
Una de las principales ventajas es unidireccionalidad y un flujo cíclico de los datos de la aplicación.
Otra ventaja es que proporciona un estado consistente durante el ciclo de vida de las vistas.
Por último, la inmutabilidad de los Modelos proporciona un comportamento seguro en aplicaciones grandes.


##### ¿Qué inconvenientes tiene?
El mayor y seguramente el único inconveniente del patrón MVI es la curva de aprendizaje de este patrón, ya que és más grande debido a la necesidad de conocimiento de programación reactiva, multi-threading...

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