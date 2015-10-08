/** Класс для приветствия */
public class Hello {
	private String name;
	private int count;
	
	public Hello() {
		name = "мир";
		count = 0;
	}
	/** Установка имени 
	* @param s Имя
	*/
	public void setName(String s) {
		name = s;
	}
	/** Установка количества имён
	* @param c Количество имён
	*/
	public void setCount(int c) {
		count = c;
	}
	
	/** Вывод приветствия */
	public void say() {
		System.out.println("Привет, " + name + "!");
	}
	/** Вывод количества */
	public void sayCount() {
		System.out.println("Количество имён: " + count);
	}
}