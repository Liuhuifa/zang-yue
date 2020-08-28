package com.zy.common.zangyuecommon.exception;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/24 15:47
 */
public class ExcelExportException extends Exception{

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ExcelExportException(String message) {
        super(message);
    }
}
