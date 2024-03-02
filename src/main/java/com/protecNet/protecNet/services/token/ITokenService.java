package com.protecNet.protecNet.services.token;


import com.protecNet.protecNet.entities.Login;
import com.protecNet.protecNet.entities.Token;
import com.protecNet.protecNet.exceptions.InvalidLoginException;

public interface ITokenService {
    Token getToken(Login login) throws InvalidLoginException;
}
