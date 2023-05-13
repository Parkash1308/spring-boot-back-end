package fullstackdevelopment.controller;

import fullstackdevelopment.model.Loan;
import fullstackdevelopment.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/loans")

public class LoanController {
    private final LoanService loanService;
    @Autowired

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @GetMapping
    public List<Loan> getAllLoans(){
        return loanService.findAllLoans();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id){
        Optional<Loan> loan=loanService.findLoanById(id);
        return  loan.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan){
        Loan savedLoan=loanService.savaLoan(loan);
        return ResponseEntity.created(URI.create("/api/loans/" + savedLoan.getLoanID())).body(savedLoan);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteLoanById(@PathVariable Long id){
        loanService.deleteLoanById(id);
        return ResponseEntity.noContent().build();
    }
}
