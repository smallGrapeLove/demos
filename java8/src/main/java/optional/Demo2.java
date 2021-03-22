package optional;

import optional.entity2.Address;
import optional.entity2.Country;
import optional.entity2.User;
import org.junit.Test;

import java.util.Optional;

/**
 * @author huan.xu
 * @Date 2020-11-20
 */
public class Demo2 {

    @Test
    public void testCode1(){
        User user=new User();
        String defaultStr = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getCountry)
                .map(Country::getIsocode)
                .orElse("default");
        System.out.println(defaultStr);
    }

    @Test
    public void testCode2(){
        User user=new User();
        String defaultStr = Optional.ofNullable(user)
                .flatMap(u -> Optional.ofNullable(u.getAddress()))
                .flatMap(a -> Optional.ofNullable(a.getCountry()))
                .flatMap(c -> Optional.ofNullable(c.getIsocode()))
                .orElse("default");
        System.out.println(defaultStr);
    }
}
