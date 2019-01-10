package com.infoshareacademy.tailandczycy.cdi;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;

import javax.ejb.Stateless;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Stateless
public class IdTokenVerifier {

    private static final String GOOGLE_CLIENT_ID = "4310245586-2k3iaj08lkb9qg2cdnkd87umoim72506.apps.googleusercontent.com";

    public IdTokenVerifier() {
    }

    public GoogleIdToken.Payload getPayload(String tokenString) throws IOException, GeneralSecurityException {

        JacksonFactory jacksonFactory = new JacksonFactory();
        GoogleIdTokenVerifier googleIdTokenVerifier =
                new GoogleIdTokenVerifier(new NetHttpTransport(), jacksonFactory);

        GoogleIdToken token = GoogleIdToken.parse(jacksonFactory, tokenString);

        if (googleIdTokenVerifier.verify(token)) {
            GoogleIdToken.Payload payload = token.getPayload();
            if (!GOOGLE_CLIENT_ID.equals(payload.getAudience())) {
                throw new IllegalArgumentException("Audience mismatch");
            } else if (!GOOGLE_CLIENT_ID.equals(payload.getAuthorizedParty())) {
                throw new IllegalArgumentException("Client ID mismatch");
            }
            return payload;
        } else {
            throw new IllegalArgumentException("id token cannot be verified");
        }
    }
}
