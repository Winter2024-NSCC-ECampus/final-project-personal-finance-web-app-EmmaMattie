package com.financeapp.controller;

import com.financeapp.model.Transaction;
import com.financeapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public String showTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transactions"; // This shows the existing transactions.html
    }

    @PostMapping("/transactions/add")
    public String addTransaction(@RequestParam String type,
                                 @RequestParam String category,
                                 @RequestParam String tag,
                                 @RequestParam double amount,
                                 @RequestParam String date) {
        Transaction transaction = new Transaction(type, category, tag, amount, java.time.LocalDate.parse(date));
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions"; // Refresh with new transaction
    }
}
