package com.zmslabs.minet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WatchListDTO {
    private Long id;
    private Long userId;
    private Long assetId;

}
