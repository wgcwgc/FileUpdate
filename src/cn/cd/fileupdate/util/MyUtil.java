package cn.cd.fileupdate.util;

import android.content.Context;
import android.widget.Toast;

/**
 * ������
 * 
 * @author ���Ȼ
 * @since JDK 1.6
 * @version 1.0
 * @date 2013-10-15 ����10:02:51
 */
public class MyUtil {
	/**
	 * ʹ��Toast��ʾ��ʾ��Ϣ
	 * @param context
	 * @param text
	 */
	public static void showMsg(Context context,String text){
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
}
