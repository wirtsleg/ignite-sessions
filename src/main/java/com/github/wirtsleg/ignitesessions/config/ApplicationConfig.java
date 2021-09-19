package com.github.wirtsleg.ignitesessions.config;

import lombok.RequiredArgsConstructor;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    public static final String IGNITE_NAME = "ignite";

    @Value("${ignite.addresses}")
    private final List<String> addresses;

    @Bean(IGNITE_NAME)
    public IgniteClient ignite() {
        ClientConfiguration cfg = new ClientConfiguration()
            .setAddresses(addresses.toArray(new String[0]));

        return Ignition.startClient(cfg);
    }
}
