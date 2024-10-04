import java.util.*;

public class AnimalRegistry {
    private static List<Animal> animals = new ArrayList<>();
    private static Counter counter = new Counter();

    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("\nМеню:");
                System.out.println("1. Завести новое животное");
                System.out.println("2. Показать всех животных");
                System.out.println("3. Показать команды животного");
                System.out.println("4. Обучить животное новой команде");
                System.out.println("5. Выйти");
                System.out.print("Выберите опцию: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // для очистки буфера

                switch (choice) {
                    case 1:
                        addNewAnimal(scanner, counter);
                        break;
                    case 2:
                        showAllAnimals();
                        break;
                    case 3:
                        showAnimalCommands(scanner);
                        break;
                    case 4:
                        teachNewCommand(scanner);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Неверный выбор, попробуйте снова.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод для добавления нового животного
    private static void addNewAnimal(Scanner scanner, Counter counter) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        String birthDate = scanner.nextLine();

        System.out.println("Выберите тип животного:");
        System.out.println("1. Домашнее животное");
        System.out.println("2. Вьючное животное");
        int type = scanner.nextInt();
        scanner.nextLine(); // для очистки буфера

        Animal newAnimal;
        if (type == 1) {
            newAnimal = new DomesticAnimal(name, birthDate);
        } else if (type == 2) {
            newAnimal = new PackAnimal(name, birthDate);
        } else {
            System.out.println("Неверный выбор типа животного.");
            return;
        }

        animals.add(newAnimal);
        counter.add(); // Увеличиваем счётчик при добавлении нового животного
        System.out.println("Новое животное добавлено.");
    }

    // Метод для показа всех животных
    private static void showAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Нет животных.");
        } else {
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        }
    }

    // Метод для показа команд животного
    private static void showAnimalCommands(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = findAnimalByName(name);

        if (animal != null) {
            System.out.println("Команды: " + animal.getCommands());
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    // Метод для обучения животного новой команде
    private static void teachNewCommand(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = findAnimalByName(name);

        if (animal != null) {
            System.out.print("Введите новую команду: ");
            String command = scanner.nextLine();
            animal.addCommand(command);
            System.out.println("Животное обучено новой команде.");
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    // Поиск животного по имени
    private static Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}