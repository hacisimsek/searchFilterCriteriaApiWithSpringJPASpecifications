package com.hacisimsek.Search.FilterCriteriaApi.controller;

import com.hacisimsek.Search.FilterCriteriaApi.model.Phone;
import com.hacisimsek.Search.FilterCriteriaApi.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
@RequiredArgsConstructor
public class PhoneController {
    private final PhoneService phoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> getPhones(@RequestParam(required = false) String phoneBrand,
                                                 @RequestParam(required = false) String phoneName) {
        return ResponseEntity.ok(phoneService.findAllPhones(phoneBrand, phoneName));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Phone>> searchPhones(@RequestParam(required = false) String search) {
        return ResponseEntity.ok(phoneService.searchPhones(search));
    }

    @PostMapping
    public ResponseEntity<Phone> addPhone(Phone phone) {
        return ResponseEntity.ok(phoneService.addPhone(phone));
    }
}
