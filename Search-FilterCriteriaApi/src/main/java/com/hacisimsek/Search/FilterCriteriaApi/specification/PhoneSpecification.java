package com.hacisimsek.Search.FilterCriteriaApi.specification;

import com.hacisimsek.Search.FilterCriteriaApi.model.Phone;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;


public class PhoneSpecification {
    public static Specification<Phone> filterPhone(String phoneBrand, String phoneName){
        return (root, query, criteriaBuilder) -> {
            Predicate brandPredicate = criteriaBuilder
                    .like(root.get("phoneBrand"), StringUtils.isBlank(phoneBrand) ? likePattern("") : phoneBrand);
            Predicate namePredicate = criteriaBuilder
                    .like(root.get("phoneName"), StringUtils.isBlank(phoneName) ? likePattern("") : phoneName);
            return criteriaBuilder.and(brandPredicate, namePredicate);
        };
    }
    public  static Specification<Phone> searchPhone(String search){
        return (root, query, criteriaBuilder) -> {
            Predicate brandPredicate = criteriaBuilder
                    .like(root.get("phoneBrand"), StringUtils.isBlank(search) ? likePattern("") : search);
            Predicate namePredicate = criteriaBuilder
                    .like(root.get("phoneName"), StringUtils.isBlank(search) ? likePattern("") : search);
            return criteriaBuilder.or(brandPredicate, namePredicate);
        };
    }
    private static String likePattern(String str){
        return "%" + str + "%";
    }
}
