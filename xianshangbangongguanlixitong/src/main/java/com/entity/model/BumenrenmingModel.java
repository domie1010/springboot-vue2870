package com.entity.model;

import com.entity.BumenrenmingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 部门任命
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BumenrenmingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yonghuId;


    /**
     * 部门任命编号
     */
    private String bumenrenmingUuidNumber;


    /**
     * 老部门
     */
    private String bumenrenmingOldBumen;


    /**
     * 老职位
     */
    private String bumenrenmingOldZhiwei;


    /**
     * 现部门
     */
    private Integer bumenTypes;


    /**
     * 现职位
     */
    private Integer zhiweiTypes;


    /**
     * 任命缘由
     */
    private String bumenrenmingContent;


    /**
     * 任命时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date renmingTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：员工
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：部门任命编号
	 */
    public String getBumenrenmingUuidNumber() {
        return bumenrenmingUuidNumber;
    }


    /**
	 * 设置：部门任命编号
	 */
    public void setBumenrenmingUuidNumber(String bumenrenmingUuidNumber) {
        this.bumenrenmingUuidNumber = bumenrenmingUuidNumber;
    }
    /**
	 * 获取：老部门
	 */
    public String getBumenrenmingOldBumen() {
        return bumenrenmingOldBumen;
    }


    /**
	 * 设置：老部门
	 */
    public void setBumenrenmingOldBumen(String bumenrenmingOldBumen) {
        this.bumenrenmingOldBumen = bumenrenmingOldBumen;
    }
    /**
	 * 获取：老职位
	 */
    public String getBumenrenmingOldZhiwei() {
        return bumenrenmingOldZhiwei;
    }


    /**
	 * 设置：老职位
	 */
    public void setBumenrenmingOldZhiwei(String bumenrenmingOldZhiwei) {
        this.bumenrenmingOldZhiwei = bumenrenmingOldZhiwei;
    }
    /**
	 * 获取：现部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 设置：现部门
	 */
    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 获取：现职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }


    /**
	 * 设置：现职位
	 */
    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
    }
    /**
	 * 获取：任命缘由
	 */
    public String getBumenrenmingContent() {
        return bumenrenmingContent;
    }


    /**
	 * 设置：任命缘由
	 */
    public void setBumenrenmingContent(String bumenrenmingContent) {
        this.bumenrenmingContent = bumenrenmingContent;
    }
    /**
	 * 获取：任命时间
	 */
    public Date getRenmingTime() {
        return renmingTime;
    }


    /**
	 * 设置：任命时间
	 */
    public void setRenmingTime(Date renmingTime) {
        this.renmingTime = renmingTime;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
