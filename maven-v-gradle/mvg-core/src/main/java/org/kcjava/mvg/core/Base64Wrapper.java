package org.kcjava.mvg.core;

import org.apache.commons.codec.binary.Base64;

/**
 * This class is a relatively useless wrapper around the Base64 class.
 */
public class Base64Wrapper {

    final protected static char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * Encodes the given value to base 64, and returns the
     * hexidecimal string that represents the output
     *
     * @param value The value to encode in base 64
     * @return The base 64 encoded output
     */
    public String encodeToBase64(String value) {
        if (value == null) {
            return null;
        }
        return bytesToHex(Base64.encodeBase64(value.getBytes()));
    }

    /**
     * Returns a hexidecimal string of the given bytes
     * @param bytes The bytes to output as hex
     * @return The generated hex string
     */
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

}
