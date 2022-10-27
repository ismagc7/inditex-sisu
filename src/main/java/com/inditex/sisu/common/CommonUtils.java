package com.inditex.sisu.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Getter
@Component
public class CommonUtils<T>
{
    @Value("60")
    private int listLimitSize;

    public PageRequest buildPageRequest()
    {
        return PageRequest.of(0, listLimitSize);
    }

    public JSONResult<Page<T>> returnResult(Page<T> list)
    {
        return new JSONResult<>(list);
    }

    public static < T > void updateField ( Consumer < T > target , T sourceField ) {
        if ( sourceField != null ) {
            target.accept ( sourceField ) ;
        }
    }

}