import java.util.ArrayList;
import java.util.List;

// Родительский класс "Animal"
abstract class Animal {
    private String name;
    private String birthDate;
    private List<String> commands;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Дата рождения: " + birthDate;
    }
}

// Класс для домашних животных
class DomesticAnimal extends Animal {
    public DomesticAnimal(String name, String birthDate) {
        super(name, birthDate);
    }
}

// Класс для вьючных животных
class PackAnimal extends Animal {
    public PackAnimal(String name, String birthDate) {
        super(name, birthDate);
    }
}