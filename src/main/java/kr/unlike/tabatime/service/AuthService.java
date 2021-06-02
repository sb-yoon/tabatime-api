package kr.unlike.tabatime.service;

import kr.unlike.tabatime.auth.JwtTokenProvider;
import kr.unlike.tabatime.dao.UserDao;
import kr.unlike.tabatime.domain.User;
import kr.unlike.tabatime.dto.TokenResponse;
import kr.unlike.tabatime.dto.UserRequest;
import kr.unlike.tabatime.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDao userDao;

    @Transactional(readOnly = true)
    public User findOneByEmail(String email) {
        return userDao.findOneByEmail(email);
    }

    @Transactional
    public void signup(User user) {
        userDao.insert(user);
    }

    @Transactional
    public TokenResponse login(UserRequest userRequest) {

        User user = userDao.findOneByEmail(userRequest.getEmail());
        if (user == null) {
            throw new NotFoundException("가입되지 않는 회원입니다.", 990);
        }

        // 로그인 날짜
        userDao.updateLastLogin(user.getEmail());
        return TokenResponse.builder().token(jwtTokenProvider.generateToken(user.getEmail(), "USER")).build();
    }

    @Transactional
    public void left(User user) {
        userDao.leftUser(user.getId());
    }
}
