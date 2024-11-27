package ma.ClientService.controller;

import lombok.RequiredArgsConstructor;
import ma.ClientService.dto.ClientDto;
import ma.ClientService.dto.ClientDtoWithoutId;
import ma.ClientService.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/clients") @RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    
    @GetMapping("get/all")
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }
    @GetMapping("get/byId/{id}")
    public ClientDto getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/post")
    public ClientDto addClient(@RequestBody ClientDtoWithoutId clientDtoWithoutId) {
        return clientService.addClient(clientDtoWithoutId);
    }

    @DeleteMapping("/delete/productById/{id}")
    public ResponseEntity<Map<String, Object>> deleteClientById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        clientService.deleteClientById(id);
        response.put("message", "Client with id " + id + " deleted successfully");
        response.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(response);

    }

    @PutMapping("/update/productById/{id}")
    public ClientDto updateClient(@PathVariable Long id, @RequestBody ClientDtoWithoutId clientDtoWithoutId) {
        return clientService.updateClient(id,clientDtoWithoutId);
    }

}
