package Telephone.Cell;


/**
* Cell/TubeCallbackOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Telephone.idl
* 17 ��� 2022 �. 16:16:49 MSK
*/


/*  ? ! �!! � !  U �! �!  U V U  !9 � U  � !!!S � T Q */
public interface TubeCallbackOperations 
{

  /*  _! Q !!!
 ! U U �!0 �  Q � message  U!   U X �! � fromNum */
  int sendSMS (String fromNum, String message);

  /*   �! !S!!
 !  U    U X �! */
  String getNum ();
} // interface TubeCallbackOperations