package com.zmslabs.minet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO  implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String type;
    private String password;
}
