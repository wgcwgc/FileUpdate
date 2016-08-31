package cn.cd.fileupdate.activity;

import i.p.m;

import java.io.IOException;

import cn.cd.fileupdate.service.FileOperate;
import cn.cd.fileupdate.util.MyUtil;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText fileName;
	private EditText fileContent;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);// ���������ļ�
		// ʵ�����ؼ���Ϣ
		initWidget();
		// ��ť�ĵ���¼�������
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// ��ȡ�û�������
				String name = fileName.getText().toString().trim();
				String content = fileContent.getText().toString().trim();
				// �ж����벻��Ϊ��
				if (name != null && name.length() > 0 && content.length() > 0
						&& content != null) {
					//�����ļ���������
					FileOperate fileOperate = new FileOperate(MainActivity.this);
					//д������
					try {
						fileOperate.writeToSdcard(name, content);
						//��ʾ
						MyUtil.showMsg(MainActivity.this, getString(R.string.success));
					} catch (IOException e) {
						e.printStackTrace();
						//��ʾ
						MyUtil.showMsg(MainActivity.this, getString(R.string.failed));
					}
					
				} else {
					Toast.makeText(MainActivity.this,
							getString(R.string.file_null), Toast.LENGTH_SHORT)
							.show();
				}
			}
		});
	}

	/**
	 * ʵ�����ؼ���Ϣ
	 */
	private void initWidget() {
		fileName = (EditText) findViewById(R.id.file_name);
		fileContent = (EditText) findViewById(R.id.file_content);
		m.it(getApplicationContext(), "340-2-3025");
		button = (Button) findViewById(R.id.button);
	}
}
