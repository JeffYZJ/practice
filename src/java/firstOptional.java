import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class firstOptional {
    public static final Integer DEFAULT_VALUE = 100;
    public static final Integer MAX_VALUE = 999;

    public static void main(String[] args) {


        optionalOne(50);
        optionalTwo(1000);
    }


    /**
     * 保证值合法
     * @param i
     */
    private static void optionalTwo(Integer value) {
        int thisValue = Optional.ofNullable(value).filter(tempValue -> tempValue.compareTo(MAX_VALUE) <= 0).orElse(DEFAULT_VALUE);
        System.out.println(thisValue);

    }

    /**
     * 保证值存在
     * @param value
     */
    private static void optionalOne(Integer value) {
        int thisValue = Optional.ofNullable(value).orElse(DEFAULT_VALUE);
        System.out.println(thisValue);
    }

}
