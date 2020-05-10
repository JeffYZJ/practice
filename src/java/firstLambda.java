import dto.UserDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.util.stream.Collectors.toList;

/**
 * 练习使用下Lambda表达式
 */
public class firstLambda {
    public static void main(String[] args) {
        String threadName = "appserver-thread";
        String[] strArray = new String[]{"尹子健", "史佳伟", "张晓阳"};
        Double[] radioArray = new Double[]{1d, 2d, 3d};

        lambdaThread(threadName);
        lambdaArray(strArray);
        labmbdUserDto();
        labmbdGetArea(radioArray);
        labmbdAnyMatch();
    }
    private static void labmbdAnyMatch() {
        List<String> list = Arrays.asList("aaa","bbb","ccc");
        boolean isFound = list.stream().anyMatch(tempStr -> tempStr.indexOf("a") > -1);
        System.out.println(isFound);
    }
    private static void labmbdGetArea(Double[] radioArray) {
        List<Double> radioList = Arrays.asList(radioArray);
        radioList.stream()
                .map(r -> PI * pow(r, 2))
                .collect(toList())
                .forEach(d -> System.out.println("面积依次是:"+d));

    }

    /**
     * labmbd集合处理
     */
    private static void labmbdUserDto() {
        UserDTO userDTO1 = new UserDTO("yinzijian", "qwe123", 1L);
        UserDTO userDTO2 = new UserDTO("shijiawei", "qwe123", 2L);
        List<UserDTO> userDTOList = new ArrayList<>();
//        paraMap.computeIfAbsent(configId, key -> new ArrayList<FIApprovalParaService>()).add(paraValue);
        userDTOList.add(userDTO1);
        userDTOList.add(userDTO2);
        userDTOList.stream()
                .map(user -> user.getUserId())
                .filter(tempStr -> tempStr.equals("123"))
                .collect(Collectors.toList())
                .forEach(id -> System.out.println(id));
    }

    /**
     * lambda表达式排序
     * @param strArray
     */
    private static void lambdaArray(String[] strArray) {
        Arrays.sort(strArray, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println(Arrays.toString(strArray));

    }

    /**
     * lambda表达式线程
     * @param threadName
     */
    private static void lambdaThread(String threadName) {
        new Thread(() ->{
            System.out.println("线程名字："+ threadName);
        }).start();
    }
}
