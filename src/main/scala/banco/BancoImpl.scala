package bancoScala

import banco1._

class BancoImpl extends BancoPOA {
  var cuentas: List[banco1.Datos] = Nil

  def crearCuenta(datos: Datos): Unit = {
  /*   val cuenta = new DatosImpl
     cuenta.setNombre(nombre)
     cuenta.setSaldo(cantidad)
     cuenta.setNumCuenta(numC)
     cuentas = cuenta._this :: cuentas*/
     cuentas = datos :: cuentas
  }

  def depositar(numero: Int,cantidad: Double): Double = {
    for (cuenta  <- cuentas
           if numero == cuenta.getNumCuenta)
      cuenta.setSaldo(cuenta.getSaldo +  cantidad)
      cantidad
   }

   def retirar(numero: Int,cantidad: Double): Double = {
     for (cuenta  <- cuentas
            if numero == cuenta.getNumCuenta
            if (cuenta.getSaldo - cantidad) >= 0 ) {
         cuenta.setSaldo(cuenta.getSaldo - cantidad)
         return cuenta.getSaldo
       }
       0.0
     }

   def consulta(numC: Int): Double = {
     for (cuenta  <- cuentas
            if numC == cuenta.getNumCuenta)
        return cuenta.getSaldo
     0.0
   }

   def verCuentas(): Array[banco1.Datos]  = cuentas.toArray
}
