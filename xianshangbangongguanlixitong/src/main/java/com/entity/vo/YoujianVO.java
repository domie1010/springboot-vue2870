package com.entity.vo;

import com.entity.YoujianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 邮件
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("youjian")
public class YoujianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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

    @TableField(value = "create_time")
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

}
