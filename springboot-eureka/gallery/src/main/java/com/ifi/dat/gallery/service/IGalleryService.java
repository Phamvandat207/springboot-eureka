package com.ifi.dat.gallery.service;

import com.ifi.dat.gallery.dto.GalleryDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IGalleryService {

    List<GalleryDTO> getAllGalleries();
    GalleryDTO createGallery(GalleryDTO galleryDTO);
    GalleryDTO getGallery(String id);
    GalleryDTO updateGallery(GalleryDTO galleryDTO);
    void deletedGallery(GalleryDTO galleryDTO);
}
