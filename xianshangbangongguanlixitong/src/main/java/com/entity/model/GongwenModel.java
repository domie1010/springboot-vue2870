package com.entity.model;

import com.entity.GongwenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 公文
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongwenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 经理
     */
    private Integer jingliId;


    /**
     * 部门
     */
    private Integer bumenTypes;


    /**
     * 公文标题
     */
    private String gongwenName;


    /**
     * 公文附件
     */
    private String gongwenFile;


    /**
     * 公文类型
     */
    private Integer gongwenTypes;


    /**
     * 发布公文时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 公文内容
     */
    private String gongwenContent;


    /**
     * 接收人
     */
    private String gongwenJieshouren;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：经理
	 */
    public Integer getJingliId() {
        return jingliId;
    }


    /**
	 * 设置：经理
	 */
    public void setJingliId(Integer jingliId) {
        this.jingliId = jingliId;
    }
    /**
	 * 获取：部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 设置：部门
	 */
    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 获取：公文标题
	 */
    public String getGongwenName() {
        return gongwenName;
    }


    /**
	 * 设置：公文标题
	 */
    public void setGongwenName(String gongwenName) {
        this.gongwenName = gongwenName;
    }
    /**
	 * 获取：公文附件
	 */
    public String getGongwenFile() {
        return gongwenFile;
    }


    /**
	 * 设置：公文附件
	 */
    public void setGongwenFile(String gongwenFile) {
        this.gongwenFile = gongwenFile;
    }
    /**
	 * 获取：公文类型
	 */
    public Integer getGongwenTypes() {
        return gongwenTypes;
    }


    /**
	 * 设置：公文类型
	 */
    public void setGongwenTypes(Integer gongwenTypes) {
        this.gongwenTypes = gongwenTypes;
    }
    /**
	 * 获取：发布公文时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布公文时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：公文内容
	 */
    public String getGongwenContent() {
        return gongwenContent;
    }


    /**
	 * 设置：公文内容
	 */
    public void setGongwenContent(String gongwenContent) {
        this.gongwenContent = gongwenContent;
    }
    /**
	 * 获取：接收人
	 */
    public String getGongwenJieshouren() {
        return gongwenJieshouren;
    }


    /**
	 * 设置：接收人
	 */
    public void setGongwenJieshouren(String gongwenJieshouren) {
        this.gongwenJieshouren = gongwenJieshouren;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
