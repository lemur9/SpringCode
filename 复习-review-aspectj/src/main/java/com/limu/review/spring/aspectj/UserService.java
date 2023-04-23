package com.limu.review.spring.aspectj;

import com.limu.review.spring.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void insert() {
        System.out.println("执行了插入操作");
    }

    public int update(int i) {
        System.out.println("修改了" + i + "条数据");
        return i;
    }

    public int delete() {
        System.out.println("执行了删除操作");
        return 1;
    }

    @Async
    public void select() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("执行了查询操作");
    }

}
