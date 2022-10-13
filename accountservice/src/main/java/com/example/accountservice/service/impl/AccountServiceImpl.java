package com.example.accountservice.service.impl;

import com.example.accountservice.dto.AccountDTO;
import com.example.accountservice.entity.Account;
import com.example.accountservice.repository.AccountRepository;
import com.example.accountservice.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class AccountServiceImpl implements AccountService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        Account account = this.modelMapper.map(accountDTO, Account.class);
        this.accountRepository.save(account);
        accountDTO.setId(account.getId());
        return accountDTO;
    }

    @Override
    public boolean changePassword(AccountDTO accountDTO) {
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Account> accountOptional = this.accountRepository.findById(id);
        return accountOptional.map(account -> {
            this.accountRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public List<AccountDTO> getAll() {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        this.accountRepository.findAll().forEach((account -> {
            accountDTOS.add(this.modelMapper.map(account, AccountDTO.class));
        }));
        return accountDTOS;
    }

    @Override
    public AccountDTO getById(Long id) {
        Optional<Account> accountOptional = this.accountRepository.findById(id);
        return accountOptional.map(account -> this.modelMapper.map(account, AccountDTO.class)).orElse(null);
    }
}