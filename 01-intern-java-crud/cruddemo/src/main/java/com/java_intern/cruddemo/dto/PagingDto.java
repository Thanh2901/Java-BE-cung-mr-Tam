package com.java_intern.cruddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingDto<T> {
    int pageSize;
    int currentPage;
    long total;
    List<T> data;
}
