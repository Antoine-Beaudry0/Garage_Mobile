package com.example.garage_mobile2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import Classes.InterfaceServeur;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AjouterRDV#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AjouterRDV extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AjouterRDV() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AjouterRDV.
     */
    // TODO: Rename and change types and number of parameters
    public static AjouterRDV newInstance(String param1, String param2) {
        AjouterRDV fragment = new AjouterRDV();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ajouter_rdv, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etComment = view.findViewById(R.id.et_comment);
        TimePicker timePickerStart = view.findViewById(R.id.time_picker_start);
        TimePicker timePickerEnd = view.findViewById(R.id.time_picker_end);
        EditText etMonth = view.findViewById(R.id.et_month);
        EditText etYear = view.findViewById(R.id.et_day);
        Button btnSave = view.findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = etComment.getText().toString();
                int startHour = timePickerStart.getCurrentHour();
                int startMinute = timePickerStart.getCurrentMinute();
                String startTime = String.format(Locale.getDefault(), "%02d:%02d", startHour, startMinute);
                int endHour = timePickerEnd.getCurrentHour();
                int endMinute = timePickerEnd.getCurrentMinute();
                String endTime = String.format(Locale.getDefault(), "%02d:%02d", endHour, endMinute);

                String day = etYear.getText().toString();
                String month = etMonth.getText().toString();
                int dayInt = Integer.parseInt(day);
                if (dayInt < 1 || dayInt > 31) {
                    Toast.makeText(getContext(), "Le jour doit être compris entre 1 et 31", Toast.LENGTH_SHORT).show();
                    return;
                }
                int monthInt = Integer.parseInt(month);
                if (monthInt < 1 || monthInt > 12) {
                    Toast.makeText(getContext(), "Le mois doit être compris entre 1 et 12", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (endHour < startHour || (endHour == startHour && endMinute <= startMinute)) {
                    Toast.makeText(getContext(), "L'heure de fin doit être après l'heure de début", Toast.LENGTH_SHORT).show();
                    return;
                }

                String dateRDV = day + "/" + month;
                sendDataToApi(comment, dateRDV, startTime, endTime);
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.fromAddToEncours);
                Toast.makeText(getContext(), "Rendez-vous créé avec succès", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendDataToApi(String comment, String dateRDV, String startTime, String endTime) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.87.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONObject postData = new JSONObject();
        try {
            postData.put("comment", comment);
            postData.put("dateRDV", dateRDV);
            postData.put("start_time", startTime);
            postData.put("end_time", endTime);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), postData.toString());

        InterfaceServeur service = retrofit.create(InterfaceServeur.class);
        Call<ResponseBody> call = service.ajouterRDV(body);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {
                        String responseData = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    //
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}