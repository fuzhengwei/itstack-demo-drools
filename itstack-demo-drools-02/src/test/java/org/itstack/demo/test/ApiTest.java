package org.itstack.demo.test;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.Result;
import org.itstack.demo.model.Policy;
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
    private Policy policy;

    @Before
    public void init() {
        KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.getKieClasspathContainer();

        policy = new Policy();
        policy.setSex("男");
        policy.setAge(16);
        policy.setUserSingle(false);
        policy.setUserMarry(false);
        policy.setUserParenting(false);
        System.out.println("决策请求：" + JSON.toJSONString(policy));
    }

    @Test
    public void test_ifelse() {
        Result result = null;
        if ("男".equals(policy.getSex())) {
            if (policy.getAge() < 18) {
                if (policy.getUserSingle()) {
                    result = Result.buildResult("A", "红色A");
                } else {
                    result = Result.buildResult("B", "红色B");
                }
            } else if (policy.getAge() >= 18 && policy.getAge() <= 30) {
                if (policy.getUserMarry()) {
                    result = Result.buildResult("C", "红色C");
                } else {
                    result = Result.buildResult("D", "红色D");
                }
            } else if (policy.getAge() > 30) {
                if (policy.getUserParenting()) {
                    result = Result.buildResult("E", "红色E");
                } else {
                    result = Result.buildResult("F", "红色F");
                }
            }
        } else if ("女".equals(policy.getSex())) {
            if (policy.getAge() < 18) {
                if (policy.getUserSingle()) {
                    result = Result.buildResult("A", "黄色A");
                } else {
                    result = Result.buildResult("B", "黄色B");
                }
            } else if (policy.getAge() >= 18 && policy.getAge() <= 30) {
                if (policy.getUserMarry()) {
                    result = Result.buildResult("C", "黄色C");
                } else {
                    result = Result.buildResult("D", "黄色D");
                }
            } else if (policy.getAge() > 30) {
                if (policy.getUserParenting()) {
                    result = Result.buildResult("E", "黄色E");
                } else {
                    result = Result.buildResult("F", "黄色F");
                }
            }
        }

        System.out.println("决策结果(IfElse)：" + result);
    }

    @Test
    public void test_drools() {
        KieSession kieSession = kieContainer.newKieSession("all-rules");
        kieSession.insert(policy);
        Result result = new Result();
        kieSession.setGlobal("res", result);
        int count = kieSession.fireAllRules();

        System.out.println("Fire rule(s)：" + count);
        System.out.println("决策结果(Drools)：" + result);

        kieSession.dispose();
    }

    @Test
    public void test_if() {
        if (true) {
            if (true) {
                if (true) {
                    if (true) {
                        if (true) {
                            if (true) {
                                if (true) {
                                    if (true) {
                                        if (true) {
                                            if (true) {
                                                if (true) {
                                                    if (true) {
                                                        if (true) {
                                                            if (true) {
                                                                if (true) {
                                                                    if (true) {
                                                                        System.out.println(true);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
