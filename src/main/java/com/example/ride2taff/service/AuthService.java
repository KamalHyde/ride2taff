package com.example.ride2taff.service;

import com.example.ride2taff.dto.UserGoogleDto;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.Arrays;

@Service
public class AuthService implements IAuthService{


    @Override
    public UserGoogleDto tokenToDto(String id_token){
        HttpTransport transport = new NetHttpTransport();
        JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Arrays.asList("1088953237056-5gbllslbra0t94lffl71kt1v4u33og4h.apps.googleusercontent.com"))
                .build();

        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(id_token);
        } catch (GeneralSecurityException e) {
            return null;
        } catch (Exception e) {
            return null;
        }

        if (null == idToken) {
            return null;
        }

        GoogleIdToken.Payload payload = idToken.getPayload();

        UserGoogleDto dto = new UserGoogleDto();

        dto.setEmail(payload.getEmail());
        dto.setPrenom((String) payload.get("given_name"));
        dto.setNom((String) payload.get("family_name"));

        return dto;
    }
}
