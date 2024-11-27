package ma.ClientService.services;

import ma.ClientService.dto.ClientDto;
import ma.ClientService.dto.ClientDtoWithoutId;

import java.util.List;

public interface IClientService {
    List<ClientDto> getAllClients();

    ClientDto getClientById(Long id);

    ClientDto addClient(ClientDtoWithoutId clientDtoWithoutId);

    ClientDto updateClient(Long id, ClientDtoWithoutId clientDtoWithoutId);

    void deleteClientById(Long id);
}
