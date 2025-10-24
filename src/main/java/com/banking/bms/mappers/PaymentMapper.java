package com.banking.bms.mappers;

import com.banking.bms.model.PaymentResponseModel;
import com.banking.bms.model.entities.Payment;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;


@Mapper(
        componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface PaymentMapper {

    PaymentResponseModel paymentToPaymentResponseModel(Payment payment);
}
