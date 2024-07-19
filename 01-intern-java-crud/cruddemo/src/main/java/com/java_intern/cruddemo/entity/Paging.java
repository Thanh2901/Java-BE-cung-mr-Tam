package com.java_intern.cruddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paging<T> {
    int pageSize;
    int currentPage;
    long total;
    int offset;
    List<T> data;
}
