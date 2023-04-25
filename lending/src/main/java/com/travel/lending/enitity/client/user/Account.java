package com.travel.lending.enitity.client.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Account {
    private Long id;
    private Long userId;
    @JsonProperty("acc_number")
    private String accNumber;
    @JsonProperty("acc_type")
    private String accType;
    @JsonProperty("acc_name")
    private String accName;
}
