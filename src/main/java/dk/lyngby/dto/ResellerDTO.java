package dk.lyngby.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ResellerDTO {
    private int id;
    private String name;
    private String address;
    private int phone;

    public ResellerDTO(int id, String name, String address, int phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


}
