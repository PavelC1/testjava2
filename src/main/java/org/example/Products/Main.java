package org.example.Products;

import java.time.LocalDate;
import java.util.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Mezeluri", 5, 25.5, true, LocalDate.of(2024, 6, 3)));
        products.add(new Product("Paste", 10, 15.0, false, LocalDate.of(2003, 4, 30)));
        products.add(new Product("Peste", 13, 28.66, true, LocalDate.of(2023, 11, 15)));
        products.add(new Product("Banane", 3, 12.0, false, LocalDate.of(2023, 12, 1)));
        products.add(new Product("Morcovi", 45, 350.0, true, LocalDate.of(2023, 7, 14)));
        products.add(new Product("Cimpanzei", 1, 100.0, true, LocalDate.of(2100, 8, 14)));
        products.add(new Product("Mere", 15, 2.4, true, LocalDate.of(2023, 11, 25)));
        ProductService service = new ProductService(products);

        while (true) {
            System.out.println("Meniu ");
            System.out.println("1. Filtrarea produselor în funcție de pret");
            System.out.println("2. Sortarea produselor dupa nume.");
            System.out.println("3. Gruparea produselor într-o mapa dupa cantitate");
            System.out.println("4. Calcularea valorii totale a stocului pentru toate produsele din listă.");
            System.out.println("5. Găsirea celui mai scump produs din listă.");
            System.out.println("6. Afișarea produselor care au data de expirare în viitor.");

            Scanner scanner = new Scanner(System.in);
            int indexMenu = scanner.nextInt();

            switch(indexMenu) {
                case 1: {
                    System.out.println("Filtrarea produselor în funcție de pret -- Introdu pret(min si max): ");
                    double minPrice, maxPrice;
                    minPrice = scanner.nextDouble();
                    maxPrice = scanner.nextDouble();

                    products = service.filterProdsByPrice(minPrice, maxPrice);
                    for (Product product : products) {
                        System.out.println(product.getName() + " " + product.getQuantity() + " " + product.getPrice() + "lei " + product.getAvailable() + " "
                                + product.getExpirationDate());
                    }
                    break;
                }

                case 2: {
                    System.out.println("Sortarea produselor dupa nume: ");

                    products = service.sortProdsByName();

                    for (Product product : products) {
                        System.out.println( product.getName() + " " + product.getQuantity() + " " + product.getPrice() + "lei " + product.getAvailable() + " "
                                + product.getExpirationDate());
                    }

                    break;
                }

                case 3: {
                    System.out.println("Gruparea produselor într-o mapa dupa cantitate: ");

                    Map<String, Integer> productsMap = new HashMap<>();
                    productsMap = service.groupProdsByQuantity();

                    for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
                        String productName = entry.getKey();
                        Integer quantity = entry.getValue();
                        System.out.println(productName + " " + quantity);
                    }
                    break;
                }

                case 4: {
                    System.out.println("Calcularea valorii totale a stocului pentru toate produsele din listă: ");
                    System.out.println(service.totalStockValue() + " lei");
                    break;
                }

                case 5: {
                    System.out.println("Găsirea celui mai scump produs din listă.: ");
                    Product mostExpensive = service.mostExpensiveProd();
                    System.out.println(mostExpensive.getName() + " " + mostExpensive.getPrice() + "lei");
                    break;
                }

                case 6: {
                    System.out.println("Afișarea produselor care au data de expirare în viitor.: ");
                    products = service.getProdsWithFutExpDate();

                    for (Product product : products) {

                        System.out.println(product.getName() + " " + product.getQuantity()
                                + " " + product.getPrice() + "lei " + product.getAvailable() + " "
                                + product.getExpirationDate());
                    }
                    break;
                }
            }
        }
    }
}