package com.lapin.shopper.controller;

import com.lapin.shopper.dto.ErrorResponse;
import com.lapin.shopper.dto.product.ProductRequestDto;
import com.lapin.shopper.dto.product.ProductResponseDto;
import com.lapin.shopper.service.ProductService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.lapin.shopper.constants.Constants.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = API_401_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 403, message = API_403_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 404, message = API_404_CODE, response = ErrorResponse.class)
    })
    public ProductResponseDto getProductById
            (@PathVariable String id) {
        return productService.getProductDetails(UUID.fromString(id));
    }

    @PostMapping(value = "/")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = API_400_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 401, message = API_401_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 403, message = API_403_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 404, message = API_404_CODE, response = ErrorResponse.class)
    })
    public ProductResponseDto create
            (@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @PutMapping(value = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = API_400_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 401, message = API_401_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 403, message = API_403_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 404, message = API_404_CODE, response = ErrorResponse.class)
    })
    public ProductResponseDto update
            (@PathVariable String id,
             @RequestBody ProductRequestDto productRequestDto) {
        return productService.updateProduct(UUID.fromString(id), productRequestDto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = API_400_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 401, message = API_401_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 403, message = API_403_CODE, response = ErrorResponse.class),
            @ApiResponse(code = 404, message = API_404_CODE, response = ErrorResponse.class)
    })
    public ProductResponseDto deleteProduct
            (@PathVariable String id) {
        return productService.deleteProduct(UUID.fromString(id));
    }
}