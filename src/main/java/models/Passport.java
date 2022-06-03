package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "passport")
@AllArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "passport_number")
    private Integer passportNumber;

    @Column(name = "county")
    private String country;

    public Passport(Integer passportNumber, String country) {
        this.passportNumber = passportNumber;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id) && Objects.equals(passportNumber, passport.passportNumber) && Objects.equals(country, passport.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passportNumber, country);
    }
}



