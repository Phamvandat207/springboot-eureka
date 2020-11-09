package com.ifi.dat.gallery.controller;

import com.ifi.dat.gallery.dto.GalleryDTO;
import com.ifi.dat.gallery.entity.Gallery;
import com.ifi.dat.gallery.service.IGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/galleries")
public class HomeController implements IGalleryService {

    @Autowired
    @Qualifier("galleryServiceImpl")
    private IGalleryService iGalleryService;

    @GetMapping
    public List<GalleryDTO> getAllGalleries() {
        return iGalleryService.getAllGalleries();
    }

    @PostMapping
    public GalleryDTO createGallery(GalleryDTO galleryDTO) {
        return iGalleryService.createGallery(galleryDTO);
    }

    @GetMapping("/{Id}")
    public GalleryDTO getGallery(@PathVariable(value = "Id") String Id) {
        return iGalleryService.getGallery(Id);
    }

    @PostMapping
    public GalleryDTO updateGallery(GalleryDTO galleryDTO) {
        return iGalleryService.updateGallery(galleryDTO);
    }

    @DeleteMapping
    public void deletedGallery(GalleryDTO galleryDTO) {
        iGalleryService.deletedGallery(galleryDTO);
    }

}
