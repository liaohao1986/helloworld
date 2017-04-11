/**
 * 
 */
package com.huoli.checkin.design.spring.ioc;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月5日<br>
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

    /**
     * 存储各个实例的键值对
     */
    private Map<String, Object> beans = new HashMap<String, Object>();

    /**
     * 构造方法
     * @throws Exception
     */
    public ClassPathXmlApplicationContext() throws Exception {
        SAXBuilder sb = new SAXBuilder(); //读取XML文件new ClassPathResource("config/CA.json").getFile()
        Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("app-bean.xml"));
        Element root = doc.getRootElement();
        List<Element> list = root.getChildren("bean");
        for (int i = 0; i < list.size(); i++) {
            Element element = (Element) list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            //利用反射生成类的对象，并保存到beans中
            Object o = Class.forName(clazz).newInstance();
            beans.put(id, o);
            //对第i个bean元素下的每个property子元素进行遍历
            for (Element propertyElement : (List<Element>) element.getChildren("property")) {
                String name = propertyElement.getAttributeValue("name");
                String beanInstance = propertyElement.getAttributeValue("bean");
                Object beanObject = beans.get(beanInstance); //取得被注入的实例
                //获得相应属性的set方法名，形式为setXxx
                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                System.out.println("method name = " + methodName);
                //使用反射取得指定名称，指定参数类型的setXxx方法
                Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
                m.invoke(o, beanObject); //调用对象o的setXxx方法

            }
        }
    }

    /* 获取bean实例
     * (non-Javadoc)
     * @see com.deciphering.Spring.BeanFactory#getBean(java.lang.String)
     */
    @Override
    public Object getBean(String id) {
        return beans.get(id);
    }

}
