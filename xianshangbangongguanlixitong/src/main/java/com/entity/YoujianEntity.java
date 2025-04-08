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
 * 邮件
 *
 * @author 
 * @email
 */
@TableName("youjian")
public class YoujianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YoujianEntity() {

	}

	public YoujianEntity(T t) {
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
     * 邮件标题
     */
    @TableField(value = "youjian_name")

    private String youjianName;


    /**
     * 公文附件
     */
    @TableField(value = "youjian_file")

    private String youjianFile;


    /**
     * 邮件类型
     */
    @TableField(value = "youjian_types")

    private Integer youjianTypes;


    /**
     * 发布邮件时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 邮件内容
     */
    @TableField(value = "youjian_content")

    private String youjianContent;


    /**
     * 接收人
     */
    @TableField(value = "youjian_jieshouren")

    private String youjianJieshouren;


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
	 * 设置：邮件标题
	 */
    public String getYoujianName() {
        return youjianName;
    }
    /**
	 * 获取：邮件标题
	 */

    public void setYoujianName(String youjianName) {
        this.youjianName = youjianName;
    }
    /**
	 * 设置：公文附件
	 */
    public String getYoujianFile() {
        return youjianFile;
    }
    /**
	 * 获取：公文附件
	 */

    public void setYoujianFile(String youjianFile) {
        this.youjianFile = youjianFile;
    }
    /**
	 * 设置：邮件类型
	 */
    public Integer getYoujianTypes() {
        return youjianTypes;
    }
    /**
	 * 获取：邮件类型
	 */

    public void setYoujianTypes(Integer youjianTypes) {
        this.youjianTypes = youjianTypes;
    }
    /**
	 * 设置：发布邮件时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：发布邮件时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：邮件内容
	 */
    public String getYoujianContent() {
        return youjianContent;
    }
    /**
	 * 获取：邮件内容
	 */

    public void setYoujianContent(String youjianContent) {
        this.youjianContent = youjianContent;
    }
    /**
	 * 设置：接收人
	 */
    public String getYoujianJieshouren() {
        return youjianJieshouren;
    }
    /**
	 * 获取：接收人
	 */

    public void setYoujianJieshouren(String youjianJieshouren) {
        this.youjianJieshouren = youjianJieshouren;
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
        return "Youjian{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", youjianName=" + youjianName +
            ", youjianFile=" + youjianFile +
            ", youjianTypes=" + youjianTypes +
            ", insertTime=" + insertTime +
            ", youjianContent=" + youjianContent +
            ", youjianJieshouren=" + youjianJieshouren +
            ", createTime=" + createTime +
        "}";
    }
}
