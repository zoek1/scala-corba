package banco1;


/**
* banco1/BancoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from banco1.idl
* miércoles 22 de abril de 2015 19H43' CDT
*/

public abstract class BancoPOA extends org.omg.PortableServer.Servant
 implements banco1.BancoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("crearCuenta", new java.lang.Integer (0));
    _methods.put ("depositar", new java.lang.Integer (1));
    _methods.put ("retirar", new java.lang.Integer (2));
    _methods.put ("consulta", new java.lang.Integer (3));
    _methods.put ("verCuentas", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // banco1/Banco/crearCuenta
       {
         banco1.Datos datos = banco1.DatosHelper.read (in);
         this.crearCuenta (datos);
         out = $rh.createReply();
         break;
       }

       case 1:  // banco1/Banco/depositar
       {
         int numero = in.read_long ();
         double cantidad = in.read_double ();
         double $result = (double)0;
         $result = this.depositar (numero, cantidad);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 2:  // banco1/Banco/retirar
       {
         int numero = in.read_long ();
         double cantidad = in.read_double ();
         double $result = (double)0;
         $result = this.retirar (numero, cantidad);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 3:  // banco1/Banco/consulta
       {
         int num = in.read_long ();
         double $result = (double)0;
         $result = this.consulta (num);
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       case 4:  // banco1/Banco/verCuentas
       {
         banco1.Datos $result[] = null;
         $result = this.verCuentas ();
         out = $rh.createReply();
         banco1.sequenceDatosHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:banco1/Banco:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Banco _this() 
  {
    return BancoHelper.narrow(
    super._this_object());
  }

  public Banco _this(org.omg.CORBA.ORB orb) 
  {
    return BancoHelper.narrow(
    super._this_object(orb));
  }


} // class BancoPOA
