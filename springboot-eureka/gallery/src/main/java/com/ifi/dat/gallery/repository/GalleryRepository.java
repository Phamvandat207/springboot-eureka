package com.ifi.dat.gallery.repository;

import com.ifi.dat.gallery.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, String> {
}
