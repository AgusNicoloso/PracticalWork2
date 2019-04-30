<p align="center">
  <img src ="https://i.ibb.co/4V4PTLP/TP2.png" />
</p>

# 😵🧵 Ahorcado - Maven - Threads 🧵😵

## Diferencia entre Runnable y Thread

_Un hilo es una secuencia de instrucciones que está controlada por un planificador. El planificador gestiona el tiempo de ejecución del procesador y asigna de alguna manera dicho tiempo a los diferentes hilos actualmente presentes.
Normalmente los hilos de un proceso suelen tener acceso a todos los recursos disponibles al proceso, es decir, actuan sobre una memoria compartida.
La interfaz Runnable nos sirve utilizarla cuando no es conveniente extender la clase Thread porque se pierde la posibilidad de extender otro objeto. Es una de las razones por que existe la interfaz Runnable que declara nada más que el método public void run() y que se puede usar fácilmente para crear hilos.
Pero al mismo tiempo se pierde la posibilidad de poder extender los metodos que brinda la clase Thread_

## Ciclo de vida de un Thread

* **Nuevo (New)**: El thread ha sido creado pero no inicializado. es decir, no se ha ejecutado todavía el método start().
* **Ejecutable (Runnable)**: El thread puede estar ejecutándose, siempre y cuando se le haya asignado un determinado tiempo de CPU.
* **Bloqueado (Blocked o Not Runnable)**: El thread podría estar ejecutándose, pero hay alguna actividad interna suya que lo impide. Si un thread está en este estado, no se le asigna tiempo de CPU.
* **Muerto (Dead)**: La forma habitual de que un thread muera es finalizando el método run(). También puede llamarse al método stop() de la clase Thread. Aunque dicho método es considerado "peligroso" y no se debe utilizar. 

## Explique los metodos [Start, sleep, yield, join]

* **Start**: Hace que este hilo comience a ejecutarse. La máquina virtual Java llama al método de ejecución de este hilo.
* **Sleep**: Hace que el hilo que se está ejecutando en ese momento se duerma (detener temporalmente la ejecución) durante el número especificado de milisegundos, sujeto a la precisión y exactitud de los temporizadores y programadores del sistema.
* **Yield**: Una pista al programador de que el hilo actual está dispuesto a ceder su uso actual de un procesador.
* **Join**: Espera un máximo de milisegundos para que este hilo muera.

<p align="center">
  <img src ="http://www.mecanica.frba.utn.edu.ar/energiaundimotriz/wp-content/uploads/UTN-Mar-del-Plata.png" />
</p>
<p align="center">
  <img src ="https://maven.apache.org/images/maven-logo-black-on-white.png" />
</p>
