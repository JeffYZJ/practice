import dto.UserDTO;

import java.lang.reflect.Array;
import java.util.*;
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
        labmbdSort();
    }
    private static void labmbdSort() {
        List<Integer> l = new ArrayList();
        l.add(3);
        l.add(2);
        l.add(5);
        l.add(1);
        Integer num = l.stream().sorted((l1,l2) ->
                l1.compareTo(l2)
        ).findFirst().get();
//        System.out.println(num);
        //降序
        l.stream().sorted((l1,l2) -> l2.compareTo(l1)).collect(Collectors.toList()).forEach(num2 -> System.out.println(num2));
    }

    private static void labmbdGetArea(Double[] radioArray) {
        List<Double> radioList = Arrays.asList(radioArray);
        radioList.stream()
                .map(r -> PI * pow(r, 2))
                .collect(toList())
                .forEach(d -> System.out.println("面积依次是:"+d));

    }

    private static void labmbdUserDto() {
        UserDTO userDTO1 = new UserDTO("yinzijian", "qwe123", 1L);
        UserDTO userDTO2 = new UserDTO("shijiawei", "qwe123", 2L);
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.sort((a,b) -> a.getUserCode().compareTo(b.getUserCode()));
        userDTOList.add(userDTO1);
        userDTOList.add(userDTO2);
        userDTOList.stream()
                .map(user -> user.getUserId())
                .collect(Collectors.toList())
                .forEach(id -> System.out.println(id));
        Map<String,List<UserDTO>> listMap = userDTOList.stream().collect(Collectors.groupingBy(UserDTO :: getUserCode,
                TreeMap::new,Collectors.toList()));


    }

    private static void lambdaArray(String[] strArray) {

        Arrays.sort(strArray, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println(Arrays.toString(strArray));

    }

    private static void lambdaThread(String threadName) {
        new Thread(() ->{
            System.out.println("线程名字："+ threadName);
        }).start();
    }
}
