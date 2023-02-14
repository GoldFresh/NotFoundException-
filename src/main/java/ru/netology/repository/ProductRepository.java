package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeByID(int ID) {
        if (findById(ID) == null){
            throw new NotFoundException("Element with id: " + ID + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products)
            if (product.getID() != ID) {
                tmp[index] = product;
                index++;
            }
        products = tmp;
    }

    public Product findById (int ID) {
        for (Product product : products) {
            if (product.getID () == ID) {
                return product;
            }
        }
        return null;
    }
}