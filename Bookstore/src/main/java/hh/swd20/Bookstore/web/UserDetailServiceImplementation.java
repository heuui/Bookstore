package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@Service
// Spring Security
// authenticates and authorizes user.
public class UserDetailServiceImplementation implements UserDetailsService  {
	private final UserRepository urepository;

	@Autowired
	public UserDetailServiceImplementation(UserRepository userRepository) {
		this.urepository = userRepository;
	}

    @Override
    // User-class object's information -> userDetails-class object (Spring)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	
    	User currUser = urepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currUser.getPasswordHash(), 
        	AuthorityUtils.createAuthorityList(currUser.getRole()));
        return user;
        
    }   
} 