package com.example.TrustInsure.repository;

import com.example.TrustInsure.model.Client;

import java.util.List;

public interface IClientRepository {

    Client findById(Long id);

    List<Client> findALl();

    Client save(Client client);
}
