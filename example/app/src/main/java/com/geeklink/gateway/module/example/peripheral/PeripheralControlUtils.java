package com.geeklink.gateway.module.example.peripheral;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;

import com.geeklink.gateway.module.define.CurtainControlType;
import com.geeklink.gateway.module.define.PeripheralInfo;
import com.geeklink.gateway.module.define.StatusType;
import com.geeklink.gateway.module.define.SwitchControlInfo;
import com.geeklink.gateway.module.define.SwitchControlType;
import com.geeklink.gateway.module.define.ThermostatState;
import com.geeklink.gateway.module.example.R;
import com.geeklink.gateway.module.task.ControlRequestTask;

class PeripheralControlUtils {

    /**
     * Control Curtain控制窗帘
     */
    static void controlCurtain(final Activity activity, final PeripheralInfo peripheralInfo) {

        View view = View.inflate(activity, R.layout.layout_alert_content_curtain, null);
        final Spinner spinnerType = view.findViewById(R.id.spinner_type);
        final Spinner spinnerProgress = view.findViewById(R.id.spinner_progress);

        new AlertDialog.Builder(activity)
                .setTitle("Control Curtain")
                .setMessage("Please set a control state")
                .setView(view)
                .setPositiveButton("Control", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        CurtainControlType controlType = CurtainControlType.values()[spinnerType.getSelectedItemPosition()];
                        int progress = 0;
                        if (controlType == CurtainControlType.PROGRESS) {
                            progress = spinnerProgress.getSelectedItemPosition()*10;
                        }
                        new ControlRequestTask(activity, peripheralInfo.getPeripheralId(), controlType, (byte)progress, getCallBack(activity)).execute("");
                    }
                })
                .create()
                .show();
    }

    /**
     * Control DoorLock控制门锁
     */
    static void controlDoorLock(final Activity activity, final PeripheralInfo peripheralInfo) {
        new AlertDialog.Builder(activity)
                .setTitle("Control Door Lock")
                .setPositiveButton("Unlock", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new ControlRequestTask(activity, peripheralInfo.getPeripheralId(), getCallBack(activity)).execute("");
                    }
                })
                .create()
                .show();
    }

    /**
     * Control Manipulator 控制机械手
     */
    static void controlManipulator(final Activity activity, final PeripheralInfo peripheralInfo) {
        new AlertDialog.Builder(activity)
                .setTitle("Control Manipulator")
                .setNegativeButton("ON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new ControlRequestTask(activity, peripheralInfo.getPeripheralId(), true, getCallBack(activity)).execute("");
                    }
                })
                .setPositiveButton("OFF", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new ControlRequestTask(activity, peripheralInfo.getPeripheralId(), false, getCallBack(activity)).execute("");
                    }
                })
                .create()
                .show();
    }

    /**
     * Control Thermostat 控制温控面板
     */
    static void controlThermostat(final Activity activity, final PeripheralInfo peripheralInfo) {

        View view = View.inflate(activity, R.layout.layout_alert_content_ac_panel, null);
        final Spinner spinnerPower = view.findViewById(R.id.spinner_power);
        final Spinner spinnerMode = view.findViewById(R.id.spinner_mode);
        final Spinner spinnerSpeed = view.findViewById(R.id.spinner_speed);
        final Spinner spinnerTemperature = view.findViewById(R.id.spinner_temperature);

        //设置当前状态
        spinnerPower.setSelection(peripheralInfo.getThermostatState().getPower()?1:0);
        spinnerMode.setSelection(peripheralInfo.getThermostatState().getMode());
        spinnerSpeed.setSelection(peripheralInfo.getThermostatState().getSpeed()-1);
        spinnerTemperature.setSelection(peripheralInfo.getThermostatState().getTemperature()-16);

        new AlertDialog.Builder(activity)
                .setTitle("Control Thermostat")
                .setMessage("Please set a control state")
                .setView(view)
                .setPositiveButton("Control", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        boolean power = spinnerPower.getSelectedItemPosition() == 1;
                        int mode = spinnerMode.getSelectedItemPosition();
                        int speed = spinnerSpeed.getSelectedItemPosition()+1;
                        int temperature = spinnerTemperature.getSelectedItemPosition()+16;

                        ThermostatState thermostatState = new ThermostatState(power, (byte)mode, (byte)speed, (byte)temperature, (byte)0);
                        new ControlRequestTask(activity, peripheralInfo.getPeripheralId(), thermostatState, getCallBack(activity)).execute("");
                    }
                })
                .create()
                .show();
    }

    /**
     * Control Switch 控制开关
     */
    static void controlSwitch(final Activity activity, final PeripheralInfo peripheralInfo) {

        View view = View.inflate(activity, R.layout.layout_alert_content_switch, null);
        final Spinner spinnerA = view.findViewById(R.id.spinner_a);
        final Spinner spinnerB = view.findViewById(R.id.spinner_b);
        final Spinner spinnerC = view.findViewById(R.id.spinner_c);
        final Spinner spinnerD = view.findViewById(R.id.spinner_d);

        new AlertDialog.Builder(activity)
                .setTitle("Control Switch")
                .setMessage("Please set a control state")
                .setView(view)
                .setPositiveButton("Control", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SwitchControlType switchA = SwitchControlType.values()[spinnerA.getSelectedItemPosition()];
                        SwitchControlType switchB = SwitchControlType.values()[spinnerB.getSelectedItemPosition()];
                        SwitchControlType switchC = SwitchControlType.values()[spinnerC.getSelectedItemPosition()];
                        SwitchControlType switchD = SwitchControlType.values()[spinnerD.getSelectedItemPosition()];
                        SwitchControlInfo switchControlInfo = new SwitchControlInfo(switchA, switchB, switchC, switchD);

                        new ControlRequestTask(activity, peripheralInfo.getPeripheralId(), switchControlInfo, getCallBack(activity)).execute("");
                    }
                })
                .create()
                .show();
    }

    private static ControlRequestTask.Callback getCallBack(final Context context) {
        return new ControlRequestTask.Callback() {
            @SuppressLint("ShowToast")
            @Override
            public void onResponse(StatusType status) {
                String result;
                switch (status) {
                    case SUCCEED:
                        result = "Control Succeed";
                        break;
                    case NOT_EXIST:
                        result = "Peripheral Not Exist";
                        break;
                    case TIMEOUT:
                        result = "Control Timeout";
                        break;
                    default:
                        result = "Control Failed";
                        break;
                }
                new AlertDialog.Builder(context)
                        .setTitle(result)
                        .setPositiveButton("OK", null)
                        .create()
                        .show();
            }
        };
    }
}
