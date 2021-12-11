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

    public Compte findAccount(String email){
        Compte compte= this.accountRepo.findByEmail(email);
        if (compte.getIdE()!=null)
    return compte;
        else return new Compte(Long.valueOf(-1),"-1","-1","-1","-1",Long.valueOf(-1));

    }
}
