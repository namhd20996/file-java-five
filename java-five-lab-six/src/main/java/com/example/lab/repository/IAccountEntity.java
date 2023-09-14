package com.example.lab.repository;

import com.example.lab.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountEntity extends JpaRepository<AccountEntity, String> {
}
