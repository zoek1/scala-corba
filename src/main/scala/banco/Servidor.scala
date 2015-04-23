import org.omg.CosNaming._
import org.omg.PortableServer._
import banco1._
import bancoScala._

object Servidor {

  def main(args: Array[String]) = {

    try {
      val orb = org.omg.CORBA.ORB.init(args, null)

      val raizPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"))
      raizPOA.the_POAManager().activate()

      val calServant = new BancoImpl
      val calCorba = raizPOA.servant_to_reference(calServant)
      val ncCorba = orb.resolve_initial_references("NameService")
      val nc = NamingContextExtHelper.narrow(ncCorba)
      nc.rebind(nc.to_name("banco"), calCorba)

      val datServant = new DatosImpl
      val datCorba = raizPOA.servant_to_reference(datServant)
      val datNcCorba = orb.resolve_initial_references("NameService")
      val datNc = NamingContextExtHelper.narrow(datNcCorba)
      datNc.rebind(datNc.to_name("dato"), datCorba)

      orb.run()
    } catch {
      case e: Exception => print("error " + e)
    }
  }
}
