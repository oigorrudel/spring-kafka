package br.xksoberbado.consumer.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyCustomHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(final Message<?> message, final ListenerExecutionFailedException exception) {
        log.info("*** Entrou no handler");
        log.info("Payload: {}", message.getPayload());
        log.info("Exception: {}", exception.toString());
//        return null;
        throw exception;
    }

//    @Override
//    public Object handleError(final Message<?> message, final ListenerExecutionFailedException exception, final Consumer<?, ?> consumer) {
//        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//    }
}
