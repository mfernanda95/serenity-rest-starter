Feature: Eliminar reservas
  Con el fin de poder administrar las reservas del hotal
  Yo como usuario quiero poder eliminar
  Para mantener la información actualizada.

  @my-test
  Scenario Outline: Eliminar reserva
    Given "Fernanda" es el administrador de la plataforma
    And tiene sus credenciales activas "<user>" "<password>"
    When elimina una reserva "<idBooking>"
    Then puede eliminar las reservas que ya no estan activas
    Examples:
    |user|password|idBooking|
    |eve.holt@reqres.in|pistol|3903|
