package com.rodin.sanitaryEngineeringShop.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService {

    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
}
