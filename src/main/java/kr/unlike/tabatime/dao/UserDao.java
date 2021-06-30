package kr.unlike.tabatime.dao;

import kr.unlike.tabatime.dao.base.BaseDao;
import kr.unlike.tabatime.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao extends BaseDao<User> {
    int findTotalCount();

    User findOneByEmail(String email);

    void updateLastLogin(String email);

    void leftUser(Long id);

    void updateExerciseTime(User user);

    int currentRankingUser(User user);
}
