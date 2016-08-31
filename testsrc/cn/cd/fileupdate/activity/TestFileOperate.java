package cn.cd.fileupdate.activity;

import java.io.IOException;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;
import cn.cd.fileupdate.service.FileOperate;

/**
 * 使用JUnit测试框架测试
 * 
 * @since JDK 1.6
 * @version 1.0
 * @date 2013-10-13 上午10:01:50
 */
public class TestFileOperate extends AndroidTestCase {
	// Log日志标签
	private static final String TAG = "TestFileOperate";

	/**
	 * 测试读取私有文件内容
	 * 
	 * @throws IOException
	 */
	public void testRead() throws IOException {
		// 创建文件操作类对象
		FileOperate fileOperate = new FileOperate(this.getContext());
		String content = fileOperate.read("rw.txt");// 读取文件内容
		Log.i(TAG, content);// 使用Log打印内容
	}

	/**
	 * 测试创建Private模式 只能被本应用访问 新写入的内容会覆盖原来的内容
	 * 
	 * @throws IOException
	 */
	public void testSavePrivate() throws IOException {
		// 创建文件操作类对象
		FileOperate fileOperate = new FileOperate(this.getContext());
		// 测试写入数据
		fileOperate.saveContent("private.txt", "Private模式文件",
				Context.MODE_PRIVATE);
		// 再次写入内容
		fileOperate.saveContent("private.txt", "S-H-U", Context.MODE_PRIVATE);
	}

	/**
	 * 测试创建Append模式 只能被本应用访问 新写入的内容会追加到原来的后面
	 * 
	 * @throws IOException
	 */
	public void testSaveAppend() throws IOException {
		// 创建文件操作类对象
		FileOperate fileOperate = new FileOperate(this.getContext());
		// 测试写入数据
		fileOperate
				.saveContent("append.txt", "Append模式文件", Context.MODE_APPEND);
		// 再次写入数据
		fileOperate.saveContent("append.txt", "S-H-U", Context.MODE_APPEND);
	}

	/**
	 * 创建测试WORLD_WRITEABLE模式 
	 * 本应用可以读写 
	 * 允许其它应用进行文件的写入(不能读) 
	 * 新写入的内容会覆盖原来
	 * 
	 * @throws IOException
	 */
	public void testSaveWriteable() throws IOException {
		// 创建文件操作类对象
		FileOperate fileOperate = new FileOperate(this.getContext());
		// 测试写入数据
		fileOperate.saveContent("writeable.txt", "WORLD_WRITEABLE模式文件",
				Context.MODE_WORLD_WRITEABLE);
		// 再次写入数据
		fileOperate.saveContent("writeable.txt", "S-H-U",
				Context.MODE_WORLD_WRITEABLE);
	}

	/**
	 * 创建测试WORLD_READABLE模式 
	 * 本应用可以读写 
	 * 允许其它应用进行文件的读取(不能写) 
	 * 新写入的内容会覆盖原来的内容
	 * 
	 * @throws IOException
	 */
	public void testSaveReadable() throws IOException {
		// 创建文件操作类对象
		FileOperate fileOperate = new FileOperate(this.getContext());
		// 测试写入数据
		fileOperate.saveContent("readable.txt", "WORLD_READABLE模式文件",
				Context.MODE_WORLD_READABLE);
		// 再次写入数据
		fileOperate.saveContent("readable.txt", "S-H-U",
				Context.MODE_WORLD_READABLE);
	}

	/**
	 * 创建测试WORLD_READABLE和WORLD_WRITEABLE模式 
	 * 权限叠加的方式 本应用可以读写 
	 * 允许其它应用进行文件的读取和写入
	 * 新写入的内容会覆盖原来
	 * 
	 * @throws IOException
	 */
	public void testSaveRW() throws IOException {
		// 创建文件操作类对象
		FileOperate fileOperate = new FileOperate(this.getContext());
		// 测试写入数据
		fileOperate.saveContent("rw.txt", "WORLD_WRITEABLE+WORLD_READABLE模式文件",
				Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
		// 再次写入数据
		fileOperate.saveContent("rw.txt", "S-H-U", Context.MODE_WORLD_READABLE
				+ Context.MODE_WORLD_WRITEABLE);
	}
	/**
	 * 测试获取程序路径的根目录
	 */
	public void testGetFilesDir(){
		//创建文件操作类对象
		FileOperate fileOperate = new FileOperate(this.getContext());
		//获取程序路径跟目录
		String filesDir = fileOperate.getFilesDir();
		Log.i(TAG, filesDir);//打印
	}
	/**
	 * 测试获取程序路径的Cache目录
	 */
	public void testGetCacheDir(){
		//创建文件操作类对象
		FileOperate fileOperate = new FileOperate(this.getContext());
		//获取程序路径跟目录
		String filesDir = fileOperate.getCacheDir();
		Log.i(TAG, filesDir);//打印
	}
}
