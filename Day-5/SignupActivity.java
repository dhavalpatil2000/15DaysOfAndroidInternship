package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class SignupActivity extends AppCompatActivity {
    EditText name,email,contact,password,cnfpassword,dob;
    ImageView ivCalendar;
    Spinner citySpinner,stateSpinner;
    Button btnLogin,btnSignup;
    RadioButton rbMale,rbFemale,rbTransgender;
    ImageView ivHide,ivShow,ivcnfShow,ivcnfHide;
    String selected_city;
    //String [] cityList={"Ahmedabad","Surat","Rajkot","GandhiNagar"};
    ArrayList<String> stateArraylist;
    ArrayList<String> cityArraylist;
    Calendar calendar;
    String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String passwordPattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Sign Up");
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.etSignupName);
        email=findViewById(R.id.etSignupEmail);
        contact=findViewById(R.id.etSignupContact);
        password=findViewById(R.id.etPassword);
        cnfpassword=findViewById(R.id.etConfirmPassword);
        dob=findViewById(R.id.etDOB);
        citySpinner=findViewById(R.id.signupCity);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        stateSpinner=findViewById(R.id.signupState);
        ivCalendar=findViewById(R.id.ivCalendar);
        ivcnfHide=findViewById(R.id.ivcnfHide);
        ivcnfShow=findViewById(R.id.ivcnfShow);
        ivHide =findViewById(R.id.ivHide);
        ivShow =findViewById(R.id.ivShow);
        RadioGroup gender;
        gender=findViewById(R.id.rgGender);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int a=radioGroup.getCheckedRadioButtonId();
                RadioButton b=findViewById(a);
                Toast.makeText(SignupActivity.this, b.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });


        ivHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivHide.setVisibility(View.GONE);
                ivShow.setVisibility(View.VISIBLE);
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });

        ivShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivShow.setVisibility(View.GONE);
                ivHide.setVisibility(View.VISIBLE);
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        });

        ivcnfHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivcnfHide.setVisibility(View.GONE);
                ivcnfShow.setVisibility(View.VISIBLE);
                cnfpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });

        ivcnfShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivcnfShow.setVisibility(View.GONE);
                ivcnfHide.setVisibility(View.VISIBLE);
                cnfpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        });


        calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR,i);
                calendar.set(Calendar.MONTH,i1);
                calendar.set(Calendar.DAY_OF_MONTH,i2);

                SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                dob.setText(dateFormat.format(calendar.getTime()));

            }
        };

        ivCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog=new DatePickerDialog(SignupActivity.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                dialog.show();

            }
        });


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().trim().equals("")){
                    name.setError("Name Required!");
                }
                else if(email.getText().toString().trim().equals("")){
                    email.setError("Email required!");
                } else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("Valid Email Required!");
                } else if (!(contact.getText().toString().trim().length()==10)) {
                    contact.setError("Enter Valid Phone Number");
                } else if (!password.getText().toString().trim().matches(passwordPattern)) {
                    password.setError("Enter Valid Password Format!");
                }
                else if (!cnfpassword.getText().toString().equals(password.getText().toString())) {
                    cnfpassword.setError("Password Not Matched!");
                } else if (dob.getText().toString().trim().equals("")) {
                    dob.setError("Enter DOB!");
                }
                else if (gender.getCheckedRadioButtonId()==-1){
                    Toast.makeText(SignupActivity.this, "Select Gender!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignupActivity.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                }
             /*   Intent i=new Intent(SignupActivity.this,SignupDataDisplay.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("contact",contact.getText().toString());
                i.putExtra("dob",dob.getText().toString());
                int id=gender.getCheckedRadioButtonId();
                RadioButton b=findViewById(id);
                i.putExtra("gender",b.getText());
                i.putExtra("city",selected_city);
                startActivity(i);
*/
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
      /*  rbMale=findViewById(R.id.rbMale);
        rbFemale=findViewById(R.id.rbFemale);
        rbTransgender=findViewById(R.id.rbTransgender);*/

       /* rbMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this, "Male", Toast.LENGTH_SHORT).show();
            }
        });
        rbFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this, "Female", Toast.LENGTH_SHORT).show();
            }
        });
        rbTransgender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignupActivity.this, "Transgender", Toast.LENGTH_SHORT).show();
            }
        });*/

        stateArraylist= new ArrayList<>();
        stateArraylist.add("Gujarat");
        stateArraylist.add("Maharastra");
        stateArraylist.add("Rajasthan");



        ArrayAdapter stateAdapter=new ArrayAdapter(SignupActivity.this, android.R.layout.simple_list_item_1,stateArraylist);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        stateSpinner.setAdapter(stateAdapter);
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s=stateArraylist.get(i);
                Toast.makeText(SignupActivity.this, s, Toast.LENGTH_SHORT).show();
                setCityData(i);
            }

            private void setCityData(int i) {
                cityArraylist=new ArrayList<>();
                if(i==0){
                    cityArraylist.add("Ahmedabad");
                    cityArraylist.add("Gandhinagar");
                    cityArraylist.add("Rajkot");

                }
                if(i==1){
                    cityArraylist.add("Mumbai");
                    cityArraylist.add("Pune");
                    cityArraylist.add("Dhule");
                }
                if (i == 2) {
                    cityArraylist.add("Udaipur");
                    cityArraylist.add("Jaipur");
                }
                ArrayAdapter cityAdapter=new ArrayAdapter(SignupActivity.this, android.R.layout.simple_list_item_1,cityArraylist);
                cityAdapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                citySpinner.setAdapter(cityAdapter);

                citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String s=adapterView.getItemAtPosition(i).toString();
                        selected_city=s;
                        Toast.makeText(SignupActivity.this,s,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


       /* ArrayAdapter adapter=new ArrayAdapter(SignupActivity.this, android.R.layout.simple_list_item_1,cityList);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        city.setAdapter(adapter);


        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(SignupActivity.this, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
*/
    }
}