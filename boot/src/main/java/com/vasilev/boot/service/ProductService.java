package com.vasilev.boot.service;

import com.vasilev.boot.dto.ProductDto;
import com.vasilev.boot.repository.ProductRepository;
import com.vasilev.boot.util.MappingUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author antonkuznetsov
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long save(ProductDto productDto) {
        if (productDto.getId() == null) {
            return productRepository.create(MappingUtil.dtoToPerson(productDto)).getId();
        } else {
            return productRepository.update(MappingUtil.dtoToPerson(productDto)).getId();
        }
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(MappingUtil::productDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
