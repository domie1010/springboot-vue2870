package com.entity.model;

import com.entity.YoujianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 邮件
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YoujianModel implements Serializable {
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
     * 邮件标题
     */
    private String youjianName;


    /**
     * 公文附件
     */
    private String youjianFile;


    /**
     * 邮件类型
     */
    private Integer youjianTypes;


    /**
     * 发布邮件时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 邮件内容
     */
    private String youjianContent;


    /**
     * 接收人
     */
    private String youjianJieshouren;


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
	 * 获取：邮件标题
	 */
    public String getYoujianName() {
        return youjianName;
    }


    /**
	 * 设置：邮件标题
	 */
    public void setYoujianName(String youjianName) {
        this.youjianName = youjianName;
    }
    /**
	 * 获取：公文附件
	 */
    public String getYoujianFile() {
        return youjianFile;
    }


    /**
	 * 设置：公文附件
	 */
    public void setYoujianFile(String youjianFile) {
        this.youjianFile = youjianFile;
    }
    /**
	 * 获取：邮件类型
	 */
    public Integer getYoujianTypes() {
        return youjianTypes;
    }


    /**
	 * 设置：邮件类型
	 */
    public void setYoujianTypes(Integer youjianTypes) {
        this.youjianTypes = youjianTypes;
    }
    /**
	 * 获取：发布邮件时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布邮件时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：邮件内容
	 */
    public String getYoujianContent() {
        return youjianContent;
    }


    /**
	 * 设置：邮件内容
	 */
    public void setYoujianContent(String youjianContent) {
        this.youjianContent = youjianContent;
    }
    /**
	 * 获取：接收人
	 */
    public String getYoujianJieshouren() {
        return youjianJieshouren;
    }


    /**
	 * 设置：接收人
	 */
    public void setYoujianJieshouren(String youjianJieshouren) {
        this.youjianJieshouren = youjianJieshouren;
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
