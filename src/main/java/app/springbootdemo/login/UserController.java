package app.springbootdemo.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/users")
public class UserController {
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) throws UsernameAlreadyExistsException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        ApplicationUser appUser =  userDetailsService.checkUsernameinSystem(user.getUsername());
        if(appUser !=null){
            throw new UsernameAlreadyExistsException("Username already exists in system");
        }

        applicationUserRepository.save(user);
    }


    @PostMapping("/login")

    public void login(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

}