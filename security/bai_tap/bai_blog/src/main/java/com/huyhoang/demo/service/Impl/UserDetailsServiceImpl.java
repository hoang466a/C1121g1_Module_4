package com.huyhoang.demo.service.Impl;


import com.huyhoang.demo.model.entity.AppUser;
import com.huyhoang.demo.model.entity.UserRole;
import com.huyhoang.demo.repository.IAppUserRepository;
import com.huyhoang.demo.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=appUserRepository.findByUserName(username);
        if(appUser==null){
            System.out.println("User not found! "+username);
            throw new UsernameNotFoundException("User"+ username+"+ was not found in the database");
        }
        System.out.println("Found User: "+username);
        List<UserRole> roleNames=userRoleRepository.findAllByAppUser(appUser);
        List<GrantedAuthority>grantList=new ArrayList<GrantedAuthority>();
        if(roleNames!=null){
            for(UserRole userRole:roleNames){
                GrantedAuthority authoriry=new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantList.add(authoriry);
            }
        }
        UserDetails userDetails=(UserDetails) new User(appUser.getUserName(),
                appUser.getEncrytedPassword(),grantList);
        return userDetails;
    }
}
