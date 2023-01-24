package com.microservico.kafka.com.microservico.kafka.rervices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservico.kafka.com.microservico.kafka.model.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PedidoService {

    @KafkaListener(topics = "registraPedido", groupId = "microservicoRegistraPedido")
    private void executarPedido(ConsumerRecord<String, String> record) throws JsonProcessingException {

        String strDados = record.value();

        ObjectMapper mapper = new ObjectMapper();

        Pedido pedido = mapper.readValue(strDados, Pedido.class);

        log.info("Pedido: {}", pedido);
    }
}
