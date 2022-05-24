package com.example.testingqbee;

import com.google.firebase.messaging.FirebaseMessagingService;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token) {

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {

        tokens tk = new tokens();
        tk.setToken(token);
        MainActivity.db.collection("tokens").document(token).set(tk);

    }
}
