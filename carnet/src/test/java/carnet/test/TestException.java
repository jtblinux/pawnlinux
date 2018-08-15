package carnet.test;

import org.junit.Test;

import carnet.exception.UsernameNotFoundException;

public class TestException {
     @Test
     public void testUsernameNotFoundException() {
    	 UsernameNotFoundException unfe=new UsernameNotFoundException("用户名不存在");
    	 System.out.println(unfe.getMessage());
     }
}
