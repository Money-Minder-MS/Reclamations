package com.Examen.clients;

import com.Examen.clients.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gestion-utilisateur")
public interface UserClient {

    @GetMapping("/api/utilisateurs/getbyid/{id}")
    UserDTO getById(@PathVariable("id") Long id);
}