package com.alkemy.challengebackend.service;

import java.io.IOException;

public interface IEmailSenderService {
    public void sendEmail (String to) throws IOException;
}
