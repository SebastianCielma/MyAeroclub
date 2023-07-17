package pl.sebastiancielma.MyAeroclub.cart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sebastiancielma.MyAeroclub.cart.controller.dto.AirplaneDto;
import pl.sebastiancielma.MyAeroclub.cart.model.Cart;
import pl.sebastiancielma.MyAeroclub.cart.model.CartItem;
import pl.sebastiancielma.MyAeroclub.cart.model.dto.CartAirplaneDto;
import pl.sebastiancielma.MyAeroclub.cart.repository.CartRepository;
import pl.sebastiancielma.MyAeroclub.common.model.Airplane;
import pl.sebastiancielma.MyAeroclub.common.repository.AirplaneForSaleRepository;

import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.spi.ToolProvider.findFirst;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final AirplaneForSaleRepository airplaneForSaleRepository;

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Cart addAirplaneToCart(Long id, CartAirplaneDto cartAirplaneDto) {
        Cart cart = getInitializedCart(id);
        cart.addProduct(CartItem.builder()
                        .quantity(cartAirplaneDto.quantity())
                        .airplane(getAirplane(cartAirplaneDto.airplaneId()))
                        .cartId(cart.getId())
                .build());
        return cart;
    }

    private Airplane getAirplane(Long airplaneId) {
        return airplaneForSaleRepository.findById(airplaneId).orElseThrow();
    }

    private Cart getInitializedCart(Long id) {
        if(id == null || id <= 0) {
            return cartRepository.save(Cart.builder().created(now()).build());
        }
        return cartRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Cart updateCart(Long id, List<CartAirplaneDto> cartAirplaneDtos) {
        Cart cart = cartRepository.findById(id).orElseThrow();
        cart.getItems().forEach(cartItem -> {
            cartAirplaneDtos.stream()
                    .filter(cartAirplaneDto -> cartItem.getAirplane().getId().equals(cartAirplaneDto.airplaneId()))
                    .findFirst()
                    .ifPresent(cartAirplaneDto -> cartItem.setQuantity(cartAirplaneDto.quantity()));
        });
        return cart;
    }
}
