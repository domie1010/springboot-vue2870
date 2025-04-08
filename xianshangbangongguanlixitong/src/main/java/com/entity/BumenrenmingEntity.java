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
 * 部门任命
 *
 * @author 
 * @email
 */
@TableName("bumenrenming")
public class BumenrenmingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BumenrenmingEntity() {

	}

	public BumenrenmingEntity(T t) {
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
     * 部门任命编号
     */
    @TableField(value = "bumenrenming_uuid_number")

    private String bumenrenmingUuidNumber;


    /**
     * 老部门
     */
    @TableField(value = "bumenrenming_old_bumen")

    private String bumenrenmingOldBumen;


    /**
     * 老职位
     */
    @TableField(value = "bumenrenming_old_zhiwei")

    private String bumenrenmingOldZhiwei;


    /**
     * 现部门
     */
    @TableField(value = "bumen_types")

    private Integer bumenTypes;


    /**
     * 现职位
     */
    @TableField(value = "zhiwei_types")

    private Integer zhiweiTypes;


    /**
     * 任命缘由
     */
    @TableField(value = "bumenrenming_content")

    private String bumenrenmingContent;


    /**
     * 任命时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "renming_time")

    private Date renmingTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：部门任命编号
	 */
    public String getBumenrenmingUuidNumber() {
        return bumenrenmingUuidNumber;
    }
    /**
	 * 获取：部门任命编号
	 */

    public void setBumenrenmingUuidNumber(String bumenrenmingUuidNumber) {
        this.bumenrenmingUuidNumber = bumenrenmingUuidNumber;
    }
    /**
	 * 设置：老部门
	 */
    public String getBumenrenmingOldBumen() {
        return bumenrenmingOldBumen;
    }
    /**
	 * 获取：老部门
	 */

    public void setBumenrenmingOldBumen(String bumenrenmingOldBumen) {
        this.bumenrenmingOldBumen = bumenrenmingOldBumen;
    }
    /**
	 * 设置：老职位
	 */
    public String getBumenrenmingOldZhiwei() {
        return bumenrenmingOldZhiwei;
    }
    /**
	 * 获取：老职位
	 */

    public void setBumenrenmingOldZhiwei(String bumenrenmingOldZhiwei) {
        this.bumenrenmingOldZhiwei = bumenrenmingOldZhiwei;
    }
    /**
	 * 设置：现部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }
    /**
	 * 获取：现部门
	 */

    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 设置：现职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }
    /**
	 * 获取：现职位
	 */

    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
    }
    /**
	 * 设置：任命缘由
	 */
    public String getBumenrenmingContent() {
        return bumenrenmingContent;
    }
    /**
	 * 获取：任命缘由
	 */

    public void setBumenrenmingContent(String bumenrenmingContent) {
        this.bumenrenmingContent = bumenrenmingContent;
    }
    /**
	 * 设置：任命时间
	 */
    public Date getRenmingTime() {
        return renmingTime;
    }
    /**
	 * 获取：任命时间
	 */

    public void setRenmingTime(Date renmingTime) {
        this.renmingTime = renmingTime;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Bumenrenming{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", bumenrenmingUuidNumber=" + bumenrenmingUuidNumber +
            ", bumenrenmingOldBumen=" + bumenrenmingOldBumen +
            ", bumenrenmingOldZhiwei=" + bumenrenmingOldZhiwei +
            ", bumenTypes=" + bumenTypes +
            ", zhiweiTypes=" + zhiweiTypes +
            ", bumenrenmingContent=" + bumenrenmingContent +
            ", renmingTime=" + renmingTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
