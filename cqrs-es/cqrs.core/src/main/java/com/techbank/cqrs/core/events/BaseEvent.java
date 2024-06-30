package com.techbank.cqrs.core.events;

import com.techbank.cqrs.core.messages.Message;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class BaseEvent extends Message {

    private int version;
}
