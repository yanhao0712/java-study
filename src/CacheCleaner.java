import java.util.*;

public class CacheCleaner {
    public static void main(String[] args) {
        // 1. 初始化缓存数据
        Map<String, Integer> cache = new HashMap<>();
        cache.put("https://www.google.com", 100);
        cache.put("https://www.baidu.com", 2);    // 虽然次数少，但在白名单
        cache.put("https://www.badsite.com", 1);  // 次数少，不在白名单，必删
        cache.put("https://www.news.com", 20);
        cache.put("https://www.junk.com", 3);    // 必删

        // 2. 白名单
        List<String> whiteList = Arrays.asList("google", "baidu");

        System.out.println("清理前缓存大小: " + cache.size());

        // --- 你的练习点：在此处编写逻辑 ---
        // 提示：使用 cache.entrySet().iterator()
       Iterator <Map.Entry<String,Integer>> it = cache.entrySet().iterator();
        // 逻辑伪代码：
        // 获取迭代器 -> while循环 -> 获取每一个 Entry -> 判断条件 -> it.remove()
        while (it.hasNext()) {
            Map.Entry<String,Integer> entry = it.next();
            String key = entry.getKey();
            int value = entry.getValue();
            boolean inWhiteList = false;
            for (String str : whiteList) {
                if (key.contains(str)) {
                    inWhiteList = true;
                    break;
                }
            }
            if (!inWhiteList && value < 5) {
                it.remove();
            }
        }

        // --- 练习结束 ---

        System.out.println("清理后剩余缓存: " + cache);
    }
}