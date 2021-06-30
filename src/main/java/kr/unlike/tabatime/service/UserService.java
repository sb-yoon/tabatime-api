package kr.unlike.tabatime.service;

import kr.unlike.tabatime.dao.UserDao;
import kr.unlike.tabatime.domain.User;
import kr.unlike.tabatime.dto.response.Result;
import kr.unlike.tabatime.exception.BizException;
import kr.unlike.tabatime.exception.InvalidTokenException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService{

    private final UserDao userDao;

    @Transactional(readOnly = true)
    public User findOneByEmail(String email) {
        return userDao.findOneByEmail(email);
    }
}
