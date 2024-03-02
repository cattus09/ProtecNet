package com.protecNet.protecNet.entities;

import java.util.Date;

public record Token(
        String token,
        Date expirationDate) {

}
