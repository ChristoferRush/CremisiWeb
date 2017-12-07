package com.astralticket.converter;

import com.astralticket.entity.Client;
import com.astralticket.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ClientConverter implements Converter<String, Client> {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client convert(String s) {
        Client client = clientRepository.findOne(Long.parseLong(s));
        return client;
    }
}