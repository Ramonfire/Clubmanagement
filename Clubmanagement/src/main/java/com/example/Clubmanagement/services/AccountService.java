package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.AccountRepo;
import com.example.Clubmanagement.entities.compte.generlAc.Compte;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }


}
