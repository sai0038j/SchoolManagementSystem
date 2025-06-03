package com.school.services;

public interface PasswordResetService {
    public void sendPasswordResetEmail(String email);
    public boolean validateToken(String token);
    public void updatePassword(String token, String newPassword);
}