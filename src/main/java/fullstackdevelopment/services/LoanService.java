package fullstackdevelopment.services;

import fullstackdevelopment.doa.LoanRepository;
import fullstackdevelopment.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
   private final LoanRepository loanRepository;
    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public List<Loan> findAllLoans(){
        return loanRepository.findAll();
    }
    public Optional<Loan> findLoanById(Long id){
        return loanRepository.findById(id);
    }

    public Loan savaLoan(Loan loan){
        return  loanRepository.save(loan);
    }
    public void  deleteLoanById(Long id){
        loanRepository.deleteById(id);
    }
}
