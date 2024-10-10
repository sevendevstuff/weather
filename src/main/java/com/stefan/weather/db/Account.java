package com.stefan.weather.db;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Data
@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String firstName;

    @Column(nullable = false)
    public String lastName;

    @Column(nullable = false)
    public String email;

    @Column(nullable = false)
    public String password;

    @OneToMany()
    @JoinTable(
            name = "account_city", // Name of the join table
            joinColumns = @JoinColumn(name = "account_id"), // Foreign key to Account
            inverseJoinColumns = @JoinColumn(name = "city_id") // Foreign key to City
    )
    public List<City> favouriteCities;
}
