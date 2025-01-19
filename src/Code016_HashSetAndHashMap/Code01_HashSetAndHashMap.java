package Code016_HashSetAndHashMap;

import java.util.HashMap;
import java.util.HashSet;

public class Code01_HashSetAndHashMap {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println(str1 == str2); // false differ memory address

        System.out.println(str1.equals(str2));// true same value

        System.out.println("---------------------------------------------------");

        HashSet<String> set = new HashSet<>();
        set.add(str1);
        System.out.println(set.contains("Hello"));// true
        System.out.println(set.contains(str2));// true
        set.add(str2);
        System.out.println(set.size()); // 1 Collective weight removal

        set.remove(str1);
        set.clear();
        System.out.println(set.isEmpty());
        System.out.println("---------------------------------------------------");

        HashMap<String, String> map1 = new HashMap<>();

        map1.put(str1, "World");
        System.out.println(map1.containsKey("Hello"));// true
        System.out.println(map1.containsKey(str2));// true

        System.out.println(map1.get(str2));// World
        System.out.println(map1.get("你好") == null); // true
        map1.remove("Hello");
        System.out.println(map1.size()); // 0
        map1.clear();
        System.out.println(map1.isEmpty());// true

        System.out.println("---------------------------------------------------");

        HashMap<Integer, Integer> map2 = new HashMap<>();
        map2.put(56, 7285);
        map2.put(34, 3671263);
        map2.put(17, 716311);
        map2.put(24, 1263161);
        // 上面的map2行为，可以被如下数组的行为替代
        int[] arr = new int[100];
        arr[56] = 7285;
        arr[34] = 3671263;
        arr[17] = 716311;
        arr[24] = 1263161;
        // 哈希表的增、删、改、查，都可以被数组替代，前提是key的范围是固定的、可控的
        System.out.println("在笔试场合中哈希表往往会被数组替代, 哈希表的增、删、改、查，都可以被数组替代，前提是key的范围是固定的、可控的");
        Student s1 = new Student(17, "张三");
        Student s2 = new Student(17, "张三");
        HashMap<Student, String> map3 = new HashMap<>();

        // 8个大类型在哈希表中按值来作key 所以值相同就会去重
        // 自定义类型通常根据内存地址来做key

        map3.put(s1, "这是张三");
        System.out.println(map3.containsKey(s1));
        System.out.println(map3.containsKey(s2));
        map3.put(s2, "这是另一个张三");
        System.out.println(map3.size());
        System.out.println(map3.get(s1));
        System.out.println(map3.get(s2));
    }

    public static class Student {
        public int age;
        public String name;

        public Student(int a, String b) {
            age = a;
            name = b;
        }
    }
}
