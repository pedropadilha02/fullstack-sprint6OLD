package br.com.rchlo.dto;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PaymentStatistics {

    private HashMap<PaymentStatus, Long> mapPaymentStatistics = new HashMap<>();

    private BigDecimal maximumAmountOfConfirmedPayment;

    public PaymentStatistics(BigDecimal maximumAmountOfConfirmedPayment) {
        this.maximumAmountOfConfirmedPayment = maximumAmountOfConfirmedPayment;
    }

    public BigDecimal getMaximumAmountOfConfirmedPayment() {
        return maximumAmountOfConfirmedPayment;
    }

    public Map<PaymentStatus, Long> getQuantityOfPaymentsByStatus() {
        return mapPaymentStatistics;
    }

    public void addPaymentForStatus(PaymentStatus status) {
        Long quantity = this.mapPaymentStatistics.get(status);
        if (quantity == null) {
            quantity = 1L;
        } else {
            quantity++;
        }
        this.mapPaymentStatistics.put(status, quantity);
    }


}
