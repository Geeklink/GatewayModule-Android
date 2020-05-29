package com.geeklink.gateway.module.example.peripheral;

import android.app.Activity;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.geeklink.gateway.module.task.DeleteRequestTask;
import com.geeklink.gateway.module.task.ScanRequestTask;
import com.geeklink.gateway.module.define.PeripheralInfo;
import com.geeklink.gateway.module.define.PeripheralType;
import com.geeklink.gateway.module.define.StatusType;

public class PeripheralSetUtils {

    /**
     * Peripheral Scan 分机扫描添加
     */
    public static void peripheralScan(final Activity activity) {
        Toast.makeText(activity, "Scan Start, Please Trigger The Device.", Toast.LENGTH_LONG).show();
        //扫描请求
        new ScanRequestTask(activity, new  ScanRequestTask.Callback() {
            @Override
            public void onResponse(StatusType status, byte peripheralId, PeripheralType peripheralType) {
                String message;
                switch (status) {
                    case SUCCEED:
                        message = "Peripheral Scan Succeed, PeripheralId:"+peripheralId+" PeripheralType:"+peripheralType;
                        break;
                    case TIMEOUT:
                        message = "Peripheral Scan Timeout";
                        break;
                    case ALREADY_EXIST:
                        message = "Peripheral Already Exist, PeripheralId:"+peripheralId;
                        break;
                    default:
                        message = "Peripheral Scan Failed";
                        break;
                }
                new AlertDialog.Builder(activity)
                        .setTitle("Scan Result")
                        .setMessage(message)
                        .setPositiveButton("OK", null)
                        .create().show();
            }
        }).execute("");
    }

    /**
     * Peripheral Delete 分机删除
     */
    static void peripheralDelete(final Activity activity, PeripheralInfo peripheralInfo) {
        //删除请求
        new DeleteRequestTask(activity, peripheralInfo.getPeripheralId(),  new DeleteRequestTask.Callback() {
            @Override
            public void onResponse(StatusType status) {
                String message;
                switch (status) {
                    case SUCCEED:
                        message = "Peripheral Delete Succeed";
                        break;
                    case TIMEOUT:
                        message = "Peripheral Delete Timeout";
                        break;
                    default:
                        message = "Peripheral Delete Failed";
                        break;
                }
                new AlertDialog.Builder(activity)
                        .setTitle("Delete Result")
                        .setMessage(message)
                        .setPositiveButton("OK", null)
                        .create().show();
            }
        }).execute("");
    }

}
