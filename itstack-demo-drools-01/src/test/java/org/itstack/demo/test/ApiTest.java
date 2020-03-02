package org.itstack.demo.test;

import org.itstack.demo.model.User;
import org.itstack.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * 博  客：http://bugstack.cn
 * Create by 小傅哥 on @2020
 */
public class ApiTest {

    private KieContainer kieContainer;

    @Before
    public void init() {
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.getKieClasspathContainer();
    }

    @Test
    public void doRun() {
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        User user = new User();
        user.setSex("男");
        user.setAge(30);

        kieSession.insert(user);
        UserService userService = new UserService();
        kieSession.setGlobal("userService", userService);
        int count = kieSession.fireAllRules();

        System.out.println("Fire rule(s)：" + count);
        System.out.println("Fire result：" + userService.result());

        kieSession.dispose();
    }

}
