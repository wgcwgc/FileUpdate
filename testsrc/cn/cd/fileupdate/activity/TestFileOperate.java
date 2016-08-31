package cn.cd.fileupdate.activity;

import java.io.IOException;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;
import cn.cd.fileupdate.service.FileOperate;

/**
 * ʹ��JUnit���Կ�ܲ���
 * 
 * @since JDK 1.6
 * @version 1.0
 * @date 2013-10-13 ����10:01:50
 */
public class TestFileOperate extends AndroidTestCase {
	// Log��־��ǩ
	private static final String TAG = "TestFileOperate";

	/**
	 * ���Զ�ȡ˽���ļ�����
	 * 
	 * @throws IOException
	 */
	public void testRead() throws IOException {
		// �����ļ����������
		FileOperate fileOperate = new FileOperate(this.getContext());
		String content = fileOperate.read("rw.txt");// ��ȡ�ļ�����
		Log.i(TAG, content);// ʹ��Log��ӡ����
	}

	/**
	 * ���Դ���Privateģʽ ֻ�ܱ���Ӧ�÷��� ��д������ݻḲ��ԭ��������
	 * 
	 * @throws IOException
	 */
	public void testSavePrivate() throws IOException {
		// �����ļ����������
		FileOperate fileOperate = new FileOperate(this.getContext());
		// ����д������
		fileOperate.saveContent("private.txt", "Privateģʽ�ļ�",
				Context.MODE_PRIVATE);
		// �ٴ�д������
		fileOperate.saveContent("private.txt", "S-H-U", Context.MODE_PRIVATE);
	}

	/**
	 * ���Դ���Appendģʽ ֻ�ܱ���Ӧ�÷��� ��д������ݻ�׷�ӵ�ԭ���ĺ���
	 * 
	 * @throws IOException
	 */
	public void testSaveAppend() throws IOException {
		// �����ļ����������
		FileOperate fileOperate = new FileOperate(this.getContext());
		// ����д������
		fileOperate
				.saveContent("append.txt", "Appendģʽ�ļ�", Context.MODE_APPEND);
		// �ٴ�д������
		fileOperate.saveContent("append.txt", "S-H-U", Context.MODE_APPEND);
	}

	/**
	 * ��������WORLD_WRITEABLEģʽ 
	 * ��Ӧ�ÿ��Զ�д 
	 * ��������Ӧ�ý����ļ���д��(���ܶ�) 
	 * ��д������ݻḲ��ԭ��
	 * 
	 * @throws IOException
	 */
	public void testSaveWriteable() throws IOException {
		// �����ļ����������
		FileOperate fileOperate = new FileOperate(this.getContext());
		// ����д������
		fileOperate.saveContent("writeable.txt", "WORLD_WRITEABLEģʽ�ļ�",
				Context.MODE_WORLD_WRITEABLE);
		// �ٴ�д������
		fileOperate.saveContent("writeable.txt", "S-H-U",
				Context.MODE_WORLD_WRITEABLE);
	}

	/**
	 * ��������WORLD_READABLEģʽ 
	 * ��Ӧ�ÿ��Զ�д 
	 * ��������Ӧ�ý����ļ��Ķ�ȡ(����д) 
	 * ��д������ݻḲ��ԭ��������
	 * 
	 * @throws IOException
	 */
	public void testSaveReadable() throws IOException {
		// �����ļ����������
		FileOperate fileOperate = new FileOperate(this.getContext());
		// ����д������
		fileOperate.saveContent("readable.txt", "WORLD_READABLEģʽ�ļ�",
				Context.MODE_WORLD_READABLE);
		// �ٴ�д������
		fileOperate.saveContent("readable.txt", "S-H-U",
				Context.MODE_WORLD_READABLE);
	}

	/**
	 * ��������WORLD_READABLE��WORLD_WRITEABLEģʽ 
	 * Ȩ�޵��ӵķ�ʽ ��Ӧ�ÿ��Զ�д 
	 * ��������Ӧ�ý����ļ��Ķ�ȡ��д��
	 * ��д������ݻḲ��ԭ��
	 * 
	 * @throws IOException
	 */
	public void testSaveRW() throws IOException {
		// �����ļ����������
		FileOperate fileOperate = new FileOperate(this.getContext());
		// ����д������
		fileOperate.saveContent("rw.txt", "WORLD_WRITEABLE+WORLD_READABLEģʽ�ļ�",
				Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
		// �ٴ�д������
		fileOperate.saveContent("rw.txt", "S-H-U", Context.MODE_WORLD_READABLE
				+ Context.MODE_WORLD_WRITEABLE);
	}
	/**
	 * ���Ի�ȡ����·���ĸ�Ŀ¼
	 */
	public void testGetFilesDir(){
		//�����ļ����������
		FileOperate fileOperate = new FileOperate(this.getContext());
		//��ȡ����·����Ŀ¼
		String filesDir = fileOperate.getFilesDir();
		Log.i(TAG, filesDir);//��ӡ
	}
	/**
	 * ���Ի�ȡ����·����CacheĿ¼
	 */
	public void testGetCacheDir(){
		//�����ļ����������
		FileOperate fileOperate = new FileOperate(this.getContext());
		//��ȡ����·����Ŀ¼
		String filesDir = fileOperate.getCacheDir();
		Log.i(TAG, filesDir);//��ӡ
	}
}
