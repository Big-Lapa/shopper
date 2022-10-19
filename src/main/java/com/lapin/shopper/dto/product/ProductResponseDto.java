package com.lapin.shopper.dto.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lapin.shopper.model.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "ProductResponseDto")
public class ProductResponseDto {

    @ApiModelProperty("Product Id")
    private UUID id;

    @ApiModelProperty("Product added time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime added;

    @ApiModelProperty("Product name")
    private String name;

    @ApiModelProperty("Product price")
    private BigDecimal price;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.added = product.getAdded();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}