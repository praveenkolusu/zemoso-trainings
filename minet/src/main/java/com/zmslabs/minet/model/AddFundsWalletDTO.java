package com.zmslabs.minet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddFundsWalletDTO {
    private Long walletId;
    private Double amount;
}
