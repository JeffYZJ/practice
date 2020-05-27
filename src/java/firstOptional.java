


import dto.UserDTO;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class firstOptional {
    public static final Integer DEFAULT_VALUE = 100;
    public static final Integer MAX_VALUE = 999;

    public static void main(String[] args) {


        optionalOne(null);
        optionalTwo(null);
        optionalThree();

    }

    /**
     * 结合DTO使用
     */
    private static void optionalThree() {
        UserDTO userDTO1 = new UserDTO("yinzijian", "qwe123", 1L);
        UserDTO userDTO2 = new UserDTO("shijiawei", "qwe123", 2L);
        UserDTO dto = Optional.ofNullable(userDTO1)
                .orElse(userDTO2)
                ;
        Optional<UserDTO> userDTOOptional = Optional.ofNullable(userDTO1)
                .filter(u -> u.getUserCode() != null);
        if (userDTOOptional.isPresent()){
            userDTOOptional.get();
        }
    }


    /**
     * 保证值合法
     * @param value
     */
    private static void optionalTwo(Integer value) {
        int thisValue = Optional.ofNullable(value).filter(tempValue -> tempValue.compareTo(MAX_VALUE) <= 0).orElse(DEFAULT_VALUE);
        System.out.println(thisValue);

    }

    /**
     * 保证值存在
     * @param value
     */
    @Test
    private static void optionalOne(Integer value) {
        int thisValue = Optional.ofNullable(value).orElse(DEFAULT_VALUE);
        System.out.println(thisValue);
    }

}
