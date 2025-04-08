package com.entity.vo;

import com.entity.GongwenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 公文
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongwen")
public class GongwenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 经理
     */

    @TableField(value = "jingli_id")
    private Integer jingliId;


    /**
     * 部门
     */

    @TableField(value = "bumen_types")
    private Integer bumenTypes;


    /**
     * 公文标题
     */

    @TableField(value = "gongwen_name")
    private String gongwenName;


    /**
     * 公文附件
     */

    @TableField(value = "gongwen_file")
    private String gongwenFile;


    /**
     * 公文类型
     */

    @TableField(value = "gongwen_types")
    private Integer gongwenTypes;


    /**
     * 发布公文时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 公文内容
     */

    @TableField(value = "gongwen_content")
    private String gongwenContent;


    /**
     * 接收人
     */

    @TableField(value = "gongwen_jieshouren")
    private String gongwenJieshouren;


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
	 * 设置：经理
	 */
    public Integer getJingliId() {
        return jingliId;
    }


    /**
	 * 获取：经理
	 */

    public void setJingliId(Integer jingliId) {
        this.jingliId = jingliId;
    }
    /**
	 * 设置：部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 获取：部门
	 */

    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 设置：公文标题
	 */
    public String getGongwenName() {
        return gongwenName;
    }


    /**
	 * 获取：公文标题
	 */

    public void setGongwenName(String gongwenName) {
        this.gongwenName = gongwenName;
    }
    /**
	 * 设置：公文附件
	 */
    public String getGongwenFile() {
        return gongwenFile;
    }


    /**
	 * 获取：公文附件
	 */

    public void setGongwenFile(String gongwenFile) {
        this.gongwenFile = gongwenFile;
    }
    /**
	 * 设置：公文类型
	 */
    public Integer getGongwenTypes() {
        return gongwenTypes;
    }


    /**
	 * 获取：公文类型
	 */

    public void setGongwenTypes(Integer gongwenTypes) {
        this.gongwenTypes = gongwenTypes;
    }
    /**
	 * 设置：发布公文时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布公文时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：公文内容
	 */
    public String getGongwenContent() {
        return gongwenContent;
    }


    /**
	 * 获取：公文内容
	 */

    public void setGongwenContent(String gongwenContent) {
        this.gongwenContent = gongwenContent;
    }
    /**
	 * 设置：接收人
	 */
    public String getGongwenJieshouren() {
        return gongwenJieshouren;
    }


    /**
	 * 获取：接收人
	 */

    public void setGongwenJieshouren(String gongwenJieshouren) {
        this.gongwenJieshouren = gongwenJieshouren;
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
