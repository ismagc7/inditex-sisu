package com.inditex.sisu;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class PaginationParams implements Serializable
{

    private static final long serialVersionUID = -883379628532594738L;

    private int pageNumber;
    private int pageSize;

    public PaginationParams()
    {
        this.pageNumber = -1;
        this.pageSize = -1;
    }

    public PaginationParams(int pageNumber, int pageSize)
    {
        this();
        this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
    }


    public int getPageNumber()
    {
        return pageNumber;
    }

    public final void setPageNumber(int pageNumber)
    {
        if (0 > pageNumber)
        {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        }
        this.pageNumber = pageNumber;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public final void setPageSize(int pageSize)
    {
        if (0 >= pageSize)
        {
            throw new IllegalArgumentException("Page size must not be less than or equal to zero!");
        }
        this.pageSize = pageSize;
    }

    @JsonIgnore
    public int getOffset()
    {
        return pageNumber * pageSize;
    }

    public boolean hasPrevious()
    {
        return pageNumber > 0;
    }

    public PaginationParams next()
    {
        return new PaginationParams(pageNumber + 1, pageSize);
    }

    public PaginationParams previousOrFirst()
    {
        return hasPrevious() ? new PaginationParams(pageNumber - 1, pageSize) : this;
    }


    public PaginationParams first()
    {
        return new PaginationParams(0, pageSize);
    }


    @JsonIgnore
    public boolean isPaginationValid()
    {
        return this.pageSize > 0 && this.pageNumber >= 0;
    }


    @Override
    public boolean equals(final Object obj)
    {
        boolean result = false;

        if (this == obj)
        {
            result = true;
        } else if (obj instanceof PaginationParams)
        {
            PaginationParams that = (PaginationParams) obj;

            boolean pageEqual = this.pageNumber == that.pageNumber;
            boolean sizeEqual = this.pageSize == that.pageSize;

            result = pageEqual && sizeEqual;
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        int result = 17;

        result = 31 * result + pageNumber;
        result = 31 * result + pageSize;

        return result;
    }


    @Override
    public String toString()
    {
        return String.format("Page request [number: %d, size %d]", pageNumber, pageSize);
    }

}
