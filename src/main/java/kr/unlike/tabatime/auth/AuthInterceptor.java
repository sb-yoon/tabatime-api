package kr.unlike.tabatime.auth;

import kr.unlike.tabatime.domain.User;
import kr.unlike.tabatime.exception.InvalidTokenException;
import kr.unlike.tabatime.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";

    private final JwtTokenProvider tokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("preHandle");

        String token = null;
        // 1. Request Header 에서 토큰을 가져옴.
        String bearer = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearer) && bearer.startsWith(BEARER_PREFIX)) {
            token = bearer.substring(7);
    }

        log.info("token : {}", token);

        // 2. validateToken 으로 토큰 유효성 검사
        if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {

            User user = tokenProvider.getAuthentication(token);
            if (user == null) throw new NotFoundException("유효하지 않는 토큰입니다.", 401);
            request.setAttribute("user", user);

            return true;
        } else {
            throw new InvalidTokenException("유효하지 않는 토큰입니다.", 401);
        }
    }
}
