import java.util.*;
import java.io.*;

public class ImageData{
	protected static List<Integer> DogMassesList = new ArrayList<Integer>();
	protected static List<Integer> DogHeightsList = new ArrayList<Integer>();
	protected static List<Integer> CatMassesList = new ArrayList<Integer>();
	protected static List<Integer> CatHeightsList = new ArrayList<Integer>();

	public int DogsToList(int mass, int height){
		DogMassesList.add(mass);
		DogHeightsList.add(height);
		return 0;
	}

	public int CatsToList(int mass, int height){
		CatMassesList.add(mass);
		CatHeightsList.add(height);
		return 0;
	}

}