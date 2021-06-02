package com.example.rest.service;

import com.example.rest.dto.ProductDto;
import com.example.rest.model.Product;
import com.example.rest.repository.CategoryRepo;
import com.example.rest.repository.ProductRepo;
import com.example.rest.service.spec.ProductSpec;
import com.example.rest.utils.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepo repo;
    private final CategoryRepo categoryRepo;

    public Product save(ProductDto dto){
        Product product = MappingUtil.dtoToProduct(dto,categoryRepo.getByName(dto.getCategory()));
    return repo.save(product);
    }

    public List<ProductDto> findAll(Map<String, String> params) {
        final Specification<Product> specification = params.entrySet().stream()
                .filter(it->StringUtils.hasText(it.getValue()))
                .map(it -> {
                    if ("title".equals(it.getKey())) {
                        return ProductSpec.titleLike(it.getValue());
                    }
                    if ("price".equals(it.getKey())) {
                        return ProductSpec.priceLess(Integer.parseInt(it.getValue()));
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElse(null);
            return repo.findAll(specification).stream()
                    .map(MappingUtil::productDto)
                    .collect(Collectors.toList());
    }

    public  void deleteById(Long id){
        repo.deleteById(id);
    }
}
