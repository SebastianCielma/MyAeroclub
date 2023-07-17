package pl.sebastiancielma.MyAeroclub.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sebastiancielma.MyAeroclub.order.model.Payment;
import pl.sebastiancielma.MyAeroclub.order.repository.PaymentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }
}
