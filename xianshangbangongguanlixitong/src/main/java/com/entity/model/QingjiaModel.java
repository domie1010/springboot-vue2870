package com.entity.model;

import com.entity.QingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 请假
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QingjiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 请假标题
     */
    private String qingjiaName;


    /**
     * 请假类型
     */
    private Integer qingjiaTypes;


    /**
     * 请假申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 请假内容
     */
    private String qingjiaContent;


    /**
     * 请假开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qingjiaKaishiTime;


    /**
     * 请假结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qingjiaJieshuTime;


    /**
     * 管理员审核状态
     */
    private Integer qingjiaGuanliYesnoTypes;


    /**
     * 管理员审核意见
     */
    private String qingjiaGuanliYesnoText;


    /**
     * 管理员审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qingjiaGuanliYesnoTime;


    /**
     * 经理审核状态
     */
    private Integer qingjiaYesnoTypes;


    /**
     * 经理审核意见
     */
    private String qingjiaYesnoText;


    /**
     * 经理审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qingjiaShenheTime;


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
	 * 获取：请假标题
	 */
    public String getQingjiaName() {
        return qingjiaName;
    }


    /**
	 * 设置：请假标题
	 */
    public void setQingjiaName(String qingjiaName) {
        this.qingjiaName = qingjiaName;
    }
    /**
	 * 获取：请假类型
	 */
    public Integer getQingjiaTypes() {
        return qingjiaTypes;
    }


    /**
	 * 设置：请假类型
	 */
    public void setQingjiaTypes(Integer qingjiaTypes) {
        this.qingjiaTypes = qingjiaTypes;
    }
    /**
	 * 获取：请假申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：请假申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：请假内容
	 */
    public String getQingjiaContent() {
        return qingjiaContent;
    }


    /**
	 * 设置：请假内容
	 */
    public void setQingjiaContent(String qingjiaContent) {
        this.qingjiaContent = qingjiaContent;
    }
    /**
	 * 获取：请假开始时间
	 */
    public Date getQingjiaKaishiTime() {
        return qingjiaKaishiTime;
    }


    /**
	 * 设置：请假开始时间
	 */
    public void setQingjiaKaishiTime(Date qingjiaKaishiTime) {
        this.qingjiaKaishiTime = qingjiaKaishiTime;
    }
    /**
	 * 获取：请假结束时间
	 */
    public Date getQingjiaJieshuTime() {
        return qingjiaJieshuTime;
    }


    /**
	 * 设置：请假结束时间
	 */
    public void setQingjiaJieshuTime(Date qingjiaJieshuTime) {
        this.qingjiaJieshuTime = qingjiaJieshuTime;
    }
    /**
	 * 获取：管理员审核状态
	 */
    public Integer getQingjiaGuanliYesnoTypes() {
        return qingjiaGuanliYesnoTypes;
    }


    /**
	 * 设置：管理员审核状态
	 */
    public void setQingjiaGuanliYesnoTypes(Integer qingjiaGuanliYesnoTypes) {
        this.qingjiaGuanliYesnoTypes = qingjiaGuanliYesnoTypes;
    }
    /**
	 * 获取：管理员审核意见
	 */
    public String getQingjiaGuanliYesnoText() {
        return qingjiaGuanliYesnoText;
    }


    /**
	 * 设置：管理员审核意见
	 */
    public void setQingjiaGuanliYesnoText(String qingjiaGuanliYesnoText) {
        this.qingjiaGuanliYesnoText = qingjiaGuanliYesnoText;
    }
    /**
	 * 获取：管理员审核时间
	 */
    public Date getQingjiaGuanliYesnoTime() {
        return qingjiaGuanliYesnoTime;
    }


    /**
	 * 设置：管理员审核时间
	 */
    public void setQingjiaGuanliYesnoTime(Date qingjiaGuanliYesnoTime) {
        this.qingjiaGuanliYesnoTime = qingjiaGuanliYesnoTime;
    }
    /**
	 * 获取：经理审核状态
	 */
    public Integer getQingjiaYesnoTypes() {
        return qingjiaYesnoTypes;
    }


    /**
	 * 设置：经理审核状态
	 */
    public void setQingjiaYesnoTypes(Integer qingjiaYesnoTypes) {
        this.qingjiaYesnoTypes = qingjiaYesnoTypes;
    }
    /**
	 * 获取：经理审核意见
	 */
    public String getQingjiaYesnoText() {
        return qingjiaYesnoText;
    }


    /**
	 * 设置：经理审核意见
	 */
    public void setQingjiaYesnoText(String qingjiaYesnoText) {
        this.qingjiaYesnoText = qingjiaYesnoText;
    }
    /**
	 * 获取：经理审核时间
	 */
    public Date getQingjiaShenheTime() {
        return qingjiaShenheTime;
    }


    /**
	 * 设置：经理审核时间
	 */
    public void setQingjiaShenheTime(Date qingjiaShenheTime) {
        this.qingjiaShenheTime = qingjiaShenheTime;
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
