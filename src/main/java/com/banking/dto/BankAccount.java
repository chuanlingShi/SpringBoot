package com.banking.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

public class BankAccount{
    @Id
    private int actNumber;
    @Column
    private String customerName;
    @Column
    private int actBalance;

}
