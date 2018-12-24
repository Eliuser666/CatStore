package com.catstore.utils;

import java.util.UUID;

public class UUIDUtils {

	public static String getUUID(){
		//36位。由于数据库中设置了最长32位，需要将“-”替换为空
		return UUID.randomUUID().toString().replace("-", "");
		
	}
}
