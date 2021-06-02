/* 회원 */
CREATE TABLE tbl_user
(
    `id`                            BIGINT           NOT NULL    AUTO_INCREMENT         COMMENT '회원 식별자',
    `sns_type`                      VARCHAR(20)      NOT NULL                           COMMENT 'sns 종류: kakao',
    `sns_id`                        VARCHAR(45)      NULL                               COMMENT 'sns 아이디',
    `email`                         VARCHAR(100)     NOT NULL                           COMMENT '이메일',
    `total_exercise_time`           INT              NULL        DEFAULT 0              COMMENT '총 운동시간',
    `status`                        VARCHAR(20)      NOT NULL    DEFAULT 'active'       COMMENT '회원 상태: active(정상), paused(휴면), blocked(차단), left(탈퇴)',
    `login_date`                    DATETIME         NULL                               COMMENT '최종로그인일시',
    `paused_date`                   DATETIME         NULL                               COMMENT '휴면일시',
    `left_date`                     DATETIME         NULL                               COMMENT '탈퇴일시',
    `blocked_date`                  DATETIME         NULL                               COMMENT '차단일시',
    `reg_date`                      DATETIME         NOT NULL                           COMMENT '등록일시',
    `mod_date`                      DATETIME         NOT NULL                           COMMENT '수정일시',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=UTF8mb4 COMMENT '회원';

/* 운동 루틴 */
CREATE TABLE tbl_routine
(
    `id`                            BIGINT           NOT NULL    AUTO_INCREMENT         COMMENT '루틴 식별자',
    `exercise_time`                 INT              NOT NULL                           COMMENT '운동시간(초단위)',
    `rest_time`                     INT              NOT NULL                           COMMENT '휴식시간(초단위)',
    `set_cnt`                       INT              NOT NULL                           COMMENT '세트수',
    `round_cnt`                     INT              NOT NULL                           COMMENT '라운드수',
    `round_time`                    INT              NOT NULL                           COMMENT '라운드시간',
    `total_time`                    INT              NOT NULL                           COMMENT '총 운동시간(초단위)',
    `user_id`                       BIGINT           NOT NULL                           COMMENT '회원 식별자',
    `reg_date`                      DATETIME         NOT NULL                           COMMENT '등록일시',
    PRIMARY KEY (id),
    CONSTRAINT FK_routine_user_id_user_id FOREIGN KEY (user_id) REFERENCES tbl_user (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8mb4 COMMENT '운동 루틴';