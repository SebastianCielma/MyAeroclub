package pl.sebastiancielma.MyAeroclub.cart.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sebastiancielma.MyAeroclub.cart.model.Cart;
import pl.sebastiancielma.MyAeroclub.cart.model.dto.CartAirplaneDto;
import pl.sebastiancielma.MyAeroclub.cart.repository.CartRepository;
import pl.sebastiancielma.MyAeroclub.common.model.Airplane;
import pl.sebastiancielma.MyAeroclub.common.repository.AirplaneForSaleRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

    @ExtendWith(MockitoExtension.class)
    class CartServiceTest {

        @Mock
        private CartRepository cartRepository;
        @Mock
        private AirplaneForSaleRepository airplaneForSaleRepository;
        @InjectMocks
        private CartService cartService;

        @Test
        void shouldAddProductToCartWhenCartIdNotExists(){
            Long cartId = 0L;
            CartAirplaneDto cartAirplaneDto = new CartAirplaneDto(1L, 1);
            when(airplaneForSaleRepository.findById(1L)).thenReturn(Optional.of(Airplane.builder().id(1L).build()));
            when(cartRepository.save(any())).thenReturn(Cart.builder().id(1L).build());

            Cart result = cartService.addAirplaneToCart(cartId, cartAirplaneDto);

            assertThat(result).isNotNull();
            assertThat(result.getId()).isEqualTo(1L);
        }

        @Test
        void shouldAddProductToCartWhenCartIdExists(){

            Long cartId = 1L;
            CartAirplaneDto cartAirplaneDto = new CartAirplaneDto(1L, 1);
            when(airplaneForSaleRepository.findById(1L)).thenReturn(Optional.of(Airplane.builder().id(1L).build()));
            when(cartRepository.findById(cartId)).thenReturn(Optional.of(Cart.builder().id(1L).build()));

            Cart result = cartService.addAirplaneToCart(cartId, cartAirplaneDto);

            assertThat(result).isNotNull();
            assertThat(result.getId()).isEqualTo(1L);
        }
    }

