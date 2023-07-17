package pl.sebastiancielma.MyAeroclub.cart.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sebastiancielma.MyAeroclub.cart.model.Cart;
import pl.sebastiancielma.MyAeroclub.cart.repository.CartItemRepository;
import pl.sebastiancielma.MyAeroclub.cart.repository.CartRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartCleanupService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Transactional
    @Scheduled(cron = "${app.cart.cleanup.expression}")
    public void cleanupOldCarts(){
        List<Cart> carts = cartRepository.findByCreatedLessThan(LocalDateTime.now().minusDays(3));
        List<Long> ids = carts.stream()
                .map(Cart::getId)
                .toList();
        log.info("Stare koszyki " + carts.size());
        if(!ids.isEmpty()){
            cartItemRepository.deleteAllByCartIdIn(ids);
            cartRepository.deleteAllByIdIn(ids);
        }

    }
}
