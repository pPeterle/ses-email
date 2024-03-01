package com.peterle.emailservice.adapters;

public interface EmailSenderAdapter {
    void sendEmail(String to, String subject, String body);
}
