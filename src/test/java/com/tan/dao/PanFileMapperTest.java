package com.tan.dao;

import com.pan.dao.PanFileMapper;
import com.pan.poji.PanFile;
import com.pan.service.PanFileService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class PanFileMapperTest {

    @Test
    public void testQuery(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        PanFileMapper panFileMapper = (PanFileMapper) ac.getBean("panFileMapper");
        //queryByUid
//        List<PanFile> panFiles = panFileMapper.queryByUid(12);
        //queryByColid
//        List<PanFile> panFiles1 = panFileMapper.queryByColid(1);
        //queryByOpen
        List<PanFile> panFiles = panFileMapper.queryByOpen((byte) 1);


    }

    @Test
    public void testDelInIds(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        PanFileMapper panFileMapper = (PanFileMapper) ac.getBean("panFileMapper");

        List list = new ArrayList();

        list.add(11);
        list.add(12);
        panFileMapper.delInIds(list);
    }

    @Test
    public void testQueryInIds(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        PanFileMapper panFileMapper = (PanFileMapper) ac.getBean("panFileMapper");

        List list = new ArrayList();

        list.add(22);
        list.add(23);
        panFileMapper.queryInIds(list);

    }
    @Test
    public void testUpdataById(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        PanFileMapper panFileMapper = (PanFileMapper) ac.getBean("panFileMapper");
        Map map = new HashMap<>();
        map.put("count",4);
        map.put("id",38);
        panFileMapper.updateById(map);
    }

}
