package com.ifi.dat.gallery.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GalleryDTO {
    private String id;
    private List<Object> images;
}
