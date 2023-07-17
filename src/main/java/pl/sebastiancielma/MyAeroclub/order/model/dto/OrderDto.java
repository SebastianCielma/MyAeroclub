package pl.sebastiancielma.MyAeroclub.order.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;


@Builder
@Getter
public class OrderDto {
    private String firstname;
    private String lastname;
    private String street;
    private String zipcode;
    private String city;
    @Email
    private String email;
    private String phone;
    private Long cartId;
    private Long shipmentId;
    private Long paymentId;

}

