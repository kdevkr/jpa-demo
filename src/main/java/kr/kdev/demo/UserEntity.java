package kr.kdev.demo;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    // @Type(JsonBinaryType.class)
    @JdbcTypeCode(SqlTypes.JSON)
    private Metadata metadata;

    @Data
    public static class Metadata {
        private boolean active;
        @JsonAlias({"mfa_type"})
        private String mfaType;
    }
}
