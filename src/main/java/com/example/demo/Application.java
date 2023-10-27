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
            System.out.println("1. Добавить мебель");
            System.out.println("2. Вывести всю мебель");
            System.out.println("3. Изменить мебель");
            System.out.println("4. Поиск мебели");
            System.out.println("5. Удалить мебель");
            System.out.println("6. Выход");
            // другие опции...
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addFurniture(scanner);
                case "2" -> showAllFurniture();
                case "3" -> editFurniture(scanner);
                case "4" -> searchFurniture(scanner);
                case "5" -> deleteFurniture(scanner);
                case "6" -> {
                    System.out.println("Выход из программы. До свидания!");
                    return;
                }
                default -> System.out.println("Некорректный выбор!");
            }
        }
    }

    private void addFurniture(Scanner scanner) {
        System.out.println("Введите название:");
        String name = scanner.nextLine();
        System.out.println("Введите материал:");
        String material = scanner.nextLine();
        System.out.println("Введите стиль:");
        String style = scanner.nextLine();
        System.out.println("Введите цену:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите количество:");
        int quantity = Integer.parseInt(scanner.nextLine());

        Clothes furniture = new Clothes();
        furniture.setName(name);
        furniture.setMaterial(material);
        furniture.setStyle(style);
        furniture.setPrice(price);
        furniture.setQuantity(quantity);

        clothesService.addFurniture(furniture);
        System.out.println("Мебель была успешно добавлена!");
    }

    private void showAllFurniture() {
        List<Clothes> furnitureList = clothesService.getAllClothes();
        if (furnitureList.isEmpty()) {
            System.out.println("Мебель не найдена.");
        } else {
            for (Clothes furniture : furnitureList) {
                System.out.println(furniture);
            }
        }
    }

    private void editFurniture(Scanner scanner) {
        showAllFurniture();
        System.out.println("Введите ID мебели для редактирования:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите новое название:");
        String name = scanner.nextLine();
        System.out.println("Введите новый материал:");
        String material = scanner.nextLine();
        System.out.println("Введите новый стиль:");
        String style = scanner.nextLine();
        System.out.println("Введите новую цену:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите новое количество:");
        int quantity = Integer.parseInt(scanner.nextLine());

        Clothes updatedFurniture = new Clothes();
        updatedFurniture.setName(name);
        updatedFurniture.setMaterial(material);
        updatedFurniture.setStyle(style);
        updatedFurniture.setPrice(price);
        updatedFurniture.setQuantity(quantity);

        clothesService.updateClothes(id, updatedFurniture);
        System.out.println("Мебель успешно обновлена!");
    }

    private void deleteFurniture(Scanner scanner) {
        System.out.println("Введите ID мебели для удаления:");
        int id = Integer.parseInt(scanner.nextLine());
        clothesService.deleteClothes(id);
        System.out.println("Мебель успешно удалена!");
    }

    private void searchFurniture(Scanner scanner) {
        System.out.println("Выберите критерий поиска: ");
        System.out.println("1. Название");
        System.out.println("2. Материал");
        System.out.println("3. Стиль");
        System.out.println("4. Цена");
        System.out.println("5. Количество");
        String field;
        switch (scanner.nextLine()) {
            case "1" -> field = "name";
            case "2" -> field = "material";
            case "3" -> field = "style";
            case "4" -> field = "price";
            case "5" -> field = "quantity";
            default -> {
                System.out.println("Неверный выбор, попробуйте снова.");
                return;
            }
        }
        System.out.println("Введите значение для поиска:");
        String value = scanner.nextLine();

        List<Clothes> furnitureList = clothesService.searchClothes(field, value);
        if (furnitureList.isEmpty()) {
            System.out.println("Мебель не найдена.");
        } else {
            for (Clothes furniture : furnitureList) {
                System.out.println(furniture);
            }
        }
    }
}
