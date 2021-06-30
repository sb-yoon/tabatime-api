package kr.unlike.tabatime.service;

import kr.unlike.tabatime.dao.RoutineDao;
import kr.unlike.tabatime.dao.UserDao;
import kr.unlike.tabatime.domain.Routine;
import kr.unlike.tabatime.domain.User;
import kr.unlike.tabatime.dto.RoutineRequest;
import kr.unlike.tabatime.dto.RoutineResponse;
import kr.unlike.tabatime.dto.StatisticsResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class RoutineService {

    private final RoutineDao routineDao;
    private final UserDao userDao;

    @Transactional
    public void saveRoutine(User user, RoutineRequest routineRequest) {
        Routine routine = Routine.builder()
                .exerciseTime(routineRequest.getExerciseTime())
                .restTime(routineRequest.getRestTime())
                .setCnt(routineRequest.getSetCnt())
                .roundCnt(routineRequest.getRoundCnt())
                .roundTime(routineRequest.getRoundTime())
                .totalTime(routineRequest.getTotalTime())
                .userId(user.getId())
                .build();

        int totalExerciseTime = user.getTotalExerciseTime() + (routine.getExerciseTime() * routine.getSetCnt() * routine.getRoundCnt());
        user.setTotalExerciseTime(totalExerciseTime);

        routineDao.insert(routine);
        userDao.updateExerciseTime(user);
    }

    @Transactional(readOnly = true)
    public List<RoutineResponse> getRoutineList(User user) {
        return new RoutineResponse().of(routineDao.findByUser(user.getId()));
    }

    @Transactional(readOnly = true)
    public StatisticsResponse getStatistics(User user) {
        int routineCnt = routineDao.findTotalCountByUser(user.getId());
        int routineTime = routineDao.findTotalRoutineTimeByUser(user.getId());
        log.info(routineTime + "");

        int userCnt = userDao.findTotalCount();
        int rank = userDao.currentRankingUser(user);
        double per = 100.0 / userCnt * rank;

        return StatisticsResponse.builder()
                .totalRoutineCnt(routineCnt)
                .totalRoutineTime(routineTime)
                .rankPer(per)
                .build();
    }

    @Transactional
    public void deleteRoutines(User user, List<String> routineIds) {
        routineDao.delete(user.getId(), routineIds);
    }
}
