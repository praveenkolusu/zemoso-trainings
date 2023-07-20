package com.zmslabs.minet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetDTO {
    private Integer id;
    private String name;
    private String symbol;
}
