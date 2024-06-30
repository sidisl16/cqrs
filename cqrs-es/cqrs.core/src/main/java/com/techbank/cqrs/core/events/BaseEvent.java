package com.techbank.cqrs.core.events;

import com.techbank.cqrs.core.messages.Message;
import lombok.Data;

@Data
public abstract class BaseEvent extends Message {

    private int version;
}
