package com.pan.service;

import com.pan.dao.PanFileMapper;
import com.pan.poji.PanFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class PanFileServiceImpl implements PanFileService{

    @Autowired
    PanFileMapper panFileMapper;

    public PanFileMapper getPanFileMapper() {
        return panFileMapper;
    }

    public void setPanFileMapper(PanFileMapper panFileMapper) {
        this.panFileMapper = panFileMapper;
    }


    @Override
    public int upload(PanFile panFile) {
        return panFileMapper.addFile(panFile);
    }

    @Override
    public PanFile download(int id) {
        return panFileMapper.queryById(id);
    }

    @Override
    public List<PanFile> queryByUidAndColid(int uid, int colid) {
        Map map = new HashMap();
        map.put("uid",uid);
        map.put("colid",colid);
        return panFileMapper.queryByUidAndColid(map);
    }

    @Override
    public List<PanFile> queryOpen(Byte open) {
        return panFileMapper.queryByOpen(open);
    }

    @Override
    public List<PanFile> queryByMap(Map map) {
        return panFileMapper.queryByMap(map);
    }

    @Override
    public List<PanFile> queryByUid(int uid) {
        return panFileMapper.queryByUid(uid);
    }

    @Override
    public List<PanFile> queryInIds(List list) {
        return panFileMapper.queryInIds(list);
    }

    @Override
    public int delById(int id) {
        return panFileMapper.delById(id);
    }

    @Override
    public int delInIds(List list) {
        return panFileMapper.delInIds(list);
    }

    @Override
    public int updateCount(Map map) {

        return panFileMapper.updateById(map);
    }
}
