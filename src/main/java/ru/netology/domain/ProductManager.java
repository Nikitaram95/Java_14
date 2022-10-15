package ru.netology.domain;

import lombok.Data;
import ru.netology.repository.ProductRepository;

@Data
public class ProductManager {
    private ProductRepository repository;
    private int id;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] getAll() {
        Product[] items = repository.findAll();
        Product[] result = new Product[items.length];
        for (int i = 0; i < items.length; i++) {
            int index = result.length - 1 - i;
            result[i] = items[index];
        }
        return result;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public void removeById(int id) {
        if (repository.findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        repository.removeById(id);
    }
}
