package com.example.bootstrap.service;


import com.example.bootstrap.entity.User;
import com.example.bootstrap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailServiceImpl implements UserDetailsService {


     UserRepository userRepository;

    @Autowired
    public void setUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(s);
        user.getAuthorities().size();
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with name '%s', not found", s));
        }
        return user;
    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       User user = userRepository.findUserByName(username);
//       if (user == null){
//           throw  new UsernameNotFoundException(String.format("User with name '%s', not found", username));
//       }
//       return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//            mapRolesToAuthorities(user.getRoles()));
//    }
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getAuthority())).collect(Collectors.toSet());
//    }

}
