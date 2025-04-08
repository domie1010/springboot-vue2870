
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.CaiwubaozhangEntity;
import com.entity.YonghuEntity;
import com.entity.view.CaiwubaozhangView;
import com.service.*;
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
 * 财务报账
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/caiwubaozhang")
public class CaiwubaozhangController {
    private static final Logger logger = LoggerFactory.getLogger(CaiwubaozhangController.class);

    @Autowired
    private CaiwubaozhangService caiwubaozhangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private JingliService jingliService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("经理".equals(role))
            params.put("jingliId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = caiwubaozhangService.queryPage(params);

        //字典表数据转换
        List<CaiwubaozhangView> list =(List<CaiwubaozhangView>)page.getList();
        for(CaiwubaozhangView c:list){
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
        CaiwubaozhangEntity caiwubaozhang = caiwubaozhangService.selectById(id);
        if(caiwubaozhang !=null){
            //entity转view
            CaiwubaozhangView view = new CaiwubaozhangView();
            BeanUtils.copyProperties( caiwubaozhang , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(caiwubaozhang.getYonghuId());
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
    public R save(@RequestBody CaiwubaozhangEntity caiwubaozhang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,caiwubaozhang:{}",this.getClass().getName(),caiwubaozhang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            caiwubaozhang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<CaiwubaozhangEntity> queryWrapper = new EntityWrapper<CaiwubaozhangEntity>()
            .eq("yonghu_id", caiwubaozhang.getYonghuId())
            .eq("caiwubaozhang_name", caiwubaozhang.getCaiwubaozhangName())
            .eq("caiwubaozhang_types", caiwubaozhang.getCaiwubaozhangTypes())
            .eq("caiwubaozhang_guanli_yesno_types", caiwubaozhang.getCaiwubaozhangGuanliYesnoTypes())
            .eq("caiwubaozhang_guanli_yesno_text", caiwubaozhang.getCaiwubaozhangGuanliYesnoText())
            .eq("caiwubaozhang_yesno_types", caiwubaozhang.getCaiwubaozhangYesnoTypes())
            .eq("caiwubaozhang_yesno_text", caiwubaozhang.getCaiwubaozhangYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaiwubaozhangEntity caiwubaozhangEntity = caiwubaozhangService.selectOne(queryWrapper);
        if(caiwubaozhangEntity==null){
            caiwubaozhang.setInsertTime(new Date());
            caiwubaozhang.setCaiwubaozhangGuanliYesnoTypes(1);
            caiwubaozhang.setCreateTime(new Date());
            caiwubaozhangService.insert(caiwubaozhang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaiwubaozhangEntity caiwubaozhang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,caiwubaozhang:{}",this.getClass().getName(),caiwubaozhang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            caiwubaozhang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<CaiwubaozhangEntity> queryWrapper = new EntityWrapper<CaiwubaozhangEntity>()
            .notIn("id",caiwubaozhang.getId())
            .andNew()
            .eq("yonghu_id", caiwubaozhang.getYonghuId())
            .eq("caiwubaozhang_name", caiwubaozhang.getCaiwubaozhangName())
            .eq("caiwubaozhang_types", caiwubaozhang.getCaiwubaozhangTypes())
            .eq("insert_time", caiwubaozhang.getInsertTime())
            .eq("caiwubaozhang_guanli_yesno_types", caiwubaozhang.getCaiwubaozhangGuanliYesnoTypes())
            .eq("caiwubaozhang_guanli_yesno_text", caiwubaozhang.getCaiwubaozhangGuanliYesnoText())
            .eq("caiwubaozhang_guanli_yesno_time", caiwubaozhang.getCaiwubaozhangGuanliYesnoTime())
            .eq("caiwubaozhang_yesno_types", caiwubaozhang.getCaiwubaozhangYesnoTypes())
            .eq("caiwubaozhang_yesno_text", caiwubaozhang.getCaiwubaozhangYesnoText())
            .eq("caiwubaozhang_shenhe_time", caiwubaozhang.getCaiwubaozhangShenheTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaiwubaozhangEntity caiwubaozhangEntity = caiwubaozhangService.selectOne(queryWrapper);
        if("".equals(caiwubaozhang.getCaiwubaozhangFile()) || "null".equals(caiwubaozhang.getCaiwubaozhangFile())){
                caiwubaozhang.setCaiwubaozhangFile(null);
        }
        if(caiwubaozhangEntity==null){
            caiwubaozhangService.updateById(caiwubaozhang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody CaiwubaozhangEntity caiwubaozhangEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,caiwubaozhangEntity:{}",this.getClass().getName(),caiwubaozhangEntity.toString());

//        if(caiwubaozhangEntity.getCaiwubaozhangYesnoTypes() == 2){//通过
//            caiwubaozhangEntity.setCaiwubaozhangTypes();
//        }else if(caiwubaozhangEntity.getCaiwubaozhangYesnoTypes() == 3){//拒绝
//            caiwubaozhangEntity.setCaiwubaozhangTypes();
//        }
        caiwubaozhangEntity.setCaiwubaozhangShenheTime(new Date());//经理审核时间
        caiwubaozhangService.updateById(caiwubaozhangEntity);//审核
        return R.ok();
    }




    /**
     * 管理员审核
     */
    @RequestMapping("/guanlishenhe")
    public R guanlishenhe(@RequestBody CaiwubaozhangEntity caiwubaozhangEntity, HttpServletRequest request){
        logger.debug("guanlishenhe方法:,,Controller:{},,caiwubaozhangEntity:{}",this.getClass().getName(),caiwubaozhangEntity.toString());

        if(caiwubaozhangEntity.getCaiwubaozhangGuanliYesnoTypes() == 2){//通过
            caiwubaozhangEntity.setCaiwubaozhangYesnoTypes(1);
        }else if(caiwubaozhangEntity.getCaiwubaozhangGuanliYesnoTypes() == 3){//拒绝
//            caiwubaozhangEntity.setCaiwubaozhangTypes();
        }
        caiwubaozhangEntity.setCaiwubaozhangGuanliYesnoTime(new Date());//经理审核时间
        caiwubaozhangService.updateById(caiwubaozhangEntity);//审核
        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        caiwubaozhangService.deleteBatchIds(Arrays.asList(ids));
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
            List<CaiwubaozhangEntity> caiwubaozhangList = new ArrayList<>();//上传的东西
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
                            CaiwubaozhangEntity caiwubaozhangEntity = new CaiwubaozhangEntity();
//                            caiwubaozhangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangName(data.get(0));                    //财务报账标题 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangTypes(Integer.valueOf(data.get(0)));   //财务报账类型 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangFile(data.get(0));                    //报账发票 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangJine(data.get(0));                    //报账金额 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangContent("");//详情和图片
//                            caiwubaozhangEntity.setInsertTime(date);//时间
//                            caiwubaozhangEntity.setCaiwubaozhangGuanliYesnoTypes(Integer.valueOf(data.get(0)));   //管理员审核状态 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangGuanliYesnoText(data.get(0));                    //管理员审核意见 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangGuanliYesnoTime(sdf.parse(data.get(0)));          //管理员审核时间 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangYesnoTypes(Integer.valueOf(data.get(0)));   //经理审核状态 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangYesnoText(data.get(0));                    //经理审核意见 要改的
//                            caiwubaozhangEntity.setCaiwubaozhangShenheTime(sdf.parse(data.get(0)));          //经理审核时间 要改的
//                            caiwubaozhangEntity.setCreateTime(date);//时间
                            caiwubaozhangList.add(caiwubaozhangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        caiwubaozhangService.insertBatch(caiwubaozhangList);
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
