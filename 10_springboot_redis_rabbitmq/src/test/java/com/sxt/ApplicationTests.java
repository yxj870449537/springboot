package com.sxt;

import com.sxt.sender.Sender;
import com.sxt.sender.SenderBCD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootTest
class ApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Sender sender;

    @Autowired
    private SenderBCD senderBCD;

    /**
     * redis数据类型为string的操作
     */
    @Test
    public void testString(){
        //操作String类型
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        //给redis里面set，一个key
        operations.set("boot1","springboot1");// k -v 都是String
        //从redis里面获取key
        String value = operations.get("boot1");
        System.out.println(value);
        //从redis里面获取多个key
        List<String> asList = Arrays.asList("k1","k2");
        List<String> mulitValues = operations.multiGet(asList);
        System.out.println(mulitValues);
        //redis的自动增长
        Long increment = operations.increment("k3",3);//dalta可以+任意的数（步长）
        System.out.println(increment);
    }
    @Test
    public void testHash() {
        HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
        // hset
        opsForHash.put("object-1", "name", "sxt"); // 后面的2 个参数都是object,但是只支持String 类型
        opsForHash.put("object-1", "age", "27"); // 后面的2 个参数都是object,但是只支持String 类型
        opsForHash.put("object-1", "sex", "man"); // 后面的2 个参数都是object,但是只支持String 类型
        Object value = opsForHash.get("object-1", "sex");
        System.out.println(value);
        // 取多个值
        List<Object> multiGet = opsForHash.multiGet("object-1", Arrays.asList("name", "sex"));
        System.out.println(multiGet);
    }

    @Test
    public void testZset() {
        ZSetOperations<String, String> opsForZSet = redisTemplate.opsForZSet();
        // 放到zset集合里面
        opsForZSet.add("lol", "sxt", 2500);
        opsForZSet.add("lol", "lz", 0);
        opsForZSet.add("lol", "ln", 1400);
        opsForZSet.add("lol", "ll", -10);
        opsForZSet.add("lol", "lt", 2700);
        Set<String> rangeAsc = opsForZSet.range("lol", 0, 2); // 通过排序取值 ll lz ln
        System.out.println(rangeAsc);
        Set<String> reverseRange = opsForZSet.reverseRange("lol", 0, 2);// lt ltd ln
        System.out.println(reverseRange);
        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<ZSetOperations.TypedTuple<String>>();
        tuples.add(new DefaultTypedTuple<String>("sxt", 1000.00));
        tuples.add(new DefaultTypedTuple<String>("lv", 1200.00));
        tuples.add(new DefaultTypedTuple<String>("lz", 2900.00));
        tuples.add(new DefaultTypedTuple<String>("lt", 100.00));
        // 若redis 存在该key ，则需要数据类型相同，不然报错
        opsForZSet.add("dnf", tuples);
    }

    @Test
    public void testAmqp(){
        senderBCD.senderBCD("你好");
    }

    @Test
    void contextLoads() {
    }

}
