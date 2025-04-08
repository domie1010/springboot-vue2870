package com.dao;

import com.entity.BumenrenmingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BumenrenmingView;

/**
 * 部门任命 Dao 接口
 *
 * @author 
 */
public interface BumenrenmingDao extends BaseMapper<BumenrenmingEntity> {

   List<BumenrenmingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
