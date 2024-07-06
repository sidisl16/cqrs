package com.techbank.cqrs.core.events;

import com.techbank.cqrs.core.messages.Message;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class BaseEvent extends Message {

    private int version;
}
