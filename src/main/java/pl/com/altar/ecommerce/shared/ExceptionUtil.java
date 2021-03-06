package pl.com.altar.ecommerce.shared;

import java.util.Optional;

public class ExceptionUtil {


    public static  <T, R extends RuntimeException> T handleOption(Optional<T> option, R error) {
        return option.orElseThrow(()->error);
    }

}
