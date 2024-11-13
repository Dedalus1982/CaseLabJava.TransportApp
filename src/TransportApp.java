import java.util.Scanner;

//  Вид транспорта
enum TransportType {
    CAR,
    AIRPLANE,
    SHIP,
    BICYCLE,
    DONKEY
}

//  Вид топлива
enum FuelType {
    PETROL,
    DIESEL,
    KEROSENE,
    BIGMAC,
    GRASS
}

sealed abstract class Transport permits Car, Airplane, Ship, Bicycle, Donkey {
    protected String name; // #Название транспорта
    protected int capacityPpl; // Вместимость (чел)
    protected int capacityCargo; // Вместимость (кг)
    protected double maxSpeed; // макс. скорость
    protected FuelType fuelType;
    protected TransportType type;
    protected boolean isMoving; // в движении или остановлен

    public Transport(String name, int capacityPpl, int capacityCargo, double maxSpeed, FuelType fuelType, TransportType type) {
        this.name = name;
        this.capacityPpl = capacityPpl;
        this.capacityCargo = capacityCargo;
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
        this.type = type;
        this.isMoving = false; // Изначально транспорт остановлен
    }

    public abstract void start(); // метод для пкска транспорта
    public abstract void stop(); // метод для остановки транспорта
    public abstract void refuel(); // метод для заправки
    public abstract void displayInfo(); // метод для вывода информации о состоянии транспорта

    public boolean isMoving() {
        return isMoving;
    }

    protected void setMoving(boolean moving) {
        isMoving = moving;
    }
}

final class Car extends Transport {
    final private String colorType;

    public Car(String name, int capacityPpl, int capacityCargo, double maxSpeed, FuelType fuelType, String colorType) {
        super(name, capacityPpl, capacityCargo, maxSpeed, fuelType, TransportType.CAR);
        this.colorType = colorType;
    }

    @Override
    public void start() {
        if (!isMoving) {
            System.out.println(type + " " + name + " едет.");
            setMoving(true);
        } else {
            System.out.println(type + " " + name + " уже в движении.");
        }
    }

    @Override
    public void stop() {
        if (isMoving) {
            System.out.println(type + " " + name + " остановлен.");
            setMoving(false);
        } else {
            System.out.println(type + " " + name + " уже остановлен.");
        }
    }

    @Override
    public void refuel() {
        if (!isMoving) {
            System.out.println(type + " " + name + " заправляется топливом: " + fuelType);
        } else {
            System.out.println(type + " " + name + " не может заправляться, пока в движении.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println((isMoving ? "Едет: " : "Стоит ") + type + ": " + name +
                ", цвета " + colorType +
                ", в салоне " + capacityPpl + " чел." +
                ", в багажнике " + capacityCargo + " кг. груза" +
                ", на максималке: " + maxSpeed + " км/ч" +
                ", едем на топливе: " + fuelType);
    }
}

final class Airplane extends Transport {
    final private String gearType;

    public Airplane(String name, int capacityPpl, int capacityCargo, double maxSpeed, FuelType fuelType, String gearType) {
        super(name, capacityPpl, capacityCargo, maxSpeed, fuelType, TransportType.AIRPLANE);
        this.gearType = gearType;
    }
    @Override
    public void start() {
        if (!isMoving) {
            System.out.println(type + " " + name + " полетел.");
            setMoving(true);
        } else {
            System.out.println(type + " " + name + " уже летит.");
        }
    }

    @Override
    public void stop() {
        if (isMoving) {
            System.out.println(type + " " + name + " приземляется.");
            setMoving(false);
        } else {
            System.out.println(type + " " + name + " уже на земле.");
        }
    }

    @Override
    public void refuel() {
        if (!isMoving) {
            System.out.println(type + " " + name + " заправляется.");
        } else {
            System.out.println(type + " " + name + " ага, сейчас вызовем самолет-заправщик. Сначала сесть надо!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println((isMoving ? "Летит: " : "Приземлился: ") + type + ": " + name +
                ", раотет " + gearType + " двигателя" +
                ", в салоне " + capacityPpl + " чел." +
                ", в багажном отсеке " + capacityCargo + " кг. груза" +
                ", на максималке: " + maxSpeed + " км/ч" +
                ", летим на топливе: " + fuelType);
    }
}

final class Ship extends Transport {
    final private String tubeType;

    public Ship(String name, int capacityPpl, int capacityCargo, double maxSpeed, FuelType fuelType, String tubeType) {
        super(name, capacityPpl, capacityCargo, maxSpeed, fuelType, TransportType.SHIP);
        this.tubeType = tubeType;
    }

    @Override
    public void start() {
        if (!isMoving) {
            System.out.println(type + " " + name + " пошел по волнам.");
            setMoving(true);
        } else {
            System.out.println(type + " " + name + " уже в море.");
        }
    }

    @Override
    public void stop() {
        if (isMoving) {
            System.out.println(type + " " + name + " пришвартовался.");
            setMoving(false);
        } else {
            System.out.println(type + " " + name + " уже в порту.");
        }
    }

    @Override
    public void refuel() {
        if (!isMoving) {
            System.out.println(type + " " + name + " заправляется.");
        } else {
            System.out.println(type + " " + name + " давай купим топлива у этих пиратов? Может все-таки до порта потерпим?.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println((isMoving ? "Идет по водной глади: " : "Пришвартовался: ") + type + ": " + name +
                ", дымят " + tubeType + " труб" +
                ", в нумерах " + capacityPpl + " чел." +
                ", в трюме " + capacityCargo + " кг. груза" +
                ", на максималке: " + maxSpeed + " км/ч (это сколько узлов?)" +
                ", лучше заправлять этим: " + fuelType);
    }
}

final class Bicycle extends Transport {

    public Bicycle(String name, int capacityPpl, int capacityCargo, double maxSpeed, FuelType fuelType) {
        super(name, capacityPpl, capacityCargo, maxSpeed, fuelType, TransportType.BICYCLE);
    }

    @Override
    public void start() {
        if (!isMoving) {
            System.out.println(type + " " + name + " запущен.");
            setMoving(true);
        } else {
            System.out.println(type + " " + name + " уже в движении.");
        }
    }

    @Override
    public void stop() {
        if (isMoving) {
            System.out.println(type + " " + name + " остановлен.");
            setMoving(false);
        } else {
            System.out.println(type + " " + name + " уже остановлен.");
        }
    }

    @Override
    public void refuel() {
        System.out.println(type + " " + name + " не требует заправки.");
    }

    @Override
    public void displayInfo() {
        System.out.println((isMoving ? "Идет по водной глади: " : "Пришвартовался: ") + type + ": " + name +
                ", на раме " + capacityPpl + " чел." +
                ", в рюкзаке " + capacityCargo + " кг. груза" +
                ", на максималке: " + maxSpeed + " км/ч");
    }
}

final class Donkey extends Transport {
    final private String earsType;

    public Donkey(String name, int capacityPpl, int capacityCargo, double maxSpeed, FuelType fuelType, String earsType) {
        super(name, capacityPpl, capacityCargo, maxSpeed, fuelType, TransportType.DONKEY);
        this.earsType = earsType;
    }

    @Override
    public void start() {
        if (!isMoving) {
            System.out.println(type + " " + name + " идет.");
            setMoving(true);
        } else {
            System.out.println(type + " " + name + " уже в движении.");
        }
    }

    @Override
    public void stop() {
        if (isMoving) {
            System.out.println(type + " " + name + " остановлен.");
            setMoving(false);
        } else {
            System.out.println(type + " " + name + " уже остановлен.");
        }
    }

    @Override
    public void refuel() {
        System.out.println(type + " " + name + " не требует еды.");
    }

    @Override
    public void displayInfo() {
        System.out.println((isMoving ? "Идет: " : "Остановился: ") + type + ": " + name +
                ", шевелит " + earsType + " ушами" +
                ", на горбу " + capacityCargo + " кг. груза" +
                ", на максималке: " + maxSpeed + " км/ч" +
                ", ест в основном: " + fuelType);
    }
}


public class TransportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Transport[] transports = new Transport[10]; // Максимум 10 транспортных средств
        int transportCount = 0;

        while (true) {
            System.out.println("Выберите тип транспорта для создания (модно макимум 10 создать):");
            System.out.println("1. Автомобиль");
            System.out.println("2. Самолет");
            System.out.println("3. Корабль");
            System.out.println("4. Велосипед");
            System.out.println("5. Осел");
            System.out.println("0. Выход");

            int choice = getIntInput(scanner);

            if (choice == 0) {
                break;
            }

            if (transportCount >= transports.length) {
                System.out.println("Достигнуто максимальное количество транспортных средств.");
                continue;
            }

            System.out.print("Введите название: ");
            String name = scanner.nextLine();
            System.out.print("Сколько человек везет (чел.): ");
            int capacityPpl = getIntInput(scanner);
            System.out.print("Сколько груза везет (кг): ");
            int capacityCargo = getIntInput(scanner);
            System.out.print("Введите максимальную скорость (км/ч): ");
            double maxSpeed = getDoubleInput(scanner);
            // Prompt for fuel type
            System.out.println("Чем заправлять будем:");
            for (FuelType fuel : FuelType.values()) {
                System.out.println(fuel.ordinal() + 1 + ". " + fuel);
            }
            int fuelChoice = getIntInput(scanner);
            FuelType fuelType = FuelType.values()[fuelChoice - 1]; // Get the selected fuel type

            switch (choice) {
                case 1:
                    System.out.print("Введите цвет машины: ");
                    String colorType = scanner.nextLine();
                    transports[transportCount++] = new Car(name, capacityPpl, capacityCargo, maxSpeed, fuelType, colorType);
                    break;

                case 2:
                    System.out.print("Введите количество двигателей: ");
                    String gearType = scanner.nextLine();
                    transports[transportCount++] = new Airplane(name, capacityPpl, capacityCargo, maxSpeed, fuelType, gearType);
                    break;

                case 3:
                    System.out.print("Введите количество труб: ");
                    String tubeType = scanner.nextLine();
                    transports[transportCount++] = new Ship(name, capacityPpl, capacityCargo, maxSpeed, fuelType, tubeType);
                    break;

                case 4:
                    transports[transportCount++] = new Bicycle(name, capacityPpl, capacityCargo, maxSpeed, null);
                    break;

                case 5:
                    System.out.print("Введите настроение осла: ");
                    String auraType = scanner.nextLine();
                    transports[transportCount++] = new Donkey(name, 0,capacityCargo, maxSpeed, fuelType, auraType);
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }

            // Вывод информации о всех транспортных средствах
            displayTransportList(transports, transportCount);
        }

        // Управление транспортными средствами
        while (true) {
            System.out.println("\nВыберите транспорт для управления (или введите 0 для выхода):");
            displayTransportList(transports, transportCount);
            int transportChoice = getIntInput(scanner);

            if (transportChoice == 0) {
                break;
            }

            if (transportChoice < 1 || transportChoice > transportCount) {
                System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                continue;
            }

            Transport selectedTransport = transports[transportChoice - 1];

            System.out.println("Выберите действие:");
            System.out.println("1. Запустить");
            System.out.println("2. Остановить");
            System.out.println("3. Заправить");

            int actionChoice = getIntInput(scanner);

            switch (actionChoice) {
                case 1:
                    selectedTransport.start();
                    break;
                case 2:
                    selectedTransport.stop();
                    break;
                case 3:
                    selectedTransport.refuel();
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }

            // Вывод информации о всех транспортных средствах после действия
            displayTransportList(transports, transportCount);
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }

    private static void displayTransportList(Transport[] transports, int transportCount) {
        System.out.println("\nСписок транспортных средств:");
        for (int i = 0; i < transportCount; i++) {
            System.out.print((i + 1) + ". ");
            transports[i].displayInfo();
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
            }
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите число с плавающей запятой.");
            }
        }
    }
}
