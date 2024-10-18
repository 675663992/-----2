package com.yhw.dto;

import lombok.Data;

@Data
public class ArchitecturesDto {
    private String title;
    private String description;
    private String url;

    public ArchitecturesDto(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }
}
