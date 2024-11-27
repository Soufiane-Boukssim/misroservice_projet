package ma.ClientService.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ClientDtoWithoutId {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
