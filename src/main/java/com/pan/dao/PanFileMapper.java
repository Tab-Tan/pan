package com.pan.dao;

import com.pan.poji.PanFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface PanFileMapper {

    /**
     *增加文件
     */

    int addFile(PanFile panFile);

    /**
     * 删除文件
     */
    int delById(@Param("id") int id);

    int delInIds(List list);

    int delByName(@Param("fname") String fname);

    /**
     * 修改文件
     */

    int updateById(Map map);

    int updateByUsername(Map map);

    /**
     * 查找文件
     */

    PanFile queryById(@Param("id") int id);

    List<PanFile> queryInIds(List list);

    List<PanFile> queryByUid(@Param("uid") int uid);

    List<PanFile> queryByColid(@Param("colid") int colid);

    List<PanFile> queryByUidAndColid(Map map);

    List<PanFile> queryByOpen(@Param("open") Byte open);

    List<PanFile> queryByUidAndOpen(Map map);

    List<PanFile> queryByMap(Map map);

}
