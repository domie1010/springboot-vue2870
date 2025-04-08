
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.BumenrenmingEntity;
import com.entity.YonghuEntity;
import com.entity.view.BumenrenmingView;
import com.entity.view.YonghuView;
import com.service.BumenrenmingService;
import com.service.DictionaryService;
import com.service.TokenService;
import com.service.YonghuService;
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
 * 部门任命
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bumenrenming")
public class BumenrenmingController {
    private static final Logger logger = LoggerFactory.getLogger(BumenrenmingController.class);

    @Autowired
    private BumenrenmingService bumenrenmingService;


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
        else if("员工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = bumenrenmingService.queryPage(params);

        //字典表数据转换
        List<BumenrenmingView> list =(List<BumenrenmingView>)page.getList();
        for(BumenrenmingView c:list){
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
        BumenrenmingEntity bumenrenming = bumenrenmingService.selectById(id);
        if(bumenrenming !=null){
            //entity转view
            BumenrenmingView view = new BumenrenmingView();
            BeanUtils.copyProperties( bumenrenming , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(bumenrenming.getYonghuId());
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
    public R save(@RequestBody BumenrenmingEntity bumenrenming, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bumenrenming:{}",this.getClass().getName(),bumenrenming.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            bumenrenming.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BumenrenmingEntity> queryWrapper = new EntityWrapper<BumenrenmingEntity>()
            .eq("yonghu_id", bumenrenming.getYonghuId())
            .eq("bumenrenming_uuid_number", bumenrenming.getBumenrenmingUuidNumber())
            .eq("bumenrenming_old_bumen", bumenrenming.getBumenrenmingOldBumen())
            .eq("bumenrenming_old_zhiwei", bumenrenming.getBumenrenmingOldZhiwei())
            .eq("bumen_types", bumenrenming.getBumenTypes())
            .eq("zhiwei_types", bumenrenming.getZhiweiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BumenrenmingEntity bumenrenmingEntity = bumenrenmingService.selectOne(queryWrapper);
        if(bumenrenmingEntity==null){

            YonghuEntity yonghuEntity = yonghuService.selectById(bumenrenming.getYonghuId());
            YonghuView yonghuView = new YonghuView();
            BeanUtils.copyProperties( yonghuEntity , yonghuView );

            dictionaryService.dictionaryConvert(yonghuView, request);
            bumenrenming.setBumenrenmingOldBumen(yonghuView.getBumenValue());
            bumenrenming.setBumenrenmingOldZhiwei(yonghuView.getZhiweiValue());



            bumenrenming.setInsertTime(new Date());
            bumenrenming.setCreateTime(new Date());
            bumenrenmingService.insert(bumenrenming);

            yonghuEntity.setBumenTypes(bumenrenming.getBumenTypes());
            yonghuEntity.setZhiweiTypes(bumenrenming.getZhiweiTypes());

            yonghuService.updateById(yonghuEntity);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BumenrenmingEntity bumenrenming, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bumenrenming:{}",this.getClass().getName(),bumenrenming.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            bumenrenming.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BumenrenmingEntity> queryWrapper = new EntityWrapper<BumenrenmingEntity>()
            .notIn("id",bumenrenming.getId())
            .andNew()
            .eq("yonghu_id", bumenrenming.getYonghuId())
            .eq("bumenrenming_uuid_number", bumenrenming.getBumenrenmingUuidNumber())
            .eq("bumenrenming_old_bumen", bumenrenming.getBumenrenmingOldBumen())
            .eq("bumenrenming_old_zhiwei", bumenrenming.getBumenrenmingOldZhiwei())
            .eq("bumen_types", bumenrenming.getBumenTypes())
            .eq("zhiwei_types", bumenrenming.getZhiweiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BumenrenmingEntity bumenrenmingEntity = bumenrenmingService.selectOne(queryWrapper);
        if(bumenrenmingEntity==null){




            YonghuEntity yonghuEntity = yonghuService.selectById(bumenrenming.getYonghuId());
            yonghuEntity.setBumenTypes(bumenrenming.getBumenTypes());
            yonghuEntity.setZhiweiTypes(bumenrenming.getZhiweiTypes());
            yonghuService.updateById(yonghuEntity);

            bumenrenmingService.updateById(bumenrenming);//根据id更新
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
        bumenrenmingService.deleteBatchIds(Arrays.asList(ids));
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
            List<BumenrenmingEntity> bumenrenmingList = new ArrayList<>();//上传的东西
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
                            BumenrenmingEntity bumenrenmingEntity = new BumenrenmingEntity();
//                            bumenrenmingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            bumenrenmingEntity.setBumenrenmingUuidNumber(data.get(0));                    //部门任命编号 要改的
//                            bumenrenmingEntity.setBumenrenmingOldBumen(data.get(0));                    //老部门 要改的
//                            bumenrenmingEntity.setBumenrenmingOldZhiwei(data.get(0));                    //老职位 要改的
//                            bumenrenmingEntity.setBumenTypes(Integer.valueOf(data.get(0)));   //现部门 要改的
//                            bumenrenmingEntity.setZhiweiTypes(Integer.valueOf(data.get(0)));   //现职位 要改的
//                            bumenrenmingEntity.setBumenrenmingContent("");//详情和图片
//                            bumenrenmingEntity.setRenmingTime(sdf.parse(data.get(0)));          //任命时间 要改的
//                            bumenrenmingEntity.setInsertTime(date);//时间
//                            bumenrenmingEntity.setCreateTime(date);//时间
                            bumenrenmingList.add(bumenrenmingEntity);


                            //把要查询是否重复的字段放入map中
                                //部门任命编号
                                if(seachFields.containsKey("bumenrenmingUuidNumber")){
                                    List<String> bumenrenmingUuidNumber = seachFields.get("bumenrenmingUuidNumber");
                                    bumenrenmingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> bumenrenmingUuidNumber = new ArrayList<>();
                                    bumenrenmingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("bumenrenmingUuidNumber",bumenrenmingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //部门任命编号
                        List<BumenrenmingEntity> bumenrenmingEntities_bumenrenmingUuidNumber = bumenrenmingService.selectList(new EntityWrapper<BumenrenmingEntity>().in("bumenrenming_uuid_number", seachFields.get("bumenrenmingUuidNumber")));
                        if(bumenrenmingEntities_bumenrenmingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BumenrenmingEntity s:bumenrenmingEntities_bumenrenmingUuidNumber){
                                repeatFields.add(s.getBumenrenmingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [部门任命编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        bumenrenmingService.insertBatch(bumenrenmingList);
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
