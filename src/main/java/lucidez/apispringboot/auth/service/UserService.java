package lucidez.apispringboot.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lucidez.apispringboot.auth.entity.User;
import lucidez.apispringboot.auth.repository.UserRepository;
import lucidez.apispringboot.configuration.jwt.JwtRequest;
import lucidez.apispringboot.configuration.jwt.JwtTokenUtil;

@Service
public class UserService implements UserDetailsService{ 
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public ResponseEntity<?> signin(JwtRequest authenticationRequest) {
        try {
            autheticate(authenticationRequest.getUsername(), authenticationRequest.getSenha());
            final User UserDetails = userRepository.findByUsername(authenticationRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(UserDetails);
            return ResponseEntity.ok(token);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    private void autheticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
           throw new Exception("USUARIO DESABILITADO, e");
        } catch (BadCredentialsException e){
            throw new Exception("CREDENCIAIS INVALIDAS, e");
        }
    }
}
    
    
