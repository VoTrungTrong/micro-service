package com.example.accountservice.controller;

import com.example.accountservice.dto.AccountDTO;
import com.example.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountDTO create(@RequestBody AccountDTO accountDTO) {
        return this.accountService.create(accountDTO);
    }

    @GetMapping
    public List<AccountDTO> getAll() {
        return this.accountService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getById(@PathVariable("id") Long id) {
        AccountDTO accountDTO = this.accountService.getById(id);
        if (accountDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        return this.accountService.deleteById(id) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
