package ma.ClientService.services;

import lombok.RequiredArgsConstructor;
import ma.ClientService.dto.ClientDto;
import ma.ClientService.dto.ClientDtoWithoutId;
import ma.ClientService.entities.Client;
import ma.ClientService.exceptions.ClientNotFoundException;
import ma.ClientService.mappers.ClientMapper;
import ma.ClientService.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients= clientRepository.findAll();
        if (clients.isEmpty())
            throw new ClientNotFoundException("Client table is empty");
        List<ClientDto> clientsDto = new ArrayList<>();
        for (Client client : clients) {
            ClientDto clientDto = clientMapper.fromClientToClientDto(client);
            clientsDto.add(clientDto);
        }
        return clientsDto;
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client= clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id));
        return clientMapper.fromClientToClientDto(client);
    }

    @Override
    public ClientDto addClient(ClientDtoWithoutId clientDtoWithoutId) {
        Client client= clientMapper.fromClientDtoWithoutIdToClient(clientDtoWithoutId);
        client= clientRepository.save(client);
        return clientMapper.fromClientToClientDto(client);
    }

    @Override
    public ClientDto updateClient(Long id, ClientDtoWithoutId clientDtoWithoutId) {
        clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id));
        Client client= clientMapper.fromClientDtoWithoutIdToClient(clientDtoWithoutId);
        client.setId(id);
        client = clientRepository.save(client);
        return clientMapper.fromClientToClientDto(client);
    }


    @Override
    public void deleteClientById(Long id) {
        clientRepository.findById(id)
                .ifPresentOrElse(
                        clientRepository::delete,
                        ()->{
                            throw new ClientNotFoundException("Client not found with id: " + id);
                        }
                );
    }

}
