import java.util.*;
import java.io.*;

public class arvuhoidmine{
	protected static List<Integer> poisidmassidList = new ArrayList<Integer>();
	protected static List<Integer> tüdrukudmassidList = new ArrayList<Integer>();
	protected static List<Integer> poisidpikkusedList = new ArrayList<Integer>();
	protected static List<Integer> tüdrukudpikkusedList = new ArrayList<Integer>();

	public int poisidList(int poisidmassid, int poisidpikkused){
		poisidmassidList.add(poisidmassid);
		poisidpikkusedList.add(poisidpikkused);
		return 0;
	}

	public int tüdrukudList(int tüdrukudmassid, int tüdrukudpikkused){
		tüdrukudmassidList.add(tüdrukudmassid);
		tüdrukudpikkusedList.add(tüdrukudpikkused);
		return 0;
	}
	
	public static void tulemused(){
		System.out.println(poisidmassidList);
		System.out.println(poisidpikkusedList);
		System.out.println(tüdrukudmassidList);
		System.out.println(tüdrukudpikkusedList);
	}
}