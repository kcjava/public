package org.kcjava.mvg.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Base64Wrapper.
 */
public class Base64WrapperTest 
{
    
    Base64Wrapper wrapper = new Base64Wrapper();

    @Test
    public void testEncodeToBase64_nullCheck()
    {        
        assertEquals(null, wrapper.encodeToBase64(null));
    }

    @Test
    public void testEncodeToBase64_happyPath()
    {        
        String value = "hello world!";
        String expected = "61475673624738676432397962475168";        
        String base64 = wrapper.encodeToBase64(value); 
       
        assertEquals(expected, base64);
    }
    
}
