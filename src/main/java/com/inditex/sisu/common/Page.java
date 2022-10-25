package com.inditex.sisu.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inditex.sisu.PaginationParams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Page<T> implements Serializable
{
    private static final long serialVersionUID = -1084660139220343310L;

    private final List<T> content = new ArrayList<>(); // NOSONAR
    private PaginationParams pagination;
    private SortParams sort;
    private long total;


    public Page() {}

    @JsonCreator
    public Page(@JsonProperty("content") List<T> content, @JsonProperty("pagination") PaginationParams pagination,
                @JsonProperty("sort") SortParams sort, @JsonProperty("total") long total)
    {
        if (null == content)
        {
            throw new IllegalArgumentException("Content must not be null!");
        }

        this.content.addAll(content);
        this.pagination = pagination;
        this.sort = sort;
        this.total = total >= 0 && total >= this.content.size() ? total : this.content.size();
    }


    public Page(List<T> content, PaginationParams pagination, long total)
    {
        this(content, pagination, null, total);
    }


    public Page(List<T> content, long pageSize, long total)
    {
        this(content, new PaginationParams(0, (int) pageSize), null, total);
    }


    public Page(List<T> content)
    {
        this(content, null, null, null == content ? 0 : content.size());
    }


    @JsonIgnore
    public int getNumber()
    {
        return pagination == null ? 0 : pagination.getPageNumber();
    }


    @JsonIgnore
    public int getSize()
    {
        return pagination == null ? 0 : pagination.getPageSize();
    }


    @JsonIgnore
    public int getTotalPages()
    {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }


    @JsonIgnore
    public int getNumberOfElements()
    {
        return content.size();
    }


    @JsonProperty("total")
    public long getTotalElements()
    {
        return total;
    }


    public boolean hasPreviousPage()
    {
        return getNumber() > 0;
    }


    @JsonIgnore
    public boolean isFirstPage()
    {
        return !hasPreviousPage();
    }


    public boolean hasNextPage()
    {
        return getNumber() + 1 < getTotalPages();
    }

    @JsonIgnore
    public boolean isLastPage()
    {
        return !hasNextPage();
    }


    public PaginationParams nextPagination()
    {
        return hasNextPage() ? pagination.next() : null;
    }


    public PaginationParams previousPagination()
    {
        PaginationParams result = null;

        if (hasPreviousPage())
        {
            result = pagination.previousOrFirst();
        }

        return result;
    }


    public Iterator<T> iterator()
    {
        return content.iterator();
    }


    public List<T> getContent()
    {
        return Collections.unmodifiableList(content);
    }


    public boolean hasContent()
    {
        return !content.isEmpty();
    }


    @JsonProperty("pagination")
    public PaginationParams getPagination()
    {
        return pagination;
    }

    public void setPagination(PaginationParams p)
    {
        this.pagination = p;
    }


    public SortParams getSort()
    {
        return this.sort;
    }


    @Override
    public String toString()
    {

        String result = "UNKNOWN";

        if (!content.isEmpty())
        {
            String contentType = content.get(0).getClass().getName();
            result = String.format("Page %d of %d containing %s instances and sorted by %s", getNumber(),
                    getTotalPages(), contentType, getSort());
        }

        return result;
    }


    @Override
    public boolean equals(Object obj)
    {

        boolean result = false;
        if (this == obj)
        {
            result = true;
        } else if (obj instanceof Page<?>)
        {
            Page<?> that = (Page<?>) obj;

            boolean totalEqual = this.total == that.total;
            boolean contentEqual = this.content.equals(that.content);
            boolean pageableEqual = this.pagination == null ? that.pagination == null
                    : this.pagination.equals(that.pagination);
            boolean sortEqual = this.sort == null ? that.sort == null : this.sort.equals(that.sort);

            result = totalEqual && contentEqual && pageableEqual && sortEqual;
        }

        return result;

    }


    @Override
    public int hashCode()
    {

        int result = 17;

        result = 31 * result + (int) (total ^ total >>> 32);
        result = 31 * result + (pagination == null ? 0 : pagination.hashCode());
        result = 31 * result + (sort == null ? 0 : sort.hashCode());
        result = 31 * result + content.hashCode();

        return result;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }
}
