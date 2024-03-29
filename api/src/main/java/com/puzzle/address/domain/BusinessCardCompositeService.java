package com.puzzle.address.domain;

import com.puzzle.address.controller.dto.BusinessCardDto;
import com.puzzle.api.util.BooleanDelete;
import com.puzzle.api.util.BooleanValidate;
import com.puzzle.api.util.Patch;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessCardCompositeService {
    private final BusinessCardService service;

    @Transactional
    public BusinessCard create(final Address address) {
        final var businessCard = new BusinessCard();

        businessCard.setAddressUuid(address.getUuid());
        businessCard.setName(address.getName());
        businessCard.setEmail(address.getEmail());
        businessCard.setRank(address.getRank());
        businessCard.setDepartment(address.getDepartment());
        businessCard.setPhoneNumber(address.getPhoneNumber());
        businessCard.setCompanyName(address.getCompanyName());

        return service.create(businessCard);
    }

    @Transactional
    public BusinessCardDto.Get.Response get(final String uuid) {
        final var businessCard = service.find(uuid, BooleanDelete.FALSE, BooleanValidate.TRUE);

        return new BusinessCardDto.Get.Response(businessCard);
    }

    @Transactional
    public void deleteByAddress(final String addressUuid) {
        final var businessCard = service.findByAddressUuid(addressUuid, BooleanDelete.FALSE, BooleanValidate.FALSE);

        if (businessCard != null) {
            service.delete(businessCard);
        }
    }

    @Transactional
    public BusinessCard findByAddressUuid(final String uuid) {
        return service.findByAddressUuid(uuid, BooleanDelete.FALSE, BooleanValidate.TRUE);
    }

    @Transactional
    public void update(final String uuid, final BusinessCardDto.Update.Request request) {
        final var businessCard = service.find(uuid, BooleanDelete.FALSE, BooleanValidate.TRUE);

        final var patchBusinessCard = Patch.entityByRequest(businessCard, BusinessCard.class, request);

        service.update(patchBusinessCard);
    }
}
