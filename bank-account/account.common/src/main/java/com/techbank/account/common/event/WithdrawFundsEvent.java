package com.techbank.account.common.event;

import com.techbank.cqrs.core.events.BaseEvent;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class WithdrawFundsEvent extends BaseEvent {

    private double amount;
}
