package org.kcjava.mvg.core;

import org.apache.commons.codec.binary.Base64;

/**
 * This class is a relatively useless wrapper around the Base64 class.
 */
public class Base64Wrapper
{
    
    /**
     * Encodes the given value to base 64
     * @param value The value to encode in base 64
     * @return The base 64 encoded output
     */
    public String encodeToBase64(String value)
    {
        if(value == null) {
            return null;
        }
        return Base64.encodeBase64URLSafeString(value.getBytes());
    }
}
