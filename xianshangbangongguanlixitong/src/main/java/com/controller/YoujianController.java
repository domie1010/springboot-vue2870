
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.YonghuEntity;
import com.entity.YoujianEntity;
import com.entity.view.YoujianView;
import com.service.DictionaryService;
import com.service.TokenService;
import com.service.YonghuService;
import com.service.YoujianService;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 邮件
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/youjian")
public class YoujianController {
    private static final Logger logger = LoggerFactory.getLogger(YoujianController.class);

    @Autowired
    private YoujianService youjianService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("维修人员".equals(role))
            params.put("weixiurenyuanId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
            params.put("username",request.getSession().getAttribute("username"));
        }
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = youjianService.queryPage(params);

        //字典表数据转换
        List<YoujianView> list =(List<YoujianView>)page.getList();
        for(YoujianView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YoujianEntity youjian = youjianService.selectById(id);
        if(youjian !=null){
            //entity转view
            YoujianView view = new YoujianView();
            BeanUtils.copyProperties( youjian , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(youjian.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YoujianEntity youjian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,youjian:{}",this.getClass().getName(),youjian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            youjian.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YoujianEntity> queryWrapper = new EntityWrapper<YoujianEntity>()
            .eq("yonghu_id", youjian.getYonghuId())
            .eq("youjian_name", youjian.getYoujianName())
            .eq("youjian_types", youjian.getYoujianTypes())
            .eq("youjian_jieshouren", youjian.getYoujianJieshouren())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YoujianEntity youjianEntity = youjianService.selectOne(queryWrapper);
        if(youjianEntity==null){
            youjian.setInsertTime(new Date());
            youjian.setCreateTime(new Date());
            youjianService.insert(youjian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YoujianEntity youjian, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,youjian:{}",this.getClass().getName(),youjian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            youjian.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YoujianEntity> queryWrapper = new EntityWrapper<YoujianEntity>()
            .notIn("id",youjian.getId())
            .andNew()
            .eq("yonghu_id", youjian.getYonghuId())
            .eq("youjian_name", youjian.getYoujianName())
            .eq("youjian_types", youjian.getYoujianTypes())
            .eq("youjian_jieshouren", youjian.getYoujianJieshouren())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YoujianEntity youjianEntity = youjianService.selectOne(queryWrapper);
        if("".equals(youjian.getYoujianFile()) || "null".equals(youjian.getYoujianFile())){
                youjian.setYoujianFile(null);
        }
        if(youjianEntity==null){
            youjianService.updateById(youjian);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        youjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YoujianEntity> youjianList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YoujianEntity youjianEntity = new YoujianEntity();
//                            youjianEntity.setYonghuId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            youjianEntity.setYoujianName(data.get(0));                    //邮件标题 要改的
//                            youjianEntity.setYoujianFile(data.get(0));                    //公文附件 要改的
//                            youjianEntity.setYoujianTypes(Integer.valueOf(data.get(0)));   //邮件类型 要改的
//                            youjianEntity.setInsertTime(date);//时间
//                            youjianEntity.setYoujianContent("");//详情和图片
//                            youjianEntity.setYoujianJieshouren(data.get(0));                    //接收人 要改的
//                            youjianEntity.setCreateTime(date);//时间
                            youjianList.add(youjianEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        youjianService.insertBatch(youjianList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
