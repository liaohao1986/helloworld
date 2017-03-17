/**
 * 
 */
package com.huoli.checkin.design.pattern.spring;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月17日<br>
 */
public class MyClassPathXmlApplicationContext {

    private List<BeanDefinition> beanDefines = new ArrayList<BeanDefinition>();
    private Map<String, Object> sigletons = new HashMap<String, Object>();

    public MyClassPathXmlApplicationContext(String filename) {
        this.readXml(filename);
        this.instanceBeans();
    }

    /**
     * 读取xml配置文件
     * @param filename
     */
    @SuppressWarnings("unchecked")
    public void readXml(String filename) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            URL xmlpath = this.getClass().getClassLoader().getResource(filename);
            document = saxReader.read(xmlpath);
            Map<String, String> nsMap = new HashMap<String, String>();
            nsMap.put("ns", "http://www.springframework.org/schema/beans");//加入命名空间
            XPath xsub = document.createXPath("//ns:beans/ns:bean");//创建beans/bean查询路径
            xsub.setNamespaceURIs(nsMap);//设置命名空间
            List<Element> beans = xsub.selectNodes(document);//获取文档下所有bean节点
            for (Element element : beans) {
                String id = element.attributeValue("id");//获取id属性值
                String clazz = element.attributeValue("class"); //获取class属性值        
                BeanDefinition beanDefine = new BeanDefinition(id, clazz);
                beanDefines.add(beanDefine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 完成bean的实例化
     */
    private void instanceBeans() {
        for (BeanDefinition beanDefinition : beanDefines) {
            try {
                if (beanDefinition.getClassName() != null && !"".equals(beanDefinition.getClassName().trim()))
                    sigletons.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassName()).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取bean实例
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        return this.sigletons.get(beanName);
    }

}
