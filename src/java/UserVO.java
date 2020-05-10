import java.util.HashMap;
import java.util.Map;

public class UserVO implements Comparable<UserVO> {
    private Long id;

    @Override
    public int compareTo(UserVO other) {
         return Long.compare(this.id, other.id);
    }

    /**
     * 泛型方法
     * @param keys
     * @param values
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> newHashMap(K[] keys, V[] values) {

        // 转化哈希映射
        Map<K, V> map = new HashMap<>();
        int length = Math.min(keys.length, values.length);
        for (int i = 0; i < length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }
}
