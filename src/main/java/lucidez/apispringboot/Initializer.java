package lucidez.apispringboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lucidez.apispringboot.auth.entity.Role;
import lucidez.apispringboot.auth.entity.User;
import lucidez.apispringboot.auth.service.RoleService;
import lucidez.apispringboot.auth.service.UserService;

@Service
public class Initializer {
    
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    
    @PostConstruct
    public void criarUsuarioEPermissoes() {
        Role roleAdmin = new Role();

        roleAdmin.setName("USER");

        roleService.save(roleAdmin);

        User user = new User();
        user.setAtivo(true);
        user.setEmail("teste@teste.com");
        user.setNome("Lucas Mafra");
        user.setSenha(new BCryptPasswordEncoder().encode("1234"));
        user.setUsername("lucasmafra");
        user.setRoles(Arrays.asList(roleAdmin));

        userService.save(user);
    }
}
