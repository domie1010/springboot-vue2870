package com.entity.view;

import com.entity.GongwenEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 公文
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("gongwen")
public class GongwenView extends GongwenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 部门的值
		*/
		private String bumenValue;
		/**
		* 公文类型的值
		*/
		private String gongwenValue;



		//级联表 jingli
			/**
			* 经理编号
			*/
			private String jingliUuidNumber;
			/**
			* 经理姓名
			*/
			private String jingliName;
			/**
			* 经理手机号
			*/
			private String jingliPhone;
			/**
			* 经理身份证号
			*/
			private String jingliIdNumber;
			/**
			* 经理头像
			*/
			private String jingliPhoto;
			/**
			* 电子邮箱
			*/
			private String jingliEmail;

	public GongwenView() {

	}

	public GongwenView(GongwenEntity gongwenEntity) {
		try {
			BeanUtils.copyProperties(this, gongwenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 部门的值
			*/
			public String getBumenValue() {
				return bumenValue;
			}
			/**
			* 设置： 部门的值
			*/
			public void setBumenValue(String bumenValue) {
				this.bumenValue = bumenValue;
			}
			/**
			* 获取： 公文类型的值
			*/
			public String getGongwenValue() {
				return gongwenValue;
			}
			/**
			* 设置： 公文类型的值
			*/
			public void setGongwenValue(String gongwenValue) {
				this.gongwenValue = gongwenValue;
			}
















				//级联表的get和set jingli

					/**
					* 获取： 经理编号
					*/
					public String getJingliUuidNumber() {
						return jingliUuidNumber;
					}
					/**
					* 设置： 经理编号
					*/
					public void setJingliUuidNumber(String jingliUuidNumber) {
						this.jingliUuidNumber = jingliUuidNumber;
					}

					/**
					* 获取： 经理姓名
					*/
					public String getJingliName() {
						return jingliName;
					}
					/**
					* 设置： 经理姓名
					*/
					public void setJingliName(String jingliName) {
						this.jingliName = jingliName;
					}

					/**
					* 获取： 经理手机号
					*/
					public String getJingliPhone() {
						return jingliPhone;
					}
					/**
					* 设置： 经理手机号
					*/
					public void setJingliPhone(String jingliPhone) {
						this.jingliPhone = jingliPhone;
					}

					/**
					* 获取： 经理身份证号
					*/
					public String getJingliIdNumber() {
						return jingliIdNumber;
					}
					/**
					* 设置： 经理身份证号
					*/
					public void setJingliIdNumber(String jingliIdNumber) {
						this.jingliIdNumber = jingliIdNumber;
					}

					/**
					* 获取： 经理头像
					*/
					public String getJingliPhoto() {
						return jingliPhoto;
					}
					/**
					* 设置： 经理头像
					*/
					public void setJingliPhoto(String jingliPhoto) {
						this.jingliPhoto = jingliPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getJingliEmail() {
						return jingliEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setJingliEmail(String jingliEmail) {
						this.jingliEmail = jingliEmail;
					}














}
