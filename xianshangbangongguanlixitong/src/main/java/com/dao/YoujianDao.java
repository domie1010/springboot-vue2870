package com.dao;

import com.entity.YoujianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YoujianView;

/**
 * 邮件 Dao 接口
 *
 * @author 
 */
public interface YoujianDao extends BaseMapper<YoujianEntity> {

   List<YoujianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
