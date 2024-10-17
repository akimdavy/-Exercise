package com.example.demo.service;

import com.example.demo.model.Advertisement;
import com.example.demo.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;


    public Advertisement getAdvertisementById(Long id) {
        return advertisementRepository.findById(id).orElse(null);
    }

    public Advertisement addAdvertisement(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    public Advertisement updateAdvertisement(Long id, Advertisement advertisement) {
        advertisement.setId(id);
        return advertisementRepository.save(advertisement);
    }

    public void deleteAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }
}
