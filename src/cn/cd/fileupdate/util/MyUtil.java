package cn.cd.fileupdate.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 工具类
 * 
 * @author 舒浩然
 * @since JDK 1.6
 * @version 1.0
 * @date 2013-10-15 下午10:02:51
 */
public class MyUtil {
	/**
	 * 使用Toast显示提示信息
	 * @param context
	 * @param text
	 */
	public static void showMsg(Context context,String text){
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
}
