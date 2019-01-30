package com.example.calculator_perfected;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Double fn,sn;
    String operation;

    EditText resultTxt;
    Button bClear, bback, bHistoriq,bdivision,
            bmultiplication, bsubstraction, baddition,
            bmoreorless, bpoint, bequals;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int tmp;
    private OperationDao operationDao;
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUIView();
        daoSession = ((GreendDAOapp) getApplication()).getDaoSession();
        operationDao = daoSession.getOperationDao();
        initTmp();

        bClear.setOnClickListener(this);
        bback.setOnClickListener(this);
        bHistoriq.setOnClickListener(this);
        bdivision.setOnClickListener(this);
        bmultiplication.setOnClickListener(this);
        bsubstraction.setOnClickListener(this);
        baddition.setOnClickListener(this);
        bmoreorless.setOnClickListener(this);
        bpoint.setOnClickListener(this);
        bequals.setOnClickListener(this);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    public void setUIView(){
        resultTxt = (EditText) findViewById(R.id.et);
        bClear = (Button) findViewById(R.id.clear);
        bback = (Button) findViewById(R.id.back);
        bHistoriq = (Button) findViewById(R.id.historiq);
        bdivision = (Button) findViewById(R.id.division);
        bmultiplication = (Button) findViewById(R.id.multiplication);
        bsubstraction = (Button) findViewById(R.id.soustraction);
        baddition = (Button) findViewById(R.id.addition);
        bmoreorless = (Button) findViewById(R.id.plusoumoins);
        bpoint = (Button) findViewById(R.id.point);
        bequals = (Button) findViewById(R.id.egale);
        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
    }

    public int initTmp(){
        List<Operation> operations = operationDao.loadAll();
        if (operations != null) {
            return tmp = operations.size();
        }
        else return 0;
    }

    public String historique(){
        List<Operation> operations = operationDao.loadAll();
        if(tmp > 1){
            tmp --;
            return operations.get(tmp-1).getOperation() +"";
        }
        else return "";
    }



    @Override
    public void onClick(View v) {
        String string = resultTxt.getText().toString();
        switch (v.getId()){
            case R.id.b0:
                resultTxt.setText(string+b0.getText());
                break;
            case R.id.b1:
                resultTxt.setText(string+b1.getText());
                break;
            case R.id.b2:
                resultTxt.setText(string+b2.getText());
                break;
            case R.id.b3:
                resultTxt.setText(string+b3.getText());
                break;
            case R.id.b4:
                resultTxt.setText(string+b4.getText());
                break;
            case R.id.b5:
                resultTxt.setText(string+b5.getText());
                break;
            case R.id.b6:
                resultTxt.setText(string+b6.getText());
                break;
            case R.id.b7:
                resultTxt.setText(string+b7.getText());
                break;
            case R.id.b8:
                resultTxt.setText(string+b8.getText());
                break;
            case R.id.b9:
                resultTxt.setText(string+b9.getText());
                break;
            case R.id.clear:
                resultTxt.setText("");
                break;
            case R.id.back:
                if (!string.equals("")){
                    StringBuilder stringBuilder = new StringBuilder(string);
                    stringBuilder.deleteCharAt(string.length()-1);
                    resultTxt.setText(stringBuilder);
                }
                break;
            case R.id.division:
                if (!resultTxt.getText().toString().equals("")){
                    operation = "/";
                    fn = Double.parseDouble(resultTxt.getText().toString());
                    resultTxt.setText("");
                }
                break;
            case R.id.multiplication:
                if (!resultTxt.getText().toString().equals("")){
                    operation = "*";
                    fn = Double.parseDouble(resultTxt.getText().toString());
                    resultTxt.setText("");
                }
                break;
            case R.id.soustraction:
                if (!resultTxt.getText().toString().equals("")){
                    operation = "-";
                    fn = Double.parseDouble(resultTxt.getText().toString());
                    resultTxt.setText("");
                }
                break;
            case R.id.addition:
                if (!resultTxt.getText().toString().equals("")){
                    operation = "+";
                    fn = Double.parseDouble(resultTxt.getText().toString());
                    resultTxt.setText("");
                }
                break;
            case R.id.plusoumoins:
                if (!resultTxt.getText().toString().equals("")){
                    resultTxt.setText(Double.parseDouble(resultTxt.getText().toString())*(-1)+"");
                }
                break;
            case R.id.historiq:
                resultTxt.setText( historique() );
                break;
            case R.id.egale:
                if (fn != null){
                    initTmp();
                    sn = Double.parseDouble(resultTxt.getText().toString());
                    double result=0.0;
                    switch (operation){
                        case "+":
                            result = fn+sn;
                            resultTxt.setText(result+"");
                            operationDao.insert(new Operation(result));
                            break;
                        case "-":
                            result = fn-sn;
                            resultTxt.setText(result+"");
                            operationDao.insert(new Operation(result));
                            break;
                        case "*":
                            result = fn*sn;
                            resultTxt.setText(result+"");
                            operationDao.insert(new Operation(result));
                            break;
                        case "/":
                            if(sn==0){
                                Toast.makeText(MainActivity.this, "Ne peut pas diviser par zéro", Toast.LENGTH_LONG).show();
                                resultTxt.setText("Erreur!");
                            }
                            else {
                                result = fn/sn;
                                resultTxt.setText(result+"");
                                operationDao.insert(new Operation(result));
                            }
                            break;
                        default: resultTxt.setText(sn+""); break;
                    }

                }
                break;
            case R.id.point:
                resultTxt.setText(string+bpoint.getText());
                break;

            default:
                resultTxt.setText("");
                break;
        }

    }
}
