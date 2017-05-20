package com.newcoming.greenhouse.util;

import java.math.BigDecimal;

public class MathUtil {
	
	/**四舍五入取整*/
	public static Double round0(Double d){
		BigDecimal bg = new BigDecimal(d);
        double result = bg.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
	}
	/**四舍五入保留两位小数*/
	public static Double round2(Double d){
		BigDecimal bg = new BigDecimal(d);
		double result = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}
}
