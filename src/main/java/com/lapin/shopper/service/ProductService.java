package com.lapin.shopper.service;

import com.lapin.shopper.dto.product.ProductRequestDto;
import com.lapin.shopper.dto.product.ProductResponseDto;
import com.lapin.shopper.enums.ExceptionMessages;
import com.lapin.shopper.exceptions.Code404Exception;
import com.lapin.shopper.model.Product;
import com.lapin.shopper.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductResponseDto getProductDetails(UUID id) {
        Product product = findById(id)
                .orElseThrow(() -> new Code404Exception(ExceptionMessages.NOT_FOUND.getMessage() + id));
        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto.getName(), productRequestDto.getPrice());
        productRepository.save(product);
        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(UUID id, ProductRequestDto productRequestDto) {
        Product product = findById(id)
                .orElseThrow(() -> new Code404Exception(ExceptionMessages.NOT_FOUND.getMessage() + "product" + id));
        product.setName(productRequestDto.getName());
        product.setPrice(productRequestDto.getPrice());
        productRepository.save(product);
        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto deleteProduct(UUID id) {
        Product product = findById(id)
                .orElseThrow(() -> new Code404Exception(ExceptionMessages.NOT_FOUND.getMessage() + "product" + id));
        productRepository.deleteById(id);
        return new ProductResponseDto(product);
    }

    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }
}