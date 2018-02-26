import java.io.*;
public class loomademassivordlus{
	public static void main(String[] arg) throws Exception{
		
		Vork1 V=new Vork1();
		V.andmed();
		joonistamine J= new joonistamine();
		J.joonistamine();
		System.out.println(V.vordlus());
		
	}
}
