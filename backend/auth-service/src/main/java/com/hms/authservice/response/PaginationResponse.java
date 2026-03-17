package com.hms.authservice.response;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationResponse<T> {
	private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;
    
    
    public static <T> PaginationResponse<T> fromPage(Page<T> page) {
        return PaginationResponse.<T>builder()
                .content(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .last(page.isLast())
                .build();
    }
	

}
