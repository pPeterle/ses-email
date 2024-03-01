package com.peterle.emailservice.service;

import com.peterle.emailservice.adapters.EmailSenderAdapter;
import com.peterle.emailservice.core.usecases.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {
    @Autowired
    private EmailSenderAdapter emailSenderAdapter;
    
    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderAdapter.sendEmail(to, subject, body);
    }
}
