package com.geeklink.gateway.module.example.peripheral;

import com.geeklink.gateway.module.define.PeripheralInfo;

import java.util.ArrayList;
import java.util.List;

class PeripheralStateUtils {

    static List<String> getPeripheralDetailStringMain(PeripheralInfo peripheralInfo) {
        ArrayList<String> peripheralDetail = new ArrayList<>();
        peripheralDetail.add("PeripheralId:"+peripheralInfo.getPeripheralId());
        peripheralDetail.add("PeripheralType:"+peripheralInfo.getPeripheralType());
        peripheralDetail.add("Online:"+peripheralInfo.getOnline());
        return peripheralDetail;
    }
    
    static List<String> getPeripheralDetailStringState(PeripheralInfo peripheralInfo) {
        ArrayList<String> peripheralDetail = new ArrayList<>();
        switch (peripheralInfo.getPeripheralType()) {
            case RELAY:
            case RELAY_BETTER:
                peripheralDetail.add("RelayBattery:"+peripheralInfo.getRelayBattery()*10+"%");
                peripheralDetail.add("RelayTemperature:"+peripheralInfo.getRelayTemperature()+"℃");
                peripheralDetail.add("RelayHumidity:"+peripheralInfo.getRelayHumidity()+"%");
                break;
            case THI_SENSOR:
                peripheralDetail.add("RelayTemperature:"+peripheralInfo.getRelayTemperature()+"℃");
                peripheralDetail.add("RelayHumidity:"+peripheralInfo.getRelayHumidity()+"%");
                peripheralDetail.add("THIIllumination:"+peripheralInfo.getTHIIllumination()+"LUX");
                break;

            case FEEDBACK_OUTLET:
            case FEEDBACK_SWITCH_1:
            case FEEDBACK_SWITCH_NEUTRAL_1:
            case FEEDBACK_SWITCH_WITH_SCENARIO_1:
            case CARD_MODULE:
                peripheralDetail.add("SwitchA:"+(peripheralInfo.getSwitchA()?"ON":"OFF"));
                break;
            case FEEDBACK_SWITCH_2:
            case FEEDBACK_SWITCH_NEUTRAL_2:
            case FEEDBACK_SWITCH_WITH_SCENARIO_2:
                peripheralDetail.add("SwitchA:"+(peripheralInfo.getSwitchA()?"ON":"OFF"));
                peripheralDetail.add("SwitchB:"+(peripheralInfo.getSwitchB()?"ON":"OFF"));
                break;
            case FEEDBACK_SWITCH_3:
            case FEEDBACK_SWITCH_NEUTRAL_3:
            case FEEDBACK_SWITCH_WITH_SCENARIO_3:
                peripheralDetail.add("SwitchA:"+(peripheralInfo.getSwitchA()?"ON":"OFF"));
                peripheralDetail.add("SwitchB:"+(peripheralInfo.getSwitchB()?"ON":"OFF"));
                peripheralDetail.add("SwitchC:"+(peripheralInfo.getSwitchC()?"ON":"OFF"));
                break;
            case IO_MODULE:
            case IO_MODULE_NEUTRAL:
            case FEEDBACK_SWITCH_4_SCENARIO_2:
                peripheralDetail.add("SwitchA:"+(peripheralInfo.getSwitchA()?"ON":"OFF"));
                peripheralDetail.add("SwitchB:"+(peripheralInfo.getSwitchB()?"ON":"OFF"));
                peripheralDetail.add("SwitchC:"+(peripheralInfo.getSwitchC()?"ON":"OFF"));
                peripheralDetail.add("SwitchD:"+(peripheralInfo.getSwitchD()?"ON":"OFF"));
                break;
            case CONNECT_MODULE:
                peripheralDetail.add("SwitchA:"+(peripheralInfo.getSwitchA()?"ON":"OFF"));
                peripheralDetail.add("SwitchB:"+(peripheralInfo.getSwitchB()?"ON":"OFF"));
                peripheralDetail.add("SwitchC:"+(peripheralInfo.getSwitchC()?"ON":"OFF"));
                peripheralDetail.add("SwitchD:"+(peripheralInfo.getSwitchD()?"ON":"OFF"));
                peripheralDetail.add("SwitchE:"+(peripheralInfo.getSwitchE()?"ON":"OFF"));
                peripheralDetail.add("SwitchF:"+(peripheralInfo.getSwitchF()?"ON":"OFF"));
                peripheralDetail.add("SwitchG:"+(peripheralInfo.getSwitchG()?"ON":"OFF"));
                peripheralDetail.add("SwitchH:"+(peripheralInfo.getSwitchH()?"ON":"OFF"));
                break;

            case DOOR_SENSOR:
            case MOTION_SENSOR:
            case WATER_LEAK_SENSOR:
            case SMOKE_SENSOR:
            case SHAKE_SENSOR:
                peripheralDetail.add("SensorBattery:"+peripheralInfo.getSensorBattery()*20+"%");
                peripheralDetail.add("SensorState:"+(peripheralInfo.getSensorState()?"Triggered":"No Triggered"));
                break;

            case DOOR_LOCK_V1:
                peripheralDetail.add("DoorLockV1Battery:"+(peripheralInfo.getDoorLockV1Battery()==0x00?"High":"Low"));
                peripheralDetail.add("DoorLockV1State:"+(peripheralInfo.getDoorLockV1State()==0x01?"Unlocked":"Locked"));
                break;

            case DOOR_LOCK_V2:
                peripheralDetail.add("DoorLockV2Battery:"+peripheralInfo.getDoorLockV2Battery()+"%");
                peripheralDetail.add("DoorLockV2State:"+(peripheralInfo.getDoorLockV2State()==0x01?"Unlocked":"Locked"));
                break;

            case CURTAIN:
                peripheralDetail.add("CurtainState:"+peripheralInfo.getCurtainState()+"%");
                break;
            case MANIPULATOR:
                peripheralDetail.add("ManipulatorState:"+(peripheralInfo.getManipulatorState()?"ON":"OFF"));
                break;

            case THERMOSTAT:
                String speed = "LOW";
                switch (peripheralInfo.getThermostatState().getSpeed()) {
                    case 0x02:
                        speed = "MED";
                        break;
                    case 0x03:
                        speed = "HI";
                        break;
                }
                peripheralDetail.add("Power:"+(peripheralInfo.getThermostatState().getPower()?"ON":"OFF"));
                peripheralDetail.add("Mode:"+(peripheralInfo.getThermostatState().getMode()==0?"Cold":"Hot"));
                peripheralDetail.add("Speed:"+speed);
                peripheralDetail.add("Temperature:"+peripheralInfo.getThermostatState().getTemperature()+"℃");
                peripheralDetail.add("RoomTemperature:"+peripheralInfo.getThermostatState().getRoomTemperature()+"℃");
                break;

            case SCENE_SWITCH_1:
            case SCENE_SWITCH_4:
            case SECURITY_RC:
            case SIREN:
            default:
                break;
        }
        return peripheralDetail;
    }
}
