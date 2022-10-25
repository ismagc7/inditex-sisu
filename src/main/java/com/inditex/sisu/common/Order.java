package com.inditex.sisu.common;

import java.io.Serializable;

public class Order implements Serializable
{
    private static final long serialVersionUID = 1431375908539326402L;
    private static final int PRIME = 31;

    /**
     * Default sort direction
     */
    public static final SortParams.SortDirection DEFAULT_SORT_DIRECTION = SortParams.SortDirection.ASC;

    private String property;
    private SortParams.SortDirection direction;

    /**
     * Default constructor
     */
    public Order()
    {
        this.direction = DEFAULT_SORT_DIRECTION;
    }


    public Order(String property, SortParams.SortDirection direction)
    {
        this();
        this.property = property;
        this.direction = direction;
    }


    public String getProperty()
    {
        return property;
    }


    public void setProperty(String property)
    {
        if (property == null || property.isEmpty())
        {
            throw new IllegalArgumentException("Property must not be null or empty!");
        }
        this.property = property;
    }


    public SortParams.SortDirection getDirection()
    {
        return direction;
    }


    public void setDirection(SortParams.SortDirection direction)
    {
        this.direction = direction == null ? DEFAULT_SORT_DIRECTION : direction;
    }

    @Override
    public int hashCode()
    {
        int result = 1;
        result = PRIME * result + ((property == null) ? 0 : property.hashCode());
        result = PRIME * result + direction.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object other)
    {
        boolean result = true;
        if (this != other)
        {
            if (other == null || getClass() != other.getClass())
            {
                result = false;
            } else
            {
                Order that = (Order) other;

                if ((property == null ? that.property != null : !property.equals(that.property))
                        || direction != that.direction)
                {
                    result = false;
                }
            }
        }

        return result;
    }

    @Override
    public String toString()
    {
        return "Order '" + property + "': " + direction;
    }

}
