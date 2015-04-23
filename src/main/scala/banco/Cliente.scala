import org.omg.CosNaming._
import banco1._
import bancoScala._

object Cliente {
  def main(args: Array[String]) = {
    try {
      val orb = org.omg.CORBA.ORB.init(args, null)
      val ncCorba = orb.resolve_initial_references("NameService")
      val nc = NamingContextExtHelper.narrow(ncCorba)

      val bancCorba = nc.resolve(nc.to_name("banco"))
      val banc = BancoHelper.narrow(bancCorba)

      val datoCorba = nc.resolve(nc.to_name("dato"))
      val dato = DatosHelper.narrow(datoCorba)
      dato.setNombre("juan")
      dato.setSaldo(1000.0)
      dato.setNumCuenta(1245)
      banc.crearCuenta(dato)
      println("(" + dato.getNumCuenta + ", " + dato.getNombre + ", " + dato.getSaldo +")")
    }
    catch {
      case e: Exception => print("error " + e)
    }
  }
}
