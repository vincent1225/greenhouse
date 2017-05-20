package com.newcoming.greenhouse.base;

public final class SysConstants {

	/** 审核状态：1：一审通过；2：二审通过；3：审核退回 4：已提交； */
	public static final Integer AUDIT_FIRST_PASS = 1;
	public static final Integer AUDIT_SECOND_PASS = 2;
	public static final Integer AUDIT_NOTPASS = 3;
	public static final Integer AUDIT_SUBMIT = 4;
	/**
	 * 数据type类型0.实时数据 1.缓存数据2.压缩数据 
	 */
	public static final Long DATE_TYPE_REAL_TIME = 0L;
	public static final Long DATE_TYPE_HISTORY_TIME = 1L;
	public static final Long DATE_TYPE_MONTH_TIME = 2L;

	/**
	 * 删除标识 0.存在 1.以删除
	 */
	public static final Long DEL_NO = 0L;
	public static final Long DEL_YES = 1L;

	/**
	 * 设备类型 1.数据类型(传感器) 2.控制类型(卷帘等)
	 */
	public static final Long CTRL_EM = 2L;
	public static final Long SAMPLE_EM = 1L;

	/**
	 * 传感器类型: 01 空气温度数据 02 空气湿度数据 03 土壤温度数据 04 土壤湿度数据 05 光照强度数据 06 空气二氧化碳数据 07
	 * 空气氨气数据 08土壤ph数据
	 */

	public static final Integer SAMPLE_EM_AIRTEMPERATURESENSOR = 1; // 空气温度传感器个数
	public static final Integer SAMPLE_EM_AIRHUMIDITYSENSOR = 2; // 空气湿度传感器个数
	public static final Integer SAMPLE_EM_SOILTEMPERATURESENSOR = 3; // 土壤温度传感器个数
	public static final Integer SAMPLE_EM_SOILMOISTURESENSOR = 4; // 土壤湿度传感器个数
	public static final Integer SAMPLE_EM_LIGHTINTENSITYSENSOR = 5; // 光照强度数据传感器个数
	public static final Integer SAMPLE_EM_AIRCARBONDIOXIDESENSOR = 6; // 空气二氧化碳个数
	public static final Integer SAMPLE_EM_NITROGENAIRSENSOR = 7; // 空气氮气数据传感器个数
	public static final Integer SAMPLE_EM_SOILPH = 8; // 土壤PH数据传感器个数

	/**`
	 * 控制设备类型: 01 卷帘 02 室内灯光 03 人工补光 04 滴管 05 喷灌 06 通风
	 */

	public static final Integer CTRL_EM_SCREEN = 1; // 卷帘个数
	public static final Integer CTRL_EM_INDOORLIGHTING = 2; // 室内灯光
	public static final Integer CTRL_EM_ARTIFICIALLIGHTING = 3; // 人工补光
	public static final Integer CTRL_EM_DROPPER = 4; // 滴灌
	public static final Integer CTRL_EM_SPRINKLINGIRRIGATION = 5; // 喷灌
	public static final Integer CTRL_EM_AIRVENT = 6; // 通风

	/**
	 * 设备状态:0.开启1.关闭.2损坏
	 */
	public static final Integer EQUIPMENT_STATUS_ON = 0;
	public static final Integer EQUIPMENT_STATUS_OFF = 1;
	public static final Integer EQUIPMENT_STATUS_BREAKDOWN = 2;
}
