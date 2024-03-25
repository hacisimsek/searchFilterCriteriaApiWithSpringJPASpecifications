package com.hacisimsek.Search.FilterCriteriaApi.repository;

import com.hacisimsek.Search.FilterCriteriaApi.model.Phone;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    List<Phone> findAll(Specification<Phone> specification);
}
