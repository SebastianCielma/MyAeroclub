package pl.sebastiancielma.MyAeroclub.cart.controller.mapper;
import pl.sebastiancielma.MyAeroclub.cart.controller.dto.AirplaneDto;
import pl.sebastiancielma.MyAeroclub.cart.controller.dto.CartSummaryDto;
import pl.sebastiancielma.MyAeroclub.cart.controller.dto.CartSummaryItemDto;
import pl.sebastiancielma.MyAeroclub.cart.controller.dto.SummaryDto;
import pl.sebastiancielma.MyAeroclub.cart.model.Cart;
import pl.sebastiancielma.MyAeroclub.cart.model.CartItem;
import pl.sebastiancielma.MyAeroclub.common.model.Airplane;

import java.math.BigDecimal;
import java.util.List;

public class CartMapper {
    public static CartSummaryDto mapToCartSummary(Cart cart) {
        return CartSummaryDto.builder()
                .id(cart.getId())
                .summary(mapToSummary(cart.getItems()))
                .items(mapCartItems(cart.getItems()))
                .build();
        
    }

    private static List<CartSummaryItemDto> mapCartItems(List<CartItem> items) {
        return items.stream()
                .map(CartMapper::mapToCartItem)
                .toList();
    }

    private static CartSummaryItemDto mapToCartItem(CartItem cartItem) {
        return CartSummaryItemDto.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .airplane(mapToAirplaneDto(cartItem.getAirplane()))
                .lineValue(calculateLineValue(cartItem))
                .build();
    }

    private static AirplaneDto mapToAirplaneDto(Airplane airplane) {
        return AirplaneDto.builder()
                .id(airplane.getId())
                .name(airplane.getName())
                .currency(airplane.getCurrency())
                .image(airplane.getImage())
                .price(airplane.getPrice())
                .slug(airplane.getSlug())
                .build();
    }

    private static BigDecimal calculateLineValue(CartItem cartItem) {
        return cartItem.getAirplane().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
    }

    private static SummaryDto mapToSummary(List<CartItem> items) {
        return SummaryDto.builder()
                .grossValue(sumValues(items))
                .build();
    }

    private static BigDecimal sumValues(List<CartItem> items) {
        return items.stream()
                .map(CartMapper::calculateLineValue)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
