package com.protecNet.protecNet.services;

import com.protecNet.protecNet.dto.UserDTO;

import com.protecNet.protecNet.entities.Empresa;
import com.protecNet.protecNet.entities.User;
import com.protecNet.protecNet.exceptions.ItemNotFoundException;
import com.protecNet.protecNet.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService  implements UserDetailsService{


    @Autowired
    private PasswordEncoder encryptionService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired private UserRepository userRepository;

    public User create(UserDTO userDTO) {
        String encPassword = encryptionService.encode(userDTO.getPassword());
        Empresa empresa = empresaService.getById(userDTO.getEmpresaId());

        User user = new User(userDTO.getUsername(), encPassword, empresa, userDTO.getRol());
        return userRepository.save(user);
    }

    public User findByUserName(String username) throws ItemNotFoundException {
        return userRepository.findById(username)
                .orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User user = findByUserName(username);
            List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(user.getRol().name()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getEncryptedPassword(), authorities);
        }catch (ItemNotFoundException ignored) {
            throw new UsernameNotFoundException("User not found");

        }
    }
}
