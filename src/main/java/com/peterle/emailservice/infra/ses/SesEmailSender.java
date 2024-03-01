package com.peterle.emailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.peterle.emailservice.adapters.EmailSenderAdapter;
import com.peterle.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderAdapter {
    
    private final AmazonSimpleEmailService amazonSimpleEmailService;
    
    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }
    
    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("phpeterle1@gmail.com")
                .withDestination(new Destination().withToAddresses("phpeterle1@gmail.com"))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content((body))))
                );
        
        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException exception) {
            throw new EmailServiceException("Failure while sending email", exception);
        }
    }
}
