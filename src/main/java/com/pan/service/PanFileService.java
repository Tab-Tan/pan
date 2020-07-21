package com.pan.service;

import com.pan.poji.PanFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface PanFileService {

    //上传
    int upload(PanFile panFile);

    //下载
    PanFile download(int id);

    //查询
    List<PanFile> queryByUidAndColid(int uid,int colid);

    List<PanFile> queryOpen(Byte open);

    List<PanFile> queryByMap(Map map);

    List<PanFile> queryByUid(int uid);

    List<PanFile> queryInIds(List list);

    //删除
    int delById(@Param("id") int id);

    int delInIds(List list);

    //修改
    int updateCount(Map map);



}
