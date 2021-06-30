package kr.unlike.tabatime.dao;

import kr.unlike.tabatime.dao.base.BaseDao;
import kr.unlike.tabatime.domain.Routine;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoutineDao extends BaseDao<Routine> {

    List<Routine> findByUser(Long userId);

    Integer findTotalCountByUser(Long userId);

    Integer findTotalRoutineTimeByUser(Long userId);

    void delete(Long userId, List<String> list);
}
