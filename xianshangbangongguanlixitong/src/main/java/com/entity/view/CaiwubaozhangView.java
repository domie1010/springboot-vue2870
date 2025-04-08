package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.CaiwubaozhangEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 财务报账
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("caiwubaozhang")
public class CaiwubaozhangView extends CaiwubaozhangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 财务报账类型的值
		*/
		private String caiwubaozhangValue;
		/**
		* 管理员审核状态的值
		*/
		private String caiwubaozhangGuanliYesnoValue;
		/**
		* 经理审核状态的值
		*/
		private String caiwubaozhangYesnoValue;



		//级联表 yonghu
			/**
			* 员工编号
			*/
			private String yonghuUuidNumber;
			/**
			* 员工姓名
			*/
			private String yonghuName;
			/**
			* 员工手机号
			*/
			private String yonghuPhone;
			/**
			* 员工身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 员工头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 部门
			*/
			private Integer bumenTypes;
				/**
				* 部门的值
				*/
				private String bumenValue;
			/**
			* 职位
			*/
			private Integer zhiweiTypes;
				/**
				* 职位的值
				*/
				private String zhiweiValue;

	public CaiwubaozhangView() {

	}

	public CaiwubaozhangView(CaiwubaozhangEntity caiwubaozhangEntity) {
		try {
			BeanUtils.copyProperties(this, caiwubaozhangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 财务报账类型的值
			*/
			public String getCaiwubaozhangValue() {
				return caiwubaozhangValue;
			}
			/**
			* 设置： 财务报账类型的值
			*/
			public void setCaiwubaozhangValue(String caiwubaozhangValue) {
				this.caiwubaozhangValue = caiwubaozhangValue;
			}
			/**
			* 获取： 管理员审核状态的值
			*/
			public String getCaiwubaozhangGuanliYesnoValue() {
				return caiwubaozhangGuanliYesnoValue;
			}
			/**
			* 设置： 管理员审核状态的值
			*/
			public void setCaiwubaozhangGuanliYesnoValue(String caiwubaozhangGuanliYesnoValue) {
				this.caiwubaozhangGuanliYesnoValue = caiwubaozhangGuanliYesnoValue;
			}
			/**
			* 获取： 经理审核状态的值
			*/
			public String getCaiwubaozhangYesnoValue() {
				return caiwubaozhangYesnoValue;
			}
			/**
			* 设置： 经理审核状态的值
			*/
			public void setCaiwubaozhangYesnoValue(String caiwubaozhangYesnoValue) {
				this.caiwubaozhangYesnoValue = caiwubaozhangYesnoValue;
			}


























				//级联表的get和set yonghu

					/**
					* 获取： 员工编号
					*/
					public String getYonghuUuidNumber() {
						return yonghuUuidNumber;
					}
					/**
					* 设置： 员工编号
					*/
					public void setYonghuUuidNumber(String yonghuUuidNumber) {
						this.yonghuUuidNumber = yonghuUuidNumber;
					}

					/**
					* 获取： 员工姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 员工手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 员工身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 员工头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 员工头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 部门
					*/
					public Integer getBumenTypes() {
						return bumenTypes;
					}
					/**
					* 设置： 部门
					*/
					public void setBumenTypes(Integer bumenTypes) {
						this.bumenTypes = bumenTypes;
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
					* 获取： 职位
					*/
					public Integer getZhiweiTypes() {
						return zhiweiTypes;
					}
					/**
					* 设置： 职位
					*/
					public void setZhiweiTypes(Integer zhiweiTypes) {
						this.zhiweiTypes = zhiweiTypes;
					}


						/**
						* 获取： 职位的值
						*/
						public String getZhiweiValue() {
							return zhiweiValue;
						}
						/**
						* 设置： 职位的值
						*/
						public void setZhiweiValue(String zhiweiValue) {
							this.zhiweiValue = zhiweiValue;
						}




}
