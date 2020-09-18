package com.hufs.ces_201501968;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    EditText myEditText;

    Stack<Double> postfix = new Stack<>(); //후위연산을 위한 스택
    Stack<String> operator = new Stack<>(); //후위연산을 하기 전 연산자를 임시저장하기 위한 스택
    Deque<String> save = new ArrayDeque<>(); //후위연산을 하기 전 연산자와 피연산자를 저장하기 위한 스택

    Double getValue=0.0, result=0.0, value1, value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = (EditText) findViewById(R.id.number);
    }

    //숫자 1클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick1(View view){
        getValue=getValue*10+1.0;
        myEditText.setText(String.valueOf(getValue));
    }

    //숫자 2클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick2(View view){
        getValue=getValue*10+2.0;
        myEditText.setText(String.valueOf(getValue));
    }

    //숫자 3클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick3(View view){
        getValue=getValue*10+3.0;
        myEditText.setText(String.valueOf(getValue));
    }

    //숫자 4클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick4(View view){
        getValue=getValue*10+4.0;
        myEditText.setText(String.valueOf(getValue));
    }

    //숫자 5클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick5(View view){
        getValue=getValue*10+5.0;
        myEditText.setText(String.valueOf(getValue));
    }

    //숫자 6클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick6(View view){
        getValue=getValue*10+6.0;
        myEditText.setText(String.valueOf(getValue));
    }

    //숫자 7클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick7(View view){
        getValue=getValue*10+7.0;
        myEditText.setText(String.valueOf(getValue));
    }

    //숫자 8클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick8(View view){
        getValue=getValue*10+8.0;
        myEditText.setText(String.valueOf(getValue));
    }

    //숫자 9클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick9(View view){
        getValue=getValue*10+9.0;
        myEditText.setText(String.valueOf(getValue));
    }

    //숫자 0클릭 버튼
    //한 자리 이상의 숫자를 받기 위해 입력 할 때마다 value에 10을 곱하여 누른 버튼을 더해줌
    public void onClick0(View view){
        getValue=getValue*10;
        myEditText.setText(String.valueOf(getValue));
    }

    //덧셈 연산
    public void onClickPlus(View view){
        myEditText.setText("+");

        //연산자를 클릭하면 앞의 피연산자가 정해지므로 save에 저장 후 피연산자 변수 초기화
        save.add(String.valueOf(getValue));
        getValue=0.0;

        //중위연산자를 후위연산자로 변환해주기 위한 조건문
        //operator가 비어있을 때는 무조건 +저장
        // +는 사칙연산에서 우선순위가 가장 낮고 -와 같으므로 앞에 저장되어 있는 연산자를 save로 이동시킨 후 oprator에 저장
        if(operator.isEmpty())
            operator.add("+");
        else {
            save.add(operator.pop());
            operator.add("+");
        }
    }

    //뺄셈 연산
    public void onClickMinus(View view){
        Log.d("button test", "OnClickMinus");
        myEditText.setText("-");

        //연산자를 클릭하면 앞의 피연산자가 정해지므로 save에 저장 후 피연산자 변수 초기화
        save.add(String.valueOf(getValue));
        getValue=0.0;

        //중위연산자를 후위연산자로 변환해주기 위한 조건문
        //operator가 비어있을 때는 무조건 -저장
        // -는 사칙연산에서 우선순위가 가장 낮고 +와 같으므로 앞에 저장되어 있는 연산자를 save로 이동시킨 후 oprator에 저장
        if(operator.isEmpty())
            operator.add("-");
        else {
            save.add(operator.pop());
            operator.add("-");
        }
    }

    //곱셈 연산
    public void onClickMul(View view){
        Log.d("button test", "OnClickMul");
        myEditText.setText("*");

        //연산자를 클릭하면 앞의 피연산자가 정해지므로 save에 저장 후 피연산자 변수 초기화
        save.add(String.valueOf(getValue));
        getValue=0.0;

        //중위연산자를 후위연산자로 변환해주기 위한 조건문
        //operator가 비어있을 때는 무조건 *저장
        // *는 사칙연산에서 /와 같고 가장 높으므로 앞에 +와 -가 있으면 그 뒤에 저장
        // 앞에 *나 /가 있을 경우 해당 연산자를 save로 이동시킨 후 *를 oprator에 저장
        if(operator.isEmpty())
            operator.add("*");
        else if(operator.peek()=="+" || operator.peek()=="-")
            operator.add("*");
        else{
            save.add(operator.pop());
            operator.add("*");
        }
    }

    //나눗셈 연산
    public void onClickDiv(View view){
        Log.d("button test", "OnClickDiv");
        myEditText.setText("/");

        //연산자를 클릭하면 앞의 피연산자가 정해지므로 save에 저장 후 피연산자 변수 초기화
        save.add(String.valueOf(getValue));
        getValue=0.0;

        //중위연산자를 후위연산자로 변환해주기 위한 조건문
        //operator가 비어있을 때는 무조건 /저장
        // /는 사칙연산에서 *와 같고 가장 높으므로 앞에 +와 -가 있으면 그 뒤에 저장
        // 앞에 *나 /가 있을 경우 해당 연산자를 save로 이동시킨 후 /를 oprator에 저장
        if(operator.isEmpty())
            operator.add("/");
        else if(operator.peek()=="+" || operator.peek()=="-")
            operator.add("/");
        else{
            save.add(operator.pop());
            operator.add("/");
        }
    }

    //계산 결과 도출
    public void onClickOk(View view){

        //계산 결과를 도출하면 앞의 피연산자가 정해지므로 save에 저장 후 피연산자 변수 초기화
        save.add(String.valueOf(getValue));
        getValue=0.0;

        //남은 연산자를 모두 save에 순차적으로 저장
        while(!operator.isEmpty())
            save.add(operator.pop());

        //모든 값의 계산이 끝날 때 까지 반복
        while(!save.isEmpty()){

            //피연산자일 경우 모두 postfix에 저장
            if((save.peek()!="+") && (save.peek()!="-") && (save.peek()!="*") && (save.peek()!="/")){
                postfix.push(Double.valueOf(save.poll()));
            }
            //+를 만났을 경우
            else if(save.peek()=="+"){
                save.remove(); //+를 지우고
                //연산을 하기 위해 value에 저장
                value2=Double.valueOf(postfix.pop());
                value1=Double.valueOf(postfix.pop());
                result=value1+value2;
                //결과를 다시 postfix에 push
                postfix.push(result);
            }
            //-를 만났을 경우
            else if(save.element()=="-"){
                save.remove();//-를 지우고
                //연산을 하기 위해 value에 저장
                value2=Double.valueOf(postfix.pop());
                value1=Double.valueOf(postfix.pop());
                result=value1-value2;
                //결과를 다시 postfix에 push
                postfix.push(result);
            }
            //*를 만났을 경우
            else if(save.element()=="*"){
                save.remove();//*를 지우고
                //연산을 하기 위해 value에 저장
                value2=Double.valueOf(postfix.pop());
                value1=Double.valueOf(postfix.pop());
                result=value1*value2;
                //결과를 다시 postfix에 push
                postfix.push(result);
            }
            ///를 만났을 경우
            else if(save.element()=="/"){
                save.remove();///를 지우고
                value2=Double.valueOf(postfix.pop());
                value1=Double.valueOf(postfix.pop());
                result=value1/value2;
                //결과를 다시 postfix에 push
                postfix.push(result);
            }
        }
        //최종 결과 값 출력 및 연속 계산을 위한 값 입력
        getValue=postfix.peek();
        myEditText.setText(String.valueOf(postfix.pop()));

        //연속 계산을 위한 초기화
        result=0.0;
        value1=0.0;
        value2=0.0;

    }

    //모든 값을 초기화하여 다시 계산
    public void onClickClear(View view){
        getValue=0.0 ;
        result=0.0;
        value1=0.0;
        value2=0.0;

        while(!save.isEmpty())
            save.remove();
        postfix.removeAllElements();
        operator.removeAllElements();

        myEditText.setText("0");
    }

}
