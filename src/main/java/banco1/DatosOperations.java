package banco1;


/**
* banco1/DatosOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from banco1.idl
* miércoles 22 de abril de 2015 19H43' CDT
*/

public interface DatosOperations 
{
  void setNumCuenta (int numC);
  void setSaldo (double cantidad);
  void setNombre (String nombre);
  String getNombre ();
  int getNumCuenta ();
  double getSaldo ();
} // interface DatosOperations
