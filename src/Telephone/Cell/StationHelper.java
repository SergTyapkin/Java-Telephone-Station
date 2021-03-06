package Telephone.Cell;


/**
* Cell/StationHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Telephone.idl
* 17 ��� 2022 �. 16:16:49 MSK
*/


/*  ? ! �!! � !  � � � U  U  !! � !  Q Q */
abstract public class StationHelper
{
  private static String  _id = "IDL:Cell/Station:1.0";

  public static void insert (org.omg.CORBA.Any a, Station that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Station extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (StationHelper.id (), "Station");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Station read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_StationStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Station value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Station narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Station)
      return (Station)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _StationStub stub = new _StationStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Station unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Station)
      return (Station)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      _StationStub stub = new _StationStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
