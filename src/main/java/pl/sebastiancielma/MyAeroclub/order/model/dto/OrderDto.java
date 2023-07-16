package pl.sebastiancielma.MyAeroclub.order.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Builder
public class OrderDto {
        @NotBlank
        private String firstname;
        @NotBlank
        private String lastname;
        @NotBlank
        private String street;
        @NotBlank
        private String zipcode;
        @NotBlank
        private String city;
        @NotBlank
        @Email
        private String email;
        @NotBlank
        private String phone;
        @NotNull
        private Long cartId;
        @NotNull
        private Long shipmentId;
        @NotNull
        private Long paymentId;


}