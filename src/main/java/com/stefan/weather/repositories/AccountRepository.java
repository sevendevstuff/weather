package com.stefan.weather.repositories;

import com.stefan.weather.db.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer>  {
    @Query(value = """
        SELECT a.* FROM Account a WHERE a.id = :#{#account.id};
    """, nativeQuery = true)
    List<Account> findById(@Param("account") Account account);

    @Query(value = """
            SELECT a FROM Account a WHERE a.email = :email;
    """, nativeQuery = true)
    Account findByEmail(String email);
}
