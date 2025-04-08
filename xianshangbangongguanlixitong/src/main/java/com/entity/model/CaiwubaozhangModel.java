package com.entity.model;

import com.entity.CaiwubaozhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 财务报账
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaiwubaozhangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 财务报账标题
     */
    private String caiwubaozhangName;


    /**
     * 财务报账类型
     */
    private Integer caiwubaozhangTypes;


    /**
     * 报账发票
     */
    private String caiwubaozhangFile;


    /**
     * 报账金额
     */
    private Double caiwubaozhangJine;


    /**
     * 报账理由
     */
    private String caiwubaozhangContent;


    /**
     * 财务报账申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 管理员审核状态
     */
    private Integer caiwubaozhangGuanliYesnoTypes;


    /**
     * 管理员审核意见
     */
    private String caiwubaozhangGuanliYesnoText;


    /**
     * 管理员审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date caiwubaozhangGuanliYesnoTime;


    /**
     * 经理审核状态
     */
    private Integer caiwubaozhangYesnoTypes;


    /**
     * 经理审核意见
     */
    private String caiwubaozhangYesnoText;


    /**
     * 经理审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date caiwubaozhangShenheTime;


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
	 * 获取：财务报账标题
	 */
    public String getCaiwubaozhangName() {
        return caiwubaozhangName;
    }


    /**
	 * 设置：财务报账标题
	 */
    public void setCaiwubaozhangName(String caiwubaozhangName) {
        this.caiwubaozhangName = caiwubaozhangName;
    }
    /**
	 * 获取：财务报账类型
	 */
    public Integer getCaiwubaozhangTypes() {
        return caiwubaozhangTypes;
    }


    /**
	 * 设置：财务报账类型
	 */
    public void setCaiwubaozhangTypes(Integer caiwubaozhangTypes) {
        this.caiwubaozhangTypes = caiwubaozhangTypes;
    }
    /**
	 * 获取：报账发票
	 */
    public String getCaiwubaozhangFile() {
        return caiwubaozhangFile;
    }


    /**
	 * 设置：报账发票
	 */
    public void setCaiwubaozhangFile(String caiwubaozhangFile) {
        this.caiwubaozhangFile = caiwubaozhangFile;
    }
    /**
	 * 获取：报账金额
	 */
    public Double getCaiwubaozhangJine() {
        return caiwubaozhangJine;
    }


    /**
	 * 设置：报账金额
	 */
    public void setCaiwubaozhangJine(Double caiwubaozhangJine) {
        this.caiwubaozhangJine = caiwubaozhangJine;
    }
    /**
	 * 获取：报账理由
	 */
    public String getCaiwubaozhangContent() {
        return caiwubaozhangContent;
    }


    /**
	 * 设置：报账理由
	 */
    public void setCaiwubaozhangContent(String caiwubaozhangContent) {
        this.caiwubaozhangContent = caiwubaozhangContent;
    }
    /**
	 * 获取：财务报账申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：财务报账申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：管理员审核状态
	 */
    public Integer getCaiwubaozhangGuanliYesnoTypes() {
        return caiwubaozhangGuanliYesnoTypes;
    }


    /**
	 * 设置：管理员审核状态
	 */
    public void setCaiwubaozhangGuanliYesnoTypes(Integer caiwubaozhangGuanliYesnoTypes) {
        this.caiwubaozhangGuanliYesnoTypes = caiwubaozhangGuanliYesnoTypes;
    }
    /**
	 * 获取：管理员审核意见
	 */
    public String getCaiwubaozhangGuanliYesnoText() {
        return caiwubaozhangGuanliYesnoText;
    }


    /**
	 * 设置：管理员审核意见
	 */
    public void setCaiwubaozhangGuanliYesnoText(String caiwubaozhangGuanliYesnoText) {
        this.caiwubaozhangGuanliYesnoText = caiwubaozhangGuanliYesnoText;
    }
    /**
	 * 获取：管理员审核时间
	 */
    public Date getCaiwubaozhangGuanliYesnoTime() {
        return caiwubaozhangGuanliYesnoTime;
    }


    /**
	 * 设置：管理员审核时间
	 */
    public void setCaiwubaozhangGuanliYesnoTime(Date caiwubaozhangGuanliYesnoTime) {
        this.caiwubaozhangGuanliYesnoTime = caiwubaozhangGuanliYesnoTime;
    }
    /**
	 * 获取：经理审核状态
	 */
    public Integer getCaiwubaozhangYesnoTypes() {
        return caiwubaozhangYesnoTypes;
    }


    /**
	 * 设置：经理审核状态
	 */
    public void setCaiwubaozhangYesnoTypes(Integer caiwubaozhangYesnoTypes) {
        this.caiwubaozhangYesnoTypes = caiwubaozhangYesnoTypes;
    }
    /**
	 * 获取：经理审核意见
	 */
    public String getCaiwubaozhangYesnoText() {
        return caiwubaozhangYesnoText;
    }


    /**
	 * 设置：经理审核意见
	 */
    public void setCaiwubaozhangYesnoText(String caiwubaozhangYesnoText) {
        this.caiwubaozhangYesnoText = caiwubaozhangYesnoText;
    }
    /**
	 * 获取：经理审核时间
	 */
    public Date getCaiwubaozhangShenheTime() {
        return caiwubaozhangShenheTime;
    }


    /**
	 * 设置：经理审核时间
	 */
    public void setCaiwubaozhangShenheTime(Date caiwubaozhangShenheTime) {
        this.caiwubaozhangShenheTime = caiwubaozhangShenheTime;
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
