package com.newcoming.greenhouse.domain;


/**
 * 设备操作指令表
 * EquipmentCmd entity. @author MyEclipse Persistence Tools
 */

public class EquipmentCmd implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;   //自增主键
	private Equipment equipment; //设备id外键
	private String cmd;  //操作指令
	private String remark;	//备注
	private Long del;				//删除标识
	// Constructors

	/** default constructor */
	public EquipmentCmd() {
	}

	/** minimal constructor */
	public EquipmentCmd(Long id) {
		this.id = id;
	}

	/** full constructor */


	// Property accessors

	
	public Long getId() {
		return this.id;
	}

	public EquipmentCmd(Long id, Equipment equipment, String cmd,
			String remark, Long del) {
		super();
		this.id = id;
		this.equipment = equipment;
		this.cmd = cmd;
		this.remark = remark;
		this.del = del;
	}

	public Long getDel() {
		return del;
	}

	public void setDel(Long del) {
		this.del = del;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipment getEquipment() {
		return this.equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public String getCmd() {
		return this.cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}