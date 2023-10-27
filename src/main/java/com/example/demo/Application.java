package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Application {
    @Autowired
    private ClothesService clothesService;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Добавить новый предмет одежды");
            System.out.println("2 - Вывести информаию о предметах одежды");
            System.out.println("3 - Изменить информаию о предмете одежды");
            System.out.println("4 - Найти предмет одежды");
            System.out.println("5 - Удалить предмет одежды");
            System.out.println("6 - Выйти из программы");
            // другие опции...
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addClothes(scanner);
                case "2" -> showAllClothes();
                case "3" -> editClothes(scanner);
                case "4" -> searchClothes(scanner);
                case "5" -> deleteClothes(scanner);
                case "6" -> {
                    System.out.println("Выход из программы");
                    return;
                }
                default -> System.out.println("Некорректная комманда!");
            }
        }
    }

    private Clothes getClothes(Scanner scanner){
        System.out.println("Введите название товара:");
        String name = scanner.nextLine();
        System.out.println("Введите цвет товара:");
        String color = scanner.nextLine();
        System.out.println("Введите название бренда:");
        String brand = scanner.nextLine();
        System.out.println("Введите размер одежды:");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите цену:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите количество товара:");
        int quantity = Integer.parseInt(scanner.nextLine());
        return new Clothes(name, color, brand, size, price, quantity);
    }

    private void addClothes(Scanner scanner) {
        Clothes clothes = getClothes(scanner);
        clothesService.addClothes(clothes);
        System.out.println("Предмет одежды был успешно добавлен!");
    }

    private void showAllClothes() {
        List<Clothes> furnitureList = clothesService.getAllClothes();
        if (furnitureList.isEmpty()) {
            System.out.println("Мебель не найдена.");
        } else {
            for (Clothes furniture : furnitureList) {
                System.out.println(furniture);
            }
        }
    }

    private void editClothes(Scanner scanner) {
        showAllClothes();
        System.out.println("Введите ID объекта для редактирования:");
        int id = Integer.parseInt(scanner.nextLine());
        Clothes updatedClothes = getClothes(scanner);
        clothesService.updateClothes(id, updatedClothes);
        System.out.println("Предмет одежды успешно обновлен!");
    }

    private void deleteClothes(Scanner scanner) {
        System.out.println("Введите ID предмета одежды для удаления:");
        int id = Integer.parseInt(scanner.nextLine());
        clothesService.deleteClothes(id);
        System.out.println("Предмет одежды успешно удален!");
    }

    private void searchClothes(Scanner scanner) {
        System.out.println("Выберите критерий поиска: ");
        System.out.println("1 - Название");
        System.out.println("2 - Цвет одежды");
        System.out.println("3 - Бренд одежды");
        String field;
        switch (scanner.nextLine()) {
            case "1" -> field = "item_name";
            case "2" -> field = "color";
            case "3" -> field = "brand";
            default -> {
                System.out.println("Неверная комманда, попробуйте снова");
                return;
            }
        }
        System.out.println("Введите значение для поиска:");
        String value = scanner.nextLine();
        List<Clothes> clothesList = clothesService.searchClothes(field, value);
        if (clothesList.isEmpty()) {
            System.out.println("Одежда не найдена");
        } else {
            for (Clothes clothes : clothesList) {
                System.out.println(clothes);
            }
        }
    }
}
