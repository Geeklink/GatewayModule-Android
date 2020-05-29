package com.geeklink.gateway.module.example;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.geeklink.gateway.module.example.peripheral.PeripheralArrayAdapter;
import com.geeklink.gateway.module.example.peripheral.PeripheralSetUtils;
import com.geeklink.gateway.module.GatewayModuleSDK;
import com.geeklink.gateway.module.define.PeripheralInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GatewayModuleSDK.Observer {

    private PeripheralArrayAdapter adapter;
    private List<PeripheralInfo> peripheralInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ContentView 设置界面
        setContentView(R.layout.activity_main);

        //ListView 设置列表视图
        adapter = new PeripheralArrayAdapter(MainActivity.this, R.layout.layout_peripheral_item, peripheralInfoList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter.onItemClickListener);

        //SerialPort 设置串口路径，根据实际串口路径填写
        GatewayModuleSDK.setSerialPort("/dev/ttyS0");
        //Observer 设置回复处理
        GatewayModuleSDK.setObserver(this);
    }

    /**
     * Set Menu Item 设置选项菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * On Options Item Selected 选项被选中
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //MenuItem 菜单点击
        switch (item.getItemId()) {
            case R.id.action_add://Add 添加按钮
                PeripheralSetUtils.peripheralScan(this);
                break;
            case R.id.action_refresh://Refresh 刷新按钮
                refreshPeripheralList();
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * Refresh Peripheral List 刷新分机列表
     */
    public void refreshPeripheralList() {
        peripheralInfoList.clear();
        peripheralInfoList.addAll(GatewayModuleSDK.getPeripheralList());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPeripheralStateChange(Byte peripheralId) {
        refreshPeripheralList();
    }

    @Override
    public void onPeripheralListChange() {
        refreshPeripheralList();
    }
}
