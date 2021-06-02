package kr.unlike.tabatime.dto.response;

import java.util.List;

public interface BaseResponse<E, T> {
    E of(T t);
    List<E> of(List<T> list);
}
