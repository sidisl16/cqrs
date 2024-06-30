package com.techbank.account.common.event;

import com.techbank.cqrs.core.events.BaseEvent;
import lombok.Data;

@Data
public class DepositFundsEvent extends BaseEvent {

    private double amount;
}