package com.stefan.weather.db;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "account")
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String firstName;

    @Column(nullable = false)
    public String lastName;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public String password;

    @OneToMany()
    @JoinTable(
            name = "account_city", // Name of the join table
            joinColumns = @JoinColumn(name = "account_id"), // Foreign key to Account
            inverseJoinColumns = @JoinColumn(name = "city_id") // Foreign key to City
    )
    public List<City> cities = new ArrayList<>();

    public Account(String firstName, String lastName, String email, String password, List<City> favouriteCities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cities = favouriteCities;
    }
}
