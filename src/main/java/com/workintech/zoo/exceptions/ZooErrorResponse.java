package com.workintech.zoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZooErrorResponse {

    // Testin hata vermemesi için değişken sırası bu şekilde (önce int) olmalı
    private int status;
    private String message;
    private long timestamp;
}