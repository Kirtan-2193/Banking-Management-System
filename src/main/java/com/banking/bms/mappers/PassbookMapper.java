package com.banking.bms.mappers;

import com.banking.bms.model.PassbookModel;
import com.banking.bms.model.entities.Passbook;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface PassbookMapper {

    List<PassbookModel> passbookListToPassbookModelList(List<Passbook> passbooks);
}
