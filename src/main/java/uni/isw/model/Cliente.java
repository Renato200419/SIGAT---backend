package uni.isw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pk_cliente_id")
    @JsonProperty("Cliente_ID")
    private Long Cliente_ID;

    @JsonProperty("Cliente_Nombre")
    private String Cliente_Nombre;

    @JsonProperty("Cliente_ApePaterno")
    private String Cliente_ApePaterno;

    @JsonProperty("Cliente_ApeMaterno")
    private String Cliente_ApeMaterno;

    @JsonProperty("Cliente_Correo")
    private String Cliente_Correo;
    
    //Constructor por defecto
    public Cliente() {}
    // Constructor con parámetros
    public Cliente(Long Cliente_ID, String Cliente_Nombre, String Cliente_ApePaterno, String Cliente_ApeMaterno, String Cliente_Correo) {
        this.Cliente_ID = Cliente_ID;
        this.Cliente_Nombre = Cliente_Nombre;
        this.Cliente_ApePaterno = Cliente_ApePaterno;
        this.Cliente_ApeMaterno = Cliente_ApeMaterno;
        this.Cliente_Correo = Cliente_Correo;
    }
}
