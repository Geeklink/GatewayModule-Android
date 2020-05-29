# ControlRequestTask.java

Peripheral Control Request

分机控制请求

## ControlRequestTask
| Return <br/> 返回 | Method <br/> 方法 | 
| - | - |
| AsyncTask | <br/> `ControlRequestTask`(Activity activity, byte peripheralId, [ControlRequestTask.Callback](#ControlRequestTask.Callback) callback) <br/><br/> Door Lock Control Request <br/> activity: Activity <br/> peripheralId: Peripheral ID <br/> callback: Callback <br/><br/> 反馈门锁控制请求 <br/> activity: 活动 <br/> peripheralId: 分机 ID <br/> callback: 回调处理 |
| AsyncTask | <br/> `ControlRequestTask`(Activity activity, byte peripheralId, boolean manipulatorOnOff, [ControlRequestTask.Callback](#ControlRequestTask.Callback) callback) <br/><br/> Manipulator Control Request <br/> activity: 活动 <br/> peripheralId: 分机 ID <br/> manipulatorOnOff: Manipulator On Off <br/> callback: Callback <br/><br/> 机械手控制请求 <br/> activity: 活动 <br/> peripheralId: 分机 ID <br/> manipulatorOnOff: 机械手开关 <br/> callback: 回调处理 |
| AsyncTask | <br/> `ControlRequestTask`(Activity activity, byte peripheralId, [AcPanelStateInfo](../define/ThermostatState.md) thermostatState, [ControlRequestTask.Callback](#ControlRequestTask.Callback) callback) <br/><br/> Thermostat Control Request <br/> activity: Activity <br/> peripheralId: Peripheral ID <br/> thermostatState: Thermostat State <br/> callback: Callback <br/><br/> 温控面板控制请求 <br/> activity: 活动 <br/> peripheralId: 分机 ID <br/> thermostatState: 温控面板状态 <br/> callback: 回调处理 |
| AsyncTask | <br/> `ControlRequestTask`(Activity activity, byte peripheralId, [CurtainControlType](../define/CurtainControlType.md) curtainControlType, Byte curtainProgress, [ControlRequestTask.Callback](#ControlRequestTask.Callback) callback) <br/><br/> Curtain Control Request <br/> activity: Activity <br/> peripheralId: Peripheral ID <br/> curtainControlType: Curtain Control Type <br/> curtainProgress: Curtain Progress，only effective when control progress，0～100 <br/> callback: Callback <br/><br/> 反馈窗帘控制请求 <br/> activity: 活动 <br/> peripheralId: 分机 ID <br/> curtainControlType: 窗帘控制类型 <br/> curtainProgress: 进度，在控制进度时才有效，0～100 <br/> callback: 回调处理 |
| AsyncTask | <br/> `ControlRequestTask`(Activity activity, byte peripheralId, [SwitchControlInfo](../define/SwitchControlInfo.md) switchControlInfo, [ControlRequestTask.Callback](#ControlRequestTask.Callback) callback) <br/><br/> Switch Control Request <br/> activity: Activity <br/> peripheralId: Peripheral ID <br/> switchControlInfo: Switch Control Info <br/> callback: Callback <br/><br/> 反馈开关控制请求 <br/> activity: 活动 <br/> peripheralId: 分机 ID <br/> switchControlInfo: 反馈开关控制结构体 <br/> callback: 回调处理 |

## ControlRequestTask.Callback
| Return <br/> 返回 | Method <br/> 方法 | 
| - | - |
| void | <br/> `onResponse`([StatusType](../define/StatusType.md) status) <br/><br/> On Response <br/> status: Status <br/><br/> 请求回调 <br/> status: 回复状态 |
