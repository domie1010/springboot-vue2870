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
 * 财务报账
 *
 * @author 
 * @email
 */
@TableName("caiwubaozhang")
public class CaiwubaozhangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CaiwubaozhangEntity() {

	}

	public CaiwubaozhangEntity(T t) {
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
     * 财务报账标题
     */
    @TableField(value = "caiwubaozhang_name")

    private String caiwubaozhangName;


    /**
     * 财务报账类型
     */
    @TableField(value = "caiwubaozhang_types")

    private Integer caiwubaozhangTypes;


    /**
     * 报账发票
     */
    @TableField(value = "caiwubaozhang_file")

    private String caiwubaozhangFile;


    /**
     * 报账金额
     */
    @TableField(value = "caiwubaozhang_jine")

    private Double caiwubaozhangJine;


    /**
     * 报账理由
     */
    @TableField(value = "caiwubaozhang_content")

    private String caiwubaozhangContent;


    /**
     * 财务报账申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 管理员审核状态
     */
    @TableField(value = "caiwubaozhang_guanli_yesno_types")

    private Integer caiwubaozhangGuanliYesnoTypes;


    /**
     * 管理员审核意见
     */
    @TableField(value = "caiwubaozhang_guanli_yesno_text")

    private String caiwubaozhangGuanliYesnoText;


    /**
     * 管理员审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "caiwubaozhang_guanli_yesno_time")

    private Date caiwubaozhangGuanliYesnoTime;


    /**
     * 经理审核状态
     */
    @TableField(value = "caiwubaozhang_yesno_types")

    private Integer caiwubaozhangYesnoTypes;


    /**
     * 经理审核意见
     */
    @TableField(value = "caiwubaozhang_yesno_text")

    private String caiwubaozhangYesnoText;


    /**
     * 经理审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "caiwubaozhang_shenhe_time")

    private Date caiwubaozhangShenheTime;


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
	 * 设置：财务报账标题
	 */
    public String getCaiwubaozhangName() {
        return caiwubaozhangName;
    }
    /**
	 * 获取：财务报账标题
	 */

    public void setCaiwubaozhangName(String caiwubaozhangName) {
        this.caiwubaozhangName = caiwubaozhangName;
    }
    /**
	 * 设置：财务报账类型
	 */
    public Integer getCaiwubaozhangTypes() {
        return caiwubaozhangTypes;
    }
    /**
	 * 获取：财务报账类型
	 */

    public void setCaiwubaozhangTypes(Integer caiwubaozhangTypes) {
        this.caiwubaozhangTypes = caiwubaozhangTypes;
    }
    /**
	 * 设置：报账发票
	 */
    public String getCaiwubaozhangFile() {
        return caiwubaozhangFile;
    }
    /**
	 * 获取：报账发票
	 */

    public void setCaiwubaozhangFile(String caiwubaozhangFile) {
        this.caiwubaozhangFile = caiwubaozhangFile;
    }
    /**
	 * 设置：报账金额
	 */
    public Double getCaiwubaozhangJine() {
        return caiwubaozhangJine;
    }
    /**
	 * 获取：报账金额
	 */

    public void setCaiwubaozhangJine(Double caiwubaozhangJine) {
        this.caiwubaozhangJine = caiwubaozhangJine;
    }
    /**
	 * 设置：报账理由
	 */
    public String getCaiwubaozhangContent() {
        return caiwubaozhangContent;
    }
    /**
	 * 获取：报账理由
	 */

    public void setCaiwubaozhangContent(String caiwubaozhangContent) {
        this.caiwubaozhangContent = caiwubaozhangContent;
    }
    /**
	 * 设置：财务报账申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：财务报账申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：管理员审核状态
	 */
    public Integer getCaiwubaozhangGuanliYesnoTypes() {
        return caiwubaozhangGuanliYesnoTypes;
    }
    /**
	 * 获取：管理员审核状态
	 */

    public void setCaiwubaozhangGuanliYesnoTypes(Integer caiwubaozhangGuanliYesnoTypes) {
        this.caiwubaozhangGuanliYesnoTypes = caiwubaozhangGuanliYesnoTypes;
    }
    /**
	 * 设置：管理员审核意见
	 */
    public String getCaiwubaozhangGuanliYesnoText() {
        return caiwubaozhangGuanliYesnoText;
    }
    /**
	 * 获取：管理员审核意见
	 */

    public void setCaiwubaozhangGuanliYesnoText(String caiwubaozhangGuanliYesnoText) {
        this.caiwubaozhangGuanliYesnoText = caiwubaozhangGuanliYesnoText;
    }
    /**
	 * 设置：管理员审核时间
	 */
    public Date getCaiwubaozhangGuanliYesnoTime() {
        return caiwubaozhangGuanliYesnoTime;
    }
    /**
	 * 获取：管理员审核时间
	 */

    public void setCaiwubaozhangGuanliYesnoTime(Date caiwubaozhangGuanliYesnoTime) {
        this.caiwubaozhangGuanliYesnoTime = caiwubaozhangGuanliYesnoTime;
    }
    /**
	 * 设置：经理审核状态
	 */
    public Integer getCaiwubaozhangYesnoTypes() {
        return caiwubaozhangYesnoTypes;
    }
    /**
	 * 获取：经理审核状态
	 */

    public void setCaiwubaozhangYesnoTypes(Integer caiwubaozhangYesnoTypes) {
        this.caiwubaozhangYesnoTypes = caiwubaozhangYesnoTypes;
    }
    /**
	 * 设置：经理审核意见
	 */
    public String getCaiwubaozhangYesnoText() {
        return caiwubaozhangYesnoText;
    }
    /**
	 * 获取：经理审核意见
	 */

    public void setCaiwubaozhangYesnoText(String caiwubaozhangYesnoText) {
        this.caiwubaozhangYesnoText = caiwubaozhangYesnoText;
    }
    /**
	 * 设置：经理审核时间
	 */
    public Date getCaiwubaozhangShenheTime() {
        return caiwubaozhangShenheTime;
    }
    /**
	 * 获取：经理审核时间
	 */

    public void setCaiwubaozhangShenheTime(Date caiwubaozhangShenheTime) {
        this.caiwubaozhangShenheTime = caiwubaozhangShenheTime;
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
        return "Caiwubaozhang{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", caiwubaozhangName=" + caiwubaozhangName +
            ", caiwubaozhangTypes=" + caiwubaozhangTypes +
            ", caiwubaozhangFile=" + caiwubaozhangFile +
            ", caiwubaozhangJine=" + caiwubaozhangJine +
            ", caiwubaozhangContent=" + caiwubaozhangContent +
            ", insertTime=" + insertTime +
            ", caiwubaozhangGuanliYesnoTypes=" + caiwubaozhangGuanliYesnoTypes +
            ", caiwubaozhangGuanliYesnoText=" + caiwubaozhangGuanliYesnoText +
            ", caiwubaozhangGuanliYesnoTime=" + caiwubaozhangGuanliYesnoTime +
            ", caiwubaozhangYesnoTypes=" + caiwubaozhangYesnoTypes +
            ", caiwubaozhangYesnoText=" + caiwubaozhangYesnoText +
            ", caiwubaozhangShenheTime=" + caiwubaozhangShenheTime +
            ", createTime=" + createTime +
        "}";
    }
}
