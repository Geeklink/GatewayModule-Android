package com.geeklink.gateway.module.example.peripheral;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.geeklink.gateway.module.example.R;
import com.geeklink.gateway.module.define.PeripheralInfo;

import java.util.List;

public class PeripheralArrayAdapter extends ArrayAdapter<PeripheralInfo> {
    private Activity activity;
    private int resource;

    public PeripheralArrayAdapter(Activity activity, int resource, List<PeripheralInfo> objects){
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View view = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        //Get Peripheral Info 获取分机信息
        PeripheralInfo peripheralInfo = getItem(position);
        //Get TextView 获取文本
        TextView peripheral_message = view.findViewById(R.id.peripheral_message);
        //Set Text 设置文本
        if (peripheralInfo != null) {
            StringBuffer peripheralDetail = new StringBuffer();
            for (String string:
                    PeripheralStateUtils.getPeripheralDetailStringMain(peripheralInfo)) {
                peripheralDetail.append(string);
                peripheralDetail.append(" ");
            }
            peripheralDetail.append("\n");
            for (String string:
                    PeripheralStateUtils.getPeripheralDetailStringState(peripheralInfo)) {
                peripheralDetail.append(string);
                peripheralDetail.append(" ");
            }
            peripheral_message.setText(peripheralDetail);
        }
        return view;
    }

    /**
     * On Item Click 点击事件
     */
    public AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Get Peripheral Info 获取分机信息
            final PeripheralInfo peripheralInfo = getItem(position);
            if (peripheralInfo != null) {
                //Get Peripheral Detail 获取分机详情文本
                StringBuffer peripheralDetail = new StringBuffer();
                for (String string:
                     PeripheralStateUtils.getPeripheralDetailStringMain(peripheralInfo)) {
                    peripheralDetail.append(string);
                    peripheralDetail.append("\n");
                }
                for (String string:
                        PeripheralStateUtils.getPeripheralDetailStringState(peripheralInfo)) {
                    peripheralDetail.append(string);
                    peripheralDetail.append("\n");
                }

                //Set Alert Dialog 设置弹窗
                AlertDialog.Builder builder = new AlertDialog.Builder(activity)
                        .setTitle("Peripheral Detail")
                        .setMessage(peripheralDetail)
                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PeripheralSetUtils.peripheralDelete(activity, peripheralInfo);
                            }
                        });

                //Set On Click Listener 设置控制动作
                switch (peripheralInfo.getPeripheralType()) {
                    case FEEDBACK_OUTLET:
                    case FEEDBACK_SWITCH_1:
                    case FEEDBACK_SWITCH_NEUTRAL_1:
                    case FEEDBACK_SWITCH_WITH_SCENARIO_1:
                    case FEEDBACK_SWITCH_2:
                    case FEEDBACK_SWITCH_NEUTRAL_2:
                    case FEEDBACK_SWITCH_WITH_SCENARIO_2:
                    case FEEDBACK_SWITCH_3:
                    case FEEDBACK_SWITCH_NEUTRAL_3:
                    case FEEDBACK_SWITCH_WITH_SCENARIO_3:
                    case IO_MODULE:
                    case IO_MODULE_NEUTRAL:
                    case FEEDBACK_SWITCH_4_SCENARIO_2:
                        builder.setPositiveButton("Control Switch", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PeripheralControlUtils.controlSwitch(activity, peripheralInfo);
                            }
                        });
                        break;
                    case CURTAIN:
                        builder.setPositiveButton("Control Curtain", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PeripheralControlUtils.controlCurtain(activity, peripheralInfo);
                            }
                        });
                        break;
                    case THERMOSTAT:
                        builder.setPositiveButton("Control Thermostat", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PeripheralControlUtils.controlThermostat(activity, peripheralInfo);
                            }
                        });
                        break;
                    case DOOR_LOCK_V1:
                    case DOOR_LOCK_V2:
                        builder.setPositiveButton("Control Door Lock", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PeripheralControlUtils.controlDoorLock(activity, peripheralInfo);
                            }
                        });
                        break;
                    case MANIPULATOR:
                        builder.setPositiveButton("Control Manipulator", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PeripheralControlUtils.controlManipulator(activity, peripheralInfo);
                            }
                        });
                        break;
                }
                //Alert Dialog Show 显示弹窗
                builder.create().show();
            }
        }
    };
}
