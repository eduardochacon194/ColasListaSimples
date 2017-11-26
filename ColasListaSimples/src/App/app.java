package App;

import Queue.Queue;

public class app {

	public static void main(String[] args) {
		Queue<String> names = new Queue<String>(5);
		try {
			System.out.println("---------------Cola Iterator-----------");
			names.enQueue("Jose");
			names.enQueue("Ana");
			names.enQueue("Ricar2");
			names.enQueue("Aaron");
			names.enQueue("Milton");
			for (String but : names) 
			{
				names.iterator();
			}
			System.out.println("---------------Buscar Jose-----------");
			System.out.println("Buscar: " + names.search("Jose"));
			System.out.println("---------------Eliminar Jose Y Ana-----------");
			System.out.println("Eliminar: " + "Jose" + " Y "+ names.deQueue());
			names.deQueue();
			System.out.println("---------------Front Ricar2-----------");
			System.out.println("Pront: " +names.front());
			System.out.println("---------------Tamaño -----------");
			System.out.println("Tamaño: " +names.size());
			System.out.println("---------------Lista Iterator -----------");
			for (String lista : names) 
			{
				names.iterator();
			}
			System.out.println("---------------Cola Vacia -----------");
			names.clear();
			System.out.println("Lista Y Cola Vacia");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}