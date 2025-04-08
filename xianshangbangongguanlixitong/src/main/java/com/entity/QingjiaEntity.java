package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 请假
 *
 * @author 
 * @email
 */
@TableName("qingjia")
public class QingjiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QingjiaEntity() {

	}

	public QingjiaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 员工
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 请假标题
     */
    @TableField(value = "qingjia_name")

    private String qingjiaName;


    /**
     * 请假类型
     */
    @TableField(value = "qingjia_types")

    private Integer qingjiaTypes;


    /**
     * 请假申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 请假内容
     */
    @TableField(value = "qingjia_content")

    private String qingjiaContent;


    /**
     * 请假开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qingjia_kaishi_time")

    private Date qingjiaKaishiTime;


    /**
     * 请假结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qingjia_jieshu_time")

    private Date qingjiaJieshuTime;


    /**
     * 管理员审核状态
     */
    @TableField(value = "qingjia_guanli_yesno_types")

    private Integer qingjiaGuanliYesnoTypes;


    /**
     * 管理员审核意见
     */
    @TableField(value = "qingjia_guanli_yesno_text")

    private String qingjiaGuanliYesnoText;


    /**
     * 管理员审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qingjia_guanli_yesno_time")

    private Date qingjiaGuanliYesnoTime;


    /**
     * 经理审核状态
     */
    @TableField(value = "qingjia_yesno_types")

    private Integer qingjiaYesnoTypes;


    /**
     * 经理审核意见
     */
    @TableField(value = "qingjia_yesno_text")

    private String qingjiaYesnoText;


    /**
     * 经理审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qingjia_shenhe_time")

    private Date qingjiaShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：员工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：请假标题
	 */
    public String getQingjiaName() {
        return qingjiaName;
    }
    /**
	 * 获取：请假标题
	 */

    public void setQingjiaName(String qingjiaName) {
        this.qingjiaName = qingjiaName;
    }
    /**
	 * 设置：请假类型
	 */
    public Integer getQingjiaTypes() {
        return qingjiaTypes;
    }
    /**
	 * 获取：请假类型
	 */

    public void setQingjiaTypes(Integer qingjiaTypes) {
        this.qingjiaTypes = qingjiaTypes;
    }
    /**
	 * 设置：请假申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：请假申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：请假内容
	 */
    public String getQingjiaContent() {
        return qingjiaContent;
    }
    /**
	 * 获取：请假内容
	 */

    public void setQingjiaContent(String qingjiaContent) {
        this.qingjiaContent = qingjiaContent;
    }
    /**
	 * 设置：请假开始时间
	 */
    public Date getQingjiaKaishiTime() {
        return qingjiaKaishiTime;
    }
    /**
	 * 获取：请假开始时间
	 */

    public void setQingjiaKaishiTime(Date qingjiaKaishiTime) {
        this.qingjiaKaishiTime = qingjiaKaishiTime;
    }
    /**
	 * 设置：请假结束时间
	 */
    public Date getQingjiaJieshuTime() {
        return qingjiaJieshuTime;
    }
    /**
	 * 获取：请假结束时间
	 */

    public void setQingjiaJieshuTime(Date qingjiaJieshuTime) {
        this.qingjiaJieshuTime = qingjiaJieshuTime;
    }
    /**
	 * 设置：管理员审核状态
	 */
    public Integer getQingjiaGuanliYesnoTypes() {
        return qingjiaGuanliYesnoTypes;
    }
    /**
	 * 获取：管理员审核状态
	 */

    public void setQingjiaGuanliYesnoTypes(Integer qingjiaGuanliYesnoTypes) {
        this.qingjiaGuanliYesnoTypes = qingjiaGuanliYesnoTypes;
    }
    /**
	 * 设置：管理员审核意见
	 */
    public String getQingjiaGuanliYesnoText() {
        return qingjiaGuanliYesnoText;
    }
    /**
	 * 获取：管理员审核意见
	 */

    public void setQingjiaGuanliYesnoText(String qingjiaGuanliYesnoText) {
        this.qingjiaGuanliYesnoText = qingjiaGuanliYesnoText;
    }
    /**
	 * 设置：管理员审核时间
	 */
    public Date getQingjiaGuanliYesnoTime() {
        return qingjiaGuanliYesnoTime;
    }
    /**
	 * 获取：管理员审核时间
	 */

    public void setQingjiaGuanliYesnoTime(Date qingjiaGuanliYesnoTime) {
        this.qingjiaGuanliYesnoTime = qingjiaGuanliYesnoTime;
    }
    /**
	 * 设置：经理审核状态
	 */
    public Integer getQingjiaYesnoTypes() {
        return qingjiaYesnoTypes;
    }
    /**
	 * 获取：经理审核状态
	 */

    public void setQingjiaYesnoTypes(Integer qingjiaYesnoTypes) {
        this.qingjiaYesnoTypes = qingjiaYesnoTypes;
    }
    /**
	 * 设置：经理审核意见
	 */
    public String getQingjiaYesnoText() {
        return qingjiaYesnoText;
    }
    /**
	 * 获取：经理审核意见
	 */

    public void setQingjiaYesnoText(String qingjiaYesnoText) {
        this.qingjiaYesnoText = qingjiaYesnoText;
    }
    /**
	 * 设置：经理审核时间
	 */
    public Date getQingjiaShenheTime() {
        return qingjiaShenheTime;
    }
    /**
	 * 获取：经理审核时间
	 */

    public void setQingjiaShenheTime(Date qingjiaShenheTime) {
        this.qingjiaShenheTime = qingjiaShenheTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Qingjia{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", qingjiaName=" + qingjiaName +
            ", qingjiaTypes=" + qingjiaTypes +
            ", insertTime=" + insertTime +
            ", qingjiaContent=" + qingjiaContent +
            ", qingjiaKaishiTime=" + qingjiaKaishiTime +
            ", qingjiaJieshuTime=" + qingjiaJieshuTime +
            ", qingjiaGuanliYesnoTypes=" + qingjiaGuanliYesnoTypes +
            ", qingjiaGuanliYesnoText=" + qingjiaGuanliYesnoText +
            ", qingjiaGuanliYesnoTime=" + qingjiaGuanliYesnoTime +
            ", qingjiaYesnoTypes=" + qingjiaYesnoTypes +
            ", qingjiaYesnoText=" + qingjiaYesnoText +
            ", qingjiaShenheTime=" + qingjiaShenheTime +
            ", createTime=" + createTime +
        "}";
    }
}
