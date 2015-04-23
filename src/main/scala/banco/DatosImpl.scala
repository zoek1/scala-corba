package bancoScala

import banco1._

class DatosImpl extends DatosPOA {
  private[this] var numC: Int = _
  private[this] var saldo: Double = _
  private[this] var nombre: String = ""

  def setNumCuenta(numC: Int) : Unit = {
    this.numC = numC
    Unit
  }

  def setSaldo(saldo: Double) : Unit = {
    this.saldo = saldo
    Unit
  }

  def setNombre(nombre: String) : Unit = {
    this.nombre = nombre
    Unit
  }

  def getNombre(): String = this.nombre
  def getSaldo(): Double = this.saldo
  def getNumCuenta(): Int = this.numC

  override def toString(): String = {
    s"No. Cuenta: $numC - Nombre: $nombre - Saldo: $saldo"
  }
}
