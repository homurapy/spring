package com.vasilev.boot.util;

import com.vasilev.boot.dto.ProductDto;
import com.vasilev.boot.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author antonkuznetsov
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MappingUtil {

    public static ProductDto productDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }

    public static Product dtoToPerson(ProductDto dto) {
        return new Product(dto.getId(), dto.getTitle(), dto.getCost(), 1, false);
    }
}
