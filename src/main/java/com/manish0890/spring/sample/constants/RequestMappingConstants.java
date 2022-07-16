package com.manish0890.spring.sample.constants;

public class RequestMappingConstants {

    private RequestMappingConstants() {
        // For static calls only
    }

    public static final String ROOT = "/";


    public static class Players {
        public static final String PLAYERS = ROOT + "players";
        public static final String PLAYER_BY_ID = "/{playerID}";
    }

    public static class Hospital {
        public static final String RECEPTION = ROOT + "reception";
    }

    public static class User {
        public static final String USER = ROOT + "user";
        public static final String USER_BY_ID = "/{id}";
    }

}
