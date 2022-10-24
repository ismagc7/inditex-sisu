package com.inditex.sisu.common;

public class JSONResult<T> {
    protected Boolean success;
    protected Integer errorCode;
    protected String message;
    protected T response;


    public JSONResult()
    {
        this(Boolean.FALSE, null, null, null);
    }


    public JSONResult(boolean success)
    {
        this(success, null, null, (T) (Boolean) success);
    }


    public JSONResult(Boolean success, String message)
    {
        this(success, null, message, null);
    }


    public JSONResult(T result)
    {
        this(Boolean.TRUE, null, null, result);
    }

    public JSONResult(Integer errorCode, String message)
    {
        this(Boolean.FALSE, errorCode, message, null);
    }

    public JSONResult(Boolean success, Integer errorCode, String message, T response)
    {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.response = response;
    }

    public Boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }


    public Integer getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode)
    {
        this.errorCode = errorCode;
    }

    public T getResponse()
    {
        return response;
    }

    public void setResponse(T response)
    {
        this.response = response;
    }


    public String getMessage()
    {
        return message;
    }


    public void setMessage(String message)
    {
        this.message = message;
    }
}
