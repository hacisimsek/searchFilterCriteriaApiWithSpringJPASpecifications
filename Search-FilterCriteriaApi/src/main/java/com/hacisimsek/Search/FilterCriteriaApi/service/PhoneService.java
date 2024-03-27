package com.hacisimsek.Search.FilterCriteriaApi.service;

import com.hacisimsek.Search.FilterCriteriaApi.specification.PhoneSpecification;
import com.hacisimsek.Search.FilterCriteriaApi.model.Phone;
import com.hacisimsek.Search.FilterCriteriaApi.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public List<Phone> findAllPhones(String phoneBrand, String phoneName) {
        return phoneRepository.findAll(PhoneSpecification.filterPhone(phoneBrand, phoneName));
    }

    public List<Phone> searchPhones(String search) {
        return phoneRepository.findAll(PhoneSpecification.searchPhone(search));
    }

    public Phone addPhone(Phone phone) {
        return phoneRepository.save(phone);
    }
 }
