package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 日程
 *
 * @author 
 * @email
 */
@TableName("richeng")
public class RichengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RichengEntity() {

	}

	public RichengEntity(T t) {
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
     * 日程名称
     */
    @TableField(value = "richeng_name")

    private String richengName;


    /**
     * 日程类型
     */
    @TableField(value = "richeng_types")

    private Integer richengTypes;


    /**
     * 日程内容
     */
    @TableField(value = "richeng_content")

    private String richengContent;


    /**
     * 日程执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "zhixing_time")

    private Date zhixingTime;


    /**
     * 已做未做
     */
    @TableField(value = "yizuo_types")

    private Integer yizuoTypes;


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
	 * 设置：日程名称
	 */
    public String getRichengName() {
        return richengName;
    }
    /**
	 * 获取：日程名称
	 */

    public void setRichengName(String richengName) {
        this.richengName = richengName;
    }
    /**
	 * 设置：日程类型
	 */
    public Integer getRichengTypes() {
        return richengTypes;
    }
    /**
	 * 获取：日程类型
	 */

    public void setRichengTypes(Integer richengTypes) {
        this.richengTypes = richengTypes;
    }
    /**
	 * 设置：日程内容
	 */
    public String getRichengContent() {
        return richengContent;
    }
    /**
	 * 获取：日程内容
	 */

    public void setRichengContent(String richengContent) {
        this.richengContent = richengContent;
    }
    /**
	 * 设置：日程执行时间
	 */
    public Date getZhixingTime() {
        return zhixingTime;
    }
    /**
	 * 获取：日程执行时间
	 */

    public void setZhixingTime(Date zhixingTime) {
        this.zhixingTime = zhixingTime;
    }
    /**
	 * 设置：已做未做
	 */
    public Integer getYizuoTypes() {
        return yizuoTypes;
    }
    /**
	 * 获取：已做未做
	 */

    public void setYizuoTypes(Integer yizuoTypes) {
        this.yizuoTypes = yizuoTypes;
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
        return "Richeng{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", richengName=" + richengName +
            ", richengTypes=" + richengTypes +
            ", richengContent=" + richengContent +
            ", zhixingTime=" + zhixingTime +
            ", yizuoTypes=" + yizuoTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
