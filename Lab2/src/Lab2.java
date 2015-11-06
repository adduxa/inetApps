/**
 * Университет ИТМО
 * Кафедра вычислительной техники
 * Вычислительная математика
 *
 * Лабораторная работа №2
 * Основы ООП в Java
 * Вариант: 2012
 *
 * Выполнил:
 * студент II курса факультета КТиУ
 * Дьяков Андрей Александрович, группа P3200
 *
 * Преподаватель:
 * Гаврилов Антон Валерьевич
 *
 * Санкт-Петербург, 2015г.
 */

public class Lab2 {
	public static void main(String[] args) {
		//Создаём экземпляр класса Weepinbell, но используем тип Bellsprout
		Bellsprout brother = new Weepinbell();
		Bellsprout father = new Bellsprout();
		Weepinbell daughter = new Weepinbell();

		brother.camouflage();  //Используется метод класса Bellsprout
		father.knockOff(daughter);
		daughter.knockOff(brother);  //Используется переопределённый метод; перегрузка для типа Bellsprout
		father.focusEnergy();
		daughter.knockOff(father);
		daughter.stockpile();  //Можно использовать как собственные методы
		father.camouflage();
		brother.swordsDance();
		daughter.conversion();
		brother.workUp();
		daughter.overgrow();  //Так и наследованные
		daughter.workUp();
		((Weepinbell)brother).sharpen();  //У Bellsprout нет метода sharpen, поэтому явно приводим к типу Weepinbell
		father.workUp();
		daughter.camouflage();
		father.knockOff(brother);
	}
}

class Bellsprout {
	protected int glow;
	protected String bug = "Bug";
	protected String flying = "Flying";
	public byte jump;
	double weight = 6.9;
	static int overland = 98;
	protected String bugFlying = "BugFlying";

	//Конструктор класса
	public Bellsprout() {
		glow = 98;  //будет использоваться 98, так как сначала инициализируются поля, а затем вызывается конструктор
	}
	
	//Инициальзация полей
	{
		glow = 46;
		jump = (byte) 0x98;  //0x98 = 0b10011000 = -0b1101000 = -104
	}


	//Перегрузка метода для параметра типа Weepinbell
	public void knockOff(Weepinbell p) {
		System.out.println("Bellsprout attacks Weepinbell with Knock Off");
	}

	public void camouflage() {
		System.out.println("Bellsprout casts Camouflage");
	}

	public void overgrow() {
		System.out.println(jump - glow);
		System.out.println(overland - jump);
		System.out.println(glow + overland);
	}

	public static void workUp() {
		System.out.println("Bellsprout casts Work Up");
	}

	public void swordsDance() {
		System.out.println(bugFlying.equals(bug+"Flying"));  //true  Equals проверяет содержимое строк
		System.out.println(bugFlying == "Bug"+flying);  //false  == проверяет на один ли и тот же object ссылаются переменные
		System.out.println(bugFlying == bug+flying);  //false
		System.out.println(bugFlying.equals("Bug"+"Flying"));  //true
		System.out.println(bugFlying.equals(bug+flying));  //true
		System.out.println(bugFlying == "Bug"+"Flying");  //true  Компилятор объединил две константы с одинаковым содержанием в одну - поэтому ссылки равны
	}
	
	//Перегрузка метода для параметра типа Bellsprout
	public void knockOff(Bellsprout p) {
		System.out.println("Bellsprout attacks Bellsprout with Knock Off");
	}

	public void focusEnergy() {
		double speed = 3.9;

		System.out.println((weight - speed) == 3.0);  //6.9 - 3.9 != 3.0 так как double является неточным представлением числа
	}
}

class Weepinbell extends Bellsprout {
	private String poison = "Poison";
	private int shrinkable;
	private String poisonFlying = "PoisonFlying";
	float depth = 6.9f;

	//Конструктор класса
	public Weepinbell() {
		shrinkable = 061;  //Значение в восьмеричной СС. равно 49
	}


	//Перегрузка метода для параметра типа Weepinbell
	public void knockOff(Weepinbell p) {
		System.out.println("Weepinbell attacks Weepinbell with Knock Off");
	}

	public void stockpile() {
		float evasion = 9.1f;

		System.out.println((evasion - depth) == 2.2f);
	}

	public void sharpen() {
		System.out.println(poisonFlying == new String("Poison"+"Flying"));  //false Проверяется равенство ссылок на объекты, а он создан в runtime
		System.out.println(poisonFlying == poison+flying);  //false
		System.out.println(poisonFlying == new String("PoisonFlying"));  //false
		System.out.println(poisonFlying == (poison+flying).intern());  //true Метод intern перед созданием объекта String смотрит есть ли этот объект в пуле стрингов и возвращает его. Иначе создается новый объект в пуле.
	}

	//
	public void camouflage() {
		System.out.println("Weepinbell casts Camouflage");
	}

	public void conversion() {
		System.out.println(shrinkable + jump);
		System.out.println(shrinkable - overland);
		System.out.println(glow - shrinkable);
	}

	//Перегрузка метода для параметра типа Bellsprout
	public void knockOff(Bellsprout p) {
		System.out.println("Weepinbell attacks Bellsprout with Knock Off");
	}

	//
	public static void workUp() {
		System.out.println("Weepinbell casts Work Up");
	}
}