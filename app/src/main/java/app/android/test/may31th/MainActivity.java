package app.android.test.may31th;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvName, tvEmail;
    Button btCliick;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("May31th","onCreate()시작");

        setTitle("사용자 정보 입력");

        tvName = (TextView)this.findViewById(R.id.tvName);
        tvEmail = (TextView)this.findViewById(R.id.tvEmail);
        btCliick = (Button)this.findViewById(R.id.btClick);

        btCliick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("May31th","CLICK 버튼 클릭");

                dialogView = (View)View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                // dlg.setIcon(R.drawable.이름);
                dlg.setView(dialogView);

                // 다이얼로그 창에서 확인 버튼을 클릭 할 경우 실행되는 명령문
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dlgEdtName = (EditText)dialogView.findViewById(R.id.etDialog1);
                        dlgEdtEmail = (EditText)dialogView.findViewById(R.id.etDialog2);

                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dlgEdtEmail.getText().toString());

                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View)View.inflate(MainActivity.this, R.layout.toast1, null);
                        toastText = (TextView)toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다.");
                        toast.setView(toastView);
                        toast.show();

                    }
                });
                dlg.show();

            }
        }); // end of btCliick.setOnClickListener




    } // end of onCreate()

} // end of MainActivity
