package ru.job4j.stream;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public static Product applyDiscount(Product product) {
        Label label = new Label();
        product.setName(product.getName() + label.getName());
        product.setPrice(product.getPrice() * label.getPrice());
        return product;
    }

    public List<String> generateLabels(List<Product> products) {
        int currentDate = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        return products.stream()
                .filter(pr -> pr.getExpired().get(Calendar.DAY_OF_YEAR) >= currentDate)
                .filter(pr -> pr.getExpired().get(Calendar.DAY_OF_YEAR) <= currentDate + 2)
                .map(ProductLabel::applyDiscount)
                .map(Product::toString)
                .collect(Collectors.toList());
    }
}
