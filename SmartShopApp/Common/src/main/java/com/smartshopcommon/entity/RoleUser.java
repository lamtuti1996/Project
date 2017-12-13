package com.smartshopcommon.entity;
import org.springframework.security.core.GrantedAuthority;

public class RoleUser implements GrantedAuthority{
    
    private String authority;
     

 
    public void setAuthority(String authority) {
		this.authority = authority;
	}



	public String getAuthority() {
        return this.authority;
    }

}
