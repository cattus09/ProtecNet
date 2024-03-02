package com.protecNet.protecNet.services.token;


import com.protecNet.protecNet.entities.Login;
import com.protecNet.protecNet.entities.Token;
import com.protecNet.protecNet.entities.User;
import com.protecNet.protecNet.exceptions.InvalidLoginException;
import com.protecNet.protecNet.exceptions.ItemNotFoundException;
import com.protecNet.protecNet.services.EmpresaService;
import com.protecNet.protecNet.services.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class JWTService implements ITokenService{
    @Value("${jwt.secret}")
    String secret;
    @Autowired
    private PasswordEncoder encryptionService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private EmpresaService empresaService;

    private String generateSToken(User user, Date expirationDate) {
         return Jwts.builder()
                         .setSubject(user.getUsername())
                         .claim("ROL", user.getRol())
                         .setIssuedAt(new Date())
                         .setExpiration(expirationDate)
                         .signWith(SignatureAlgorithm.HS256, secret)
                         .compact();
    }

    public Token getToken(Login login) throws InvalidLoginException {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, 3600);
        try{
            User user = usersService.findByUserName(login.getUsername());
            boolean isValid = this.encryptionService.matches(login.getPassword(), user.getEncryptedPassword());
            if (isValid){
                isValid = empresaService.isValidLicense(user, login.getLicense());
            }
            if (isValid){
                return new Token(generateSToken(user, expirationDate.getTime()), expirationDate.getTime());
            }
            throw new InvalidLoginException();
        }catch (ItemNotFoundException ex){
            throw new InvalidLoginException();
        }



    }
}
