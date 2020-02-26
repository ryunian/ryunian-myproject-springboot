package com.springboot.myproject.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PaginationDto {
    private int totalCount;
    private int countList = 5;
    private int countPage = 10;
    private int totalPage;
    private int page;
    private int startPage;
    private int endPage;

    @Builder
    public PaginationDto(int totalCount, int page){
        this.totalCount = totalCount;
        this.page = page;
        this.totalPage = totalCount / countList;
        if (totalCount % countList > 0) {
            totalPage++;
        }
        if (totalPage < page) {
            this.page = totalPage;
        }
        startPage = ((page - 1) / countPage) * countPage + 1;
        endPage = startPage + countList - 1;
        if (endPage > totalPage){
        endPage = totalPage;
        }
    }
}

