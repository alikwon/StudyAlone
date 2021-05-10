package org.alikwon.security;

import org.alikwon.domain.MemberVO;
import org.alikwon.mapper.MemberMapper;
import org.alikwon.security.domain.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.warn("Load 유저 by 유저네임: "+userName);
		
		//userName means userid
		MemberVO vo = memberMapper.read(userName);
		log.warn("queried by member mapper: "+vo);
		
		return vo == null ? null : new CustomUser(vo);
	}
	
	

}
