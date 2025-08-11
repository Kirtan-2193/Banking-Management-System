package com.banking.bms.services;

import com.banking.bms.model.entities.Account;
import com.banking.bms.model.entities.Loan;
import com.banking.bms.model.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendEmail(String to, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }


    public void loanApprovalEmail(User user, Account account, Loan loan, double emi) {
        sendEmail(user.getEmail(),
                "✅ Loan Approved – Disbursal Scheduled",
                "Dear " + user.getFirstName() + " " + user.getLastName() + ",\n\n" +
                        "We’re pleased to inform you that your loan application has been approved by our team.\n\n" +
                        "   • Loan Number: " + loan.getLoanNumber() + "\n" +
                        "   • Loan Type: " + loan.getLoanType() + "\n" +
                        "   • Approved Amount: ₹" + loan.getLoanAmount() + "\n" +
                        "   • Interest Rate: " + loan.getInterestRate() + "%\n" +
                        "   • Terms: " + loan.getLoanTerm() + " months\n" +
                        "   • EMI Amount: " + emi + "\n" +
                        "   • Start Date: " + loan.getStartDate() + "\n\n" +
                        "Please note: The approved loan amount will be credited to your account on the start date mentioned above.\n\n" +
                        "Thank you for choosing our services.\n\n" +
                        "Best regards,\n" +
                        "Loan Department\n" +
                        account.getAccountBranch()
        );
    }


    public void loanRejectionEmail(User user, Account account, Loan loan) {
        sendEmail(user.getEmail(),
                "Loan Application Status – Not Approved",
                "Dear " + user.getFirstName() + " " + user.getLastName() + ",\n\n" +
                        "Thank you for applying for a loan with us. We appreciate your interest in our services.\n\n" +
                        "After careful review of your application, we regret to inform you that your loan request has not been approved at this time.\n\n" +
                        "   • Loan Type: " + loan.getLoanType() + "\n" +
                        "   • Requested Amount: ₹" + loan.getLoanAmount() + "\n" +
                        "   • Date: " + LocalDate.now() + "\n\n" +
                        "   • Remarks: " + loan.getRemarks() + "\n\n" +
                        "If you would like to discuss this further or need clarification, please feel free to contact our support team.\n\n" +
                        "Warm regards,\n" +
                        "Loan Department\n" +
                        account.getAccountBranch()
        );
    }


    public void loanPaymentEmail(User user, Account account, Loan loan, double emi, int count) {
        sendEmail(
                user.getEmail(),
                "✅ EMI Payment Received - Thank You",
                "Dear " + user.getFirstName() + " " + user.getLastName() + ",\n\n" +
                        "We have received your EMI payment for the current billing cycle. Thank you for your timely payment.\n\n" +
                        "📌 Payment Details:\n" +
                        "   • Loan Number: " + loan.getLoanNumber() + "\n" +
                        "   • EMI Amount Paid: ₹" + emi + "\n" +
                        "   • Payment Date: " + LocalDate.now() + "\n" +
                        (count == loan.getLoanTerm() ? "" : "   • Next Due Date: " + loan.getNextEmiDueDate() + "\n\n") +
                        "You are up to date with your loan repayment schedule." +
                        (count == loan.getLoanTerm() ? " This was your final EMI payment, and your loan is now fully repaid. Congratulations!" : "") +
                        "\n\nIf you did not make this payment or notice any discrepancies, please contact us immediately.\n\n" +
                        "Thank you for your continued trust in our services.\n\n" +
                        "Warm regards,\n" +
                        "Loan Department\n" +
                        account.getAccountBranch()
        );
    }


    public void creditEmail(User user, double creditAmount, double totalBalance) {
        sendEmail(user.getEmail(),
                "💰 Transaction Alert - Credit Notification",
                "Dear " + user.getFirstName() + ",\n\n" +
                        "We are pleased to inform you that a credit transaction has been made to your account.\n\n" +
                        "   • Amount Credited: ₹" + creditAmount + "\n" +
                        "   • Updated Balance: ₹" + totalBalance + "\n\n" +
                        "Thank you for banking with us.\n\n" +
                        "Warm regards,\n" +
                        "Customer Service Team"
        );
    }


    public void debitEmail(User user, double debitAmount, double totalBalance) {
        sendEmail(user.getEmail(),
                "💸 Transaction Alert - Debit Notification",
                "Dear " + user.getFirstName() + ",\n\n" +
                        "We would like to inform you that a debit transaction has been made from your account.\n\n" +
                        "   • Amount Debited: ₹" + debitAmount + "\n" +
                        "   • Remaining Balance: ₹" + totalBalance + "\n\n" +
                        "Thank you for banking with us.\n\n" +
                        "Warm regards,\n" +
                        "Customer Service Team"
        );
    }
}
