package com.lapin.shopper.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "ProductRequestDto")
public class ProductRequestDto implements Serializable {

    @ApiModelProperty(required = true)
    @NotEmpty(message = "Field is required")
    private String name;

    @ApiModelProperty(required = true)
    @NotNull(message = "Field is required")
    private BigDecimal price;
}
