package org.itstack.demo.test;

import org.itstack.demo.model.Car;
import org.itstack.demo.model.Person;
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

    @Test
    public void test() {
        KieServices kieServices = KieServices.Factory.get();
        //默认自动加载 META-INF/kmodule.xml
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        Person p1 = new Person();
        p1.setAge(20);
        Car car = new Car();
        car.setPerson(p1);

        kieSession.insert(car);

        int count = kieSession.fireAllRules();

        System.out.println(count);
        System.out.println(car.getDiscount());

        kieSession.dispose();
    }

}
