package pl.sebastiancielma.MyAeroclub.cart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sebastiancielma.MyAeroclub.cart.controller.dto.AirplaneDto;
import pl.sebastiancielma.MyAeroclub.cart.controller.dto.CartSummaryDto;
import pl.sebastiancielma.MyAeroclub.cart.controller.mapper.CartMapper;
import pl.sebastiancielma.MyAeroclub.cart.model.Cart;
import pl.sebastiancielma.MyAeroclub.cart.model.dto.CartAirplaneDto;
import pl.sebastiancielma.MyAeroclub.cart.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private CartAirplaneDto cartAirplaneDto;

    @GetMapping("/{id}")
    public CartSummaryDto getCart(@PathVariable Long id){
        return CartMapper.mapToCartSummary(cartService.getCart(id));
    }

    @PutMapping("/{id}")
    public CartSummaryDto addAirplaneToCart(@PathVariable Long id, @RequestBody CartAirplaneDto cartAirplaneDto){
        return CartMapper.mapToCartSummary(cartService.addAirplaneToCart(id,cartAirplaneDto));
    }

    @PutMapping("/{id}/update")
    public CartSummaryDto updateCart(@PathVariable Long id, @RequestBody List<CartAirplaneDto> airplaneDtos){
        return CartMapper.mapToCartSummary(cartService.updateCart(id, airplaneDtos));
    }
}
