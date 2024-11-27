package ma.ClientService.mappers;

import ma.ClientService.dto.ClientDto;
import ma.ClientService.dto.ClientDtoWithoutId;
import ma.ClientService.entities.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    private final ModelMapper modelMapper=new ModelMapper();

    public ClientDto fromClientToClientDto(Client client){
        return modelMapper.map(client, ClientDto.class);
    }

    public Client fromClientDtoWithoutIdToClient(ClientDtoWithoutId clientDtoWithoutId){
        return modelMapper.map(clientDtoWithoutId, Client.class);
    }
}
