package com.techbank.account.cmd.domain;

import com.techbank.account.cmd.api.commands.OpenAccountCommand;
import com.techbank.account.common.event.CloseAccountEvent;
import com.techbank.account.common.event.DepositFundsEvent;
import com.techbank.account.common.event.OpenAccountEvent;
import com.techbank.account.common.event.WithdrawFundsEvent;
import com.techbank.cqrs.core.domain.AggregateRoot;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class AccountAggregate extends AggregateRoot {

    private boolean isActive;
    private double balance;

    public AccountAggregate(OpenAccountCommand command) {

        raiseEvent(OpenAccountEvent.builder()
                .id(command.getId())
                .accountHolder(command.getAccountHolder())
                .accountType(command.getAccountType())
                .openingBalance(command.getOpeningBalance())
                .createdDate(new Date())
                .build());
    }

    public void apply(OpenAccountEvent event) {
        this.id = event.getId();
        this.isActive = true;
        this.balance = event.getOpeningBalance();
    }

    public void depositFunds(double amount) {
        if (!this.isActive) {
            throw new IllegalStateException("Account is not active");
        }
        if (amount <= 0) {
            throw new IllegalStateException("amount must be greater is than 0");
        }
        raiseEvent(DepositFundsEvent.builder()
                .id(this.id)
                .amount(amount)
                .build());
    }

    public void apply(DepositFundsEvent event) {
        this.id = event.getId();
        this.balance += event.getAmount();
    }

    public void withdrawFunds(double amount) {
        if (!this.isActive) {
            throw new IllegalStateException("Account is not active");
        }
        if (amount <= 0) {
            throw new IllegalStateException("amount must be greater is than 0");
        }
        raiseEvent(WithdrawFundsEvent.builder()
                .id(this.id)
                .amount(amount)
                .build());
    }

    public void apply(WithdrawFundsEvent event) {
        this.id = event.getId();
        this.balance -= event.getAmount();
    }

    public void closeAccount() {
        if (!this.isActive) {
            throw new IllegalStateException("Account is not active");
        }
        raiseEvent(CloseAccountEvent.builder()
                .id(this.id)
                .build());
    }

    public void apply(CloseAccountEvent event) {
        this.id = event.getId();
        this.isActive = false;
    }
}
