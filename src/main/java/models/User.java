package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "user_list")
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_list_id")
    private Set<Passport> passports;

    public User(String firstName, String lastName, String companyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(companyName, user.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, companyName);
    }
}



