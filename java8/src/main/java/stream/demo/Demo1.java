package stream.demo;

import org.junit.Before;
import org.junit.Test;
import stream.entity.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huan.xu
 * @Date 2020-11-26
 */
public class Demo1 {

    private List<Map> dataMapList = new ArrayList<>();
    private List<User> dataUserList = new ArrayList<>();

    /**
     * 组装测试数据
     */
    @Before
    @Test
    public void initData() {
        Map map1 = new HashMap();
        map1.put("id", 1);
        map1.put("name", "name1");
        map1.put("age", 1);
        dataMapList.add(map1);

        Map map3 = new HashMap();
        map3.put("id", 3);
        map3.put("name", "name3");
        map3.put("age", 3);
        dataMapList.add(map3);

        Map map2 = new HashMap();
        map2.put("id", 2);
        map2.put("name", "name2");
        map2.put("age", 2);
        dataMapList.add(map2);

        Map map4 = new HashMap();
        map4.put("id", 4);
        map4.put("name", null);
        map4.put("age", 4);
        dataMapList.add(map4);

        dataUserList.add(new User(1, "name1", 1));
        dataUserList.add(new User(3, "name3", 3));
        dataUserList.add(new User(2, "name2", 2));
        dataUserList.add(new User(4, null, 4));
        dataUserList.add(new User(5, "name5", 5));

    }

    /**
     * 测试forEach
     */
    @Test
    public void testForEach() {
        System.out.println("循环List<Map>:");
        dataMapList.stream().forEach(m -> {
            System.out.println(m.get("name"));
        });

        System.out.println("循环List<User> 方式一：");
        dataUserList.stream().forEach(user -> {
            System.out.println(user.getName());
        });

        System.out.println("循环List<User> 方式二：");
        dataUserList.stream().map(User::getName).forEach(System.out::println);
    }

    /**
     * 测试map
     */
    @Test
    public void testMap() {
        String mapNames = dataMapList.stream().map(m -> (String) m.get("name")).collect(Collectors.joining(","));
        System.out.println("逗号组装List<Map>中的name属性：" + mapNames);

        String userNames = dataUserList.stream().map(User::getName).collect(Collectors.joining(","));
        System.out.println("逗号组装List<User>中的name属性，方式一：" + userNames);

        String userNames2 = dataUserList.stream().map(user -> {
            return user.getName();
        }).collect(Collectors.joining(","));
        System.out.println("逗号组装List<User>中的name属性，方式二：" + userNames2);
    }

    /**
     * 测试filter
     */
    @Test
    public void testFilter() {
        String mapNames = dataMapList.stream()
                .filter(map -> {
                    int age = (int) map.get("age");
                    return age > 2;
                })
                .map(map -> (String) map.get("name"))
                .collect(Collectors.joining(","));
        System.out.println("逗号组装List<Map>中的name属性：" + mapNames);

        String userNames = dataUserList.stream()
                .filter(user -> {
                    return user.getAge() > 2;
                })
                .map(User::getName)
                .collect(Collectors.joining(","));
        System.out.println("逗号组装List<User>中的name属性：" + userNames);
    }

    /**
     * 测试limit
     */
    @Test
    public void testLimit() {
        dataMapList.stream().limit(2).forEach(map -> {
            System.out.println(map.get("name"));
        });

        dataUserList.stream().limit(2).forEach(user -> {
            System.out.println(user.getName());
        });
    }

    /**
     * 测试sorted
     */
    @Test
    public void testSorted() {
        String mapNamesAsc = dataMapList.stream()
                .filter(map -> {
                    String name = (String) map.get("name");
                    if (name == null) {
                        return false;
                    }
                    return !name.isEmpty();
                })
                .sorted(Comparator.comparing(map -> (int) map.get("id")))
                .map(map -> (String) map.get("name"))
                .collect(Collectors.joining(","));
        System.out.println("升序排列List<Map>:" + mapNamesAsc);

        //暂时没有找到List<Map>怎么用stream倒序，因此采用下面这种方式实现
        Collections.sort(dataMapList, new Comparator<Map>() {
            @Override
            public int compare(Map o1, Map o2) {
                int age1 = (int) o1.get("age");
                int age2 = (int) o2.get("age");
                if (age1 > age2) {
                    return -1;
                } else if (age1 < age2) {
                    return 1;
                }
                return 0;
            }
        });
        String mapNamesDesc = dataMapList.stream()
                .filter(map -> {
                    String name = (String) map.get("name");
                    if (name == null) {
                        return false;
                    }
                    return !name.isEmpty();
                })
                .map(map -> (String) map.get("name"))
                .collect(Collectors.joining(","));
        System.out.println("降序排列List<Map>:" + mapNamesDesc);

        String userNamesAsc = dataUserList.stream()
                .filter(user -> {
                    String name = user.getName();
                    if (name == null) {
                        return false;
                    }
                    return !name.isEmpty();
                })
                .sorted(Comparator.comparing(User::getName))
                .map(User::getName)
                .collect(Collectors.joining(","));
        System.out.println("升序排列List<User>:" + userNamesAsc);

        String userNamesDesc = dataUserList.stream()
                .filter(user -> {
                    String name = user.getName();
                    if (name == null) {
                        return false;
                    }
                    return !name.isEmpty();
                })
                .sorted(Comparator.comparing(User::getName).reversed())
                .map(User::getName)
                .collect(Collectors.joining(","));
        System.out.println("降序排列List<User>:" + userNamesDesc);
    }

}
