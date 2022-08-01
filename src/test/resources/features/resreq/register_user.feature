Feature: Registro de usuarios
  Con el fin de poder administrar mis productos bancarios
  Yo como usuario quiero poder registrarme
  Para poder realizar pagos y ejecutar operaciones sobre mis productos

  Scenario: Registro exitoso de usuarios
    Given "Fernanda" es un cliente que quiere poder administrar sus productos bancaarios
    When el envia la informacion requerida para el registro
    Then el debe obtener una cuenta virtual para poder ingresar cuando lo requiera.