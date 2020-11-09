package com.ifi.dat.gallery.service.Impl;

import com.ifi.dat.gallery.dto.GalleryDTO;
import com.ifi.dat.gallery.entity.Gallery;
import com.ifi.dat.gallery.repository.GalleryRepository;
import com.ifi.dat.gallery.service.IGalleryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GalleryServiceImpl implements IGalleryService {
    @Autowired
    private GalleryRepository galleryRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<GalleryDTO> getAllGalleries() {
        List<Gallery> galleries = galleryRepository.findAll();
        List<GalleryDTO> galleryDTOS = new ArrayList<>();
        for (Gallery gallery: galleries) {
            GalleryDTO galleryDTO = modelMapper.map(gallery, GalleryDTO.class);
            galleryDTOS.add(galleryDTO);
        }

        return galleryDTOS;
    }

    @Override
    public GalleryDTO createGallery(GalleryDTO galleryDTO) {
        Gallery gallery = modelMapper.map(galleryDTO, Gallery.class);
        gallery.setId(galleryDTO.getId());
        gallery.setImages(galleryDTO.getImages());
        Gallery savedGallery = galleryRepository.save(gallery);
        return modelMapper.map(savedGallery, GalleryDTO.class);
    }

    @Override
    public GalleryDTO getGallery(String id) {
        Gallery gallery = galleryRepository.findById(id).orElse(null);

        List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
        gallery.setImages(images);
        return modelMapper.map(gallery, GalleryDTO.class);
    }

    @Override
    public GalleryDTO updateGallery(GalleryDTO galleryDTO) {
        String galleryId = galleryDTO.getId();
        Gallery gallery = galleryRepository.findById(galleryId).orElse(null);
        modelMapper.map(galleryDTO, gallery);
        Gallery savedGallery = galleryRepository.save(Objects.requireNonNull(gallery));
        return modelMapper.map(savedGallery, GalleryDTO.class);
    }

    @Override
    public void deletedGallery(GalleryDTO galleryDTO) {
        String galleryId = galleryDTO.getId();
        Gallery gallery = galleryRepository.findById(galleryId).orElse(null);
        galleryRepository.delete(Objects.requireNonNull(gallery));
    }
}
