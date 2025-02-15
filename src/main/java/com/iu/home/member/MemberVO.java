package com.iu.home.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails {
	
	@NotBlank(message = "ID는 꼭 필요해!!!")
	private String id;
	@NotBlank
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*\\\\W)(?=\\\\S+$).{6,12}")
	private String pw;
	private String pwCheck;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	
	@Range(max = 150, min = 0)
	private int age;
	
	@Past
	private Date birth;
	private boolean enabled;
	
	private List<RoleVO> roleVOs;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//<? super T>
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
			
		}
		return authorities;
	}
	
	@Override
	public String getPassword() {
		// 비밀번호 반환
		return this.pw;
	}
	
	@Override
	public String getUsername() {
		// ID 반환
		return this.id;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// 계정의 만료 여부
		// true : 만료 안됨
		// false : 만료 됨, 로그인 불가
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠김 여부
		// true : 계정이 잠기지 않음
		// false : 계정이 잠김, 로그인 불가
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 만료 여부
		// true : 만료 안됨
		// false : 만료 됨, 로그인 불가
		return true;
	}
	
	//isEnabled
	//계정 사용 여부
	// true : 계정 활성화(계정 사용 가능)
	// false : 계정 비활성화(계정 사용 불가, 로그인 불가)
	public boolean isEnabled() {
		return true;
	}

}
