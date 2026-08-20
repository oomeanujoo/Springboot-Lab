package com.example.springbootLab.model;

import lombok.*;

@Value
@Builder
public class ImmutableCLS {
    private final String accountNumber;
    private final String accountName;
    private final double accountBalance;
}
