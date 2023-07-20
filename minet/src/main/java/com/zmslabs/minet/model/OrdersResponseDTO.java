package com.zmslabs.minet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersResponseDTO implements Serializable {
    private String message;
    private String code;
}
