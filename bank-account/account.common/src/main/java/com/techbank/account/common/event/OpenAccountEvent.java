package com.techbank.account.common.event;

import com.techbank.account.common.dto.AccountType;
import com.techbank.cqrs.core.events.BaseEvent;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class OpenAccountEvent extends BaseEvent {

    private String accountHolder;
    private AccountType accountType;
    private double openingBalance;
    private Date createdDate;
}
