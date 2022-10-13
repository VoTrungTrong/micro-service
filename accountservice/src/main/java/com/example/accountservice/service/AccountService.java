package com.example.accountservice.service;

import com.example.accountservice.dto.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    AccountDTO create(AccountDTO accountDTO);

    boolean changePassword(AccountDTO accountDTO);

    boolean deleteById(Long id);

    List<AccountDTO> getAll();

    AccountDTO getById(Long id);

}