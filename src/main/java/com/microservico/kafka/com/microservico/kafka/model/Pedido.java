package com.microservico.kafka.com.microservico.kafka.model;

import java.math.BigDecimal;

public record Pedido(String codigo, String nome, BigDecimal valor) {}
