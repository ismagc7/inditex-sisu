package com.inditex.sisu.common;

import org.springframework.data.domain.Pageable;

public class QueryUtils {


    private QueryUtils()
    {
    }

    public static void addPaginationQuery(Pageable pageable, StringBuilder query)
    {
        query.append(GenericConstants.SQL_OFFSET);
        query.append(pageable.getPageNumber()* pageable.getPageSize());
        query.append(GenericConstants.SQL_ROWS_FETCH_NEXT);
        query.append(pageable.getPageSize());
        query.append(GenericConstants.SQL_ROWS_ONLY);
    }


    public static void addSortedQuery(String sortColumn, String sortDirection, StringBuilder query)
    {
        query.append(GenericConstants.SQL_ORDER_BY);
        query.append(sortColumn);
        query.append(' ');
        query.append(sortDirection);
    }

    public static String getSortByPageable(Pageable pageable)
    {
        return pageable.getSort().isSorted() ? pageable.getSort().get().findFirst().get().getProperty() : null;
    }

    public static String getSortDirectionByPageable(Pageable pageable)
    {
        return pageable.getSort().isSorted() ? pageable.getSort().get().findFirst().get().getDirection().toString() : null;
    }
}
